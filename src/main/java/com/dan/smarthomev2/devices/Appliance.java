package com.dan.smarthomev2.devices;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Appliance extends Device{

    public Appliance(Shape shape, String deviceType) {
        super(shape, deviceType);
        setStatus(0);
        setShapeColor();
    }

    @Override
    public void setShapeColor() {
        if (getStatus() == 0) {
            getShape().setFill(Color.CYAN);
        } else if (getStatus() == 1) {
            getShape().setFill(Color.DODGERBLUE);
        }
    }

    @Override
    public void toggleOnOff() {
        toggleStatus();
        setShapeColor();
        statusNumberToText();
    }

    @Override
    public void statusNumberToText() {
        String result = "";
        if (getStatus() == 0) {
            result = "Turned on";
        } else if (getStatus() == 1) {
            result = "Turned off";
        }
        setStatusText(result);
    }

    @Override
    public String toString() {
        return "Device type: Entrance Point - " + getDeviceType() +
                "\nName: " + getDeviceName() + " Status: " + getStatus();
    }
}
