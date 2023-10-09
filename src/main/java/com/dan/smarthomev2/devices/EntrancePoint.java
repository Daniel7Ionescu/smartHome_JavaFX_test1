package com.dan.smarthomev2.devices;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class EntrancePoint extends Device {
    public EntrancePoint(Shape shape, String deviceType) {
        super(shape, deviceType);
        setStatus(1);
        setShapeColor();
    }

    @Override
    public void setShapeColor() {
        if (getStatus() == 0) {
            getShape().setFill(Color.WHITE);
        } else if (getStatus() == 1) {
            getShape().setFill(Color.DARKGRAY);
        } else if (getStatus() == 2) {
            getShape().setFill(Color.RED);
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
            result = "Open";
        } else if (getStatus() == 1) {
            result = "Closed";
        } else if (getStatus() == 2) {
            result = "Locked";
        }
        setStatusText(result);
    }

    @Override
    public String toString() {
        return "Device type: Entrance Point - " + getDeviceType() +
                "\nName: " + getDeviceName() + " Status: " + getStatus();
    }

    public void forceOpenCloseEntrancePoint(String command){
        forceOpenCloseDevice(command);
        setShapeColor();
    }


}
