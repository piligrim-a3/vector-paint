package ru.bgpu.mvntest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.util.Random;

public class Main {

    private static final Logger logger
            = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Start program");
        JFrame frame = new JFrame("Vector Pain 0.1 alpha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PaintPanel paintPanel = new PaintPanel();
        frame.setContentPane(paintPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
