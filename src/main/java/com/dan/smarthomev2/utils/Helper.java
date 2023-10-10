package com.dan.smarthomev2.utils;

import javafx.scene.shape.Shape;

public class Helper {
    public static String getDeviceType(Shape shape) {
        String deviceID = shape.getId();
        return deviceID.split("_")[0];
    }
}
