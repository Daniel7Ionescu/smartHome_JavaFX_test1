package com.dan.smarthomev2.devices;

import javafx.scene.shape.Shape;

public abstract class Device {

    private String fullDeviceId;
    private String deviceName;
    private String deviceType;
    private int status;
    private String statusText;
    private Shape shape;

    public abstract void toggleOnOff();
    public abstract void statusNumberToText();
    public abstract void setShapeColor();

    public Device(Shape shape, String deviceType) {
        this.shape = shape;
        this.deviceType = deviceType;
        deviceName = setFormattedName(shape);
        fullDeviceId = shape.getId();
    }

    public void toggleStatus() {
        status = status == 0 ? 1 : 0;
    }

    public static String extractDeviceType(Shape shape) {
        String deviceID = shape.getId();
        return deviceID.split("_")[0];
    }

    private String setFormattedName(Shape shape) {
        String shapeId = shape.getId();
        String[] strArr = shapeId.split("_");
        StringBuilder formattedName = new StringBuilder(strArr[0].toUpperCase() + ": ");
        for (int index = 1; index < strArr.length; index++) {
            formattedName.append(strArr[index]).append(" ");
        }
        return formattedName.toString();
    }

    public void forceOpenCloseDevice(String command){
        if(command.equalsIgnoreCase("open")){
            status = 0;
        } else if(command.equalsIgnoreCase("close")){
            status = 1;
        }
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Shape getShape() {
        return shape;
    }

    public String getFullDeviceId() {
        return fullDeviceId;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
}
