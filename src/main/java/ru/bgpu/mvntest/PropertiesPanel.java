package ru.bgpu.mvntest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

public class PropertiesPanel extends JPanel {

    private static final Logger logger
            = LoggerFactory.getLogger(PropertiesPanel.class);

    PropertiesPanel() {
        setPreferredSize(new Dimension(200, 100));
    }

    public void setFigure(Figure figure) {
        for(Field field: figure.getClass().getDeclaredFields()) {
            logger.debug(field.getName());
        }
    }
}
