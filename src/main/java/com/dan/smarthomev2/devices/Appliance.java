package com.dan.smarthomev2.devices;

import com.dan.smarthomev2.test_enum_interface.DeviceStatus;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Appliance extends Device{

    DeviceStatus deviceStatus;
    private double Volume;

    public Appliance(Shape shape) {
        super(shape);
        deviceStatus = DeviceStatus.OFF;
        setShapeColor();
    }



    @Override
    public void toggle() {
        deviceStatus = deviceStatus.equals(DeviceStatus.ON) ? DeviceStatus.OFF : DeviceStatus.ON;
        setShapeColor();
    }

    @Override
    public void setShapeColor() {
        if (deviceStatus.equals(DeviceStatus.ON)) {
            getShape().setFill(Color.CYAN);
        } else if (deviceStatus.equals(DeviceStatus.OFF)) {
            getShape().setFill(Color.DARKMAGENTA);
        }
    }

    @Override
    public String getStatusString() {
        return deviceStatus.toString();
    }

    @Override
    public String toString() {
        return "Device type: Entrance Point - " + getDeviceType() +
                "\nName: " + getDeviceName() + " Status: " + getStatusString();
    }
}
