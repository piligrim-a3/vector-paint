package ru.bgpu.mvntest;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class IntPropertyContainer implements PropertyContainer {

    private JTextField input;
    private Field field;
    private Figure figure;

    public IntPropertyContainer(JTextField input, Field field, Figure figure) {
        this.input = input;
        this.field = field;
        this.figure = figure;
    }

    @Override
    public void setValue() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        figure.getClass().getMethod(
                "set" + field.getName().substring(0, 1).toUpperCase()
                        + field.getName().substring(1),
                int.class
        ).invoke(figure, Integer.parseInt(input.getText()));
    }
}
