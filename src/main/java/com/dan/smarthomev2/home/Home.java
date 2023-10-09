package com.dan.smarthomev2.home;

import com.dan.smarthomev2.devices.Appliance;
import com.dan.smarthomev2.devices.Device;
import com.dan.smarthomev2.devices.EntrancePoint;
import com.dan.smarthomev2.devices.Light;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Home {

    private List<Device> devices;

    public Home(){
        devices = new ArrayList<>();
    }

    public Device createDevice(Shape shape){
        String deviceType = Device.extractDeviceType(shape);

        //create door or window
        if(deviceType.equalsIgnoreCase("door") || deviceType.equalsIgnoreCase("window")){
            return new EntrancePoint(shape, deviceType);
        }
        //light
        else if (deviceType.equalsIgnoreCase("light")) {
            return new Light(shape, deviceType);
        }
        //appliance
        else if (deviceType.equalsIgnoreCase("app")) {
            return new Appliance(shape, deviceType);
        }
        return null;
    }

    public int getDeviceObjIndex(String id){
        int index = -1;
        for(Device device : devices){
            if(id.equalsIgnoreCase(device.getFullDeviceId())){
                index = devices.indexOf(device);
            }
        }
        return index;
    }

    public void addDevice(Device device){
        devices.add(device);
    }

    public void printDevices(){
        for(Device device : devices){
            System.out.println(device);
        }
    }

    public List<Device> getDevices() {
        return devices;
    }
}
