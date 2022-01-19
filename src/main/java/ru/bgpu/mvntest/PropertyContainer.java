package ru.bgpu.mvntest;

import java.lang.reflect.InvocationTargetException;

public interface PropertyContainer {
    void setValue() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException;
}
