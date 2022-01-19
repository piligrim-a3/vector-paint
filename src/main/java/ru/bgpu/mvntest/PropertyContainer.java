package ru.bgpu.mvntest;

import java.lang.reflect.InvocationTargetException;

public interface PropertyContainer extends FigureEditListener {
    void setValue() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException;
}
