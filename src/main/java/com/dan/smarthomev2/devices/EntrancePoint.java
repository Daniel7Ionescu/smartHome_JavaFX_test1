package com.dan.smarthomev2.devices;

import com.dan.smarthomev2.test_enum_interface.DeviceStatus;
import com.dan.smarthomev2.test_enum_interface.Lockable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class EntrancePoint extends Device implements Lockable {

    DeviceStatus deviceStatus;

    public EntrancePoint(Shape shape) {
        super(shape);
        deviceStatus = DeviceStatus.ON;
        setShapeColor();
    }
    //used for rain / smoke alarm events
    public void forceOpenCloseEntrancePoint(String command){
        if(command.equalsIgnoreCase("open")){
            deviceStatus = DeviceStatus.ON;
        } else if (command.equalsIgnoreCase("close")) {
            deviceStatus = deviceStatus.equals(DeviceStatus.LOCKED) ? DeviceStatus.LOCKED : DeviceStatus.OFF;
        }
        setShapeColor();
    }

    @Override
    public void toggleLock(){
        deviceStatus = deviceStatus.equals(DeviceStatus.LOCKED) ? DeviceStatus.ON : DeviceStatus.LOCKED;
        setShapeColor();
    }


    @Override
    public void toggle() {
        deviceStatus = deviceStatus.equals(DeviceStatus.ON) ? DeviceStatus.OFF : DeviceStatus.ON;
        setShapeColor();
    }

    @Override
    public String getStatusString() {
        if(deviceStatus.equals(DeviceStatus.ON)){
            return "OPEN";
        } else if(deviceStatus.equals(DeviceStatus.OFF)){
            return "CLOSED";
        }
        return deviceStatus.toString();
    }

    @Override
    public void setShapeColor() {
        if (deviceStatus.equals(DeviceStatus.ON)) {
            getShape().setFill(Color.WHITE);
        } else if (deviceStatus.equals(DeviceStatus.OFF)) {
            getShape().setFill(Color.DARKGRAY);
        } else if (deviceStatus.equals(DeviceStatus.LOCKED)) {
            getShape().setFill(Color.RED);
        }
    }

    @Override
    public String toString() {
        return "Device type: Entrance Point - " + getDeviceType() +
                "\nName: " + getDeviceName() + " Status: " + getStatusString();
    }
}
