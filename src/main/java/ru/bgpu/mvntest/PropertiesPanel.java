package ru.bgpu.mvntest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class PropertiesPanel extends JPanel {

    private JFrame frame;

    private static final Logger logger
            = LoggerFactory.getLogger(PropertiesPanel.class);

    private JPanel configPanel = new JPanel();
    private JButton okButton = new JButton("OK");
    private Figure figure;

    private ArrayList<PropertyContainer> containers = new ArrayList<>();

    PropertiesPanel(JFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(200, 100));
        setLayout(new BorderLayout());
        add(configPanel, BorderLayout.NORTH);
        setIgnoreRepaint(false);
        okButton.addActionListener((event) -> {
            containers.forEach(container -> {
                try {
                    container.setValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            frame.repaint();
        });
    }

    public void setFigure(Figure figure) {
        Class figureClass = figure.getClass();
        configPanel.setLayout(new GridLayout(
                figure.getClass().getDeclaredFields().length+1,2
        ));
        configPanel.removeAll();
        if(this.figure != null) {
            containers.forEach(
                    container -> this.figure.removeFigureEditListener(container)
            );
        }
        containers.clear();
        for(Field field: figure.getClass().getDeclaredFields()) {
            String fieldName = field.getName();
            configPanel.add(new JLabel(fieldName));
            try {
                Object value = figureClass.getMethod(
                        "get" + fieldName.substring(0, 1).toUpperCase()
                                + fieldName.substring(1)
                ).invoke(figure);
                if (field.getType().equals(int.class)) {
                    JTextField input = new JTextField();
                    input.setText(value.toString());
                    PropertyContainer container = new IntPropertyContainer(
                            input, field, figure
                    );
                    figure.addFigureEditListener(container);
                    containers.add(container);
                    configPanel.add(input);
                } else {
                    configPanel.add(new JLabel(value.toString()));
                }
            } catch (Exception e) {
                configPanel.add(new JLabel("error..."));
            }
        }
        this.figure = figure;
        configPanel.add(new JLabel(""));
        configPanel.add(okButton);
        frame.pack();
    }
}
