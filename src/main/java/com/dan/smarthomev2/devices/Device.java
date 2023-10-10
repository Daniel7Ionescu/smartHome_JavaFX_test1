package com.dan.smarthomev2.devices;

import com.dan.smarthomev2.test_enum_interface.Toggleable;
import com.dan.smarthomev2.utils.Helper;
import javafx.scene.shape.Shape;

public abstract class Device implements Toggleable {

    private Shape shape;
    private String deviceType;
    private String deviceName;
    private String fullDeviceId;

    public Device(Shape shape) {
        this.shape = shape;
        deviceType = Helper.getDeviceType(shape);
        deviceName = setFormattedName(shape);
        fullDeviceId = shape.getId();
    }

    public abstract void setShapeColor();

    private String setFormattedName(Shape shape) {
        String shapeId = shape.getId();
        String[] strArr = shapeId.split("_");
        StringBuilder formattedName = new StringBuilder(strArr[0].toUpperCase() + ": ");
        for (int index = 1; index < strArr.length; index++) {
            formattedName.append(strArr[index]).append(" ");
        }
        return formattedName.toString();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public Shape getShape() {
        return shape;
    }

    public String getFullDeviceId() {
        return fullDeviceId;
    }
}
