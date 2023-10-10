package com.dan.smarthomev2;

import com.dan.smarthomev2.devices.Device;
import com.dan.smarthomev2.devices.EntrancePoint;
import com.dan.smarthomev2.home.Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.util.ArrayList;
import java.util.List;

public class SceneHomeController {

    @FXML
    TextField announcer;
    //doors
    @FXML
    Rectangle door_Entrance, door_Master_Bedroom, door_Living_To_Dining, door_Bedroom;
    //windows
    @FXML
    Rectangle window_Bedroom, window_Living_Room, window_Master_Bedroom, window_Dining_Room;
    //lights
    @FXML
    Rectangle light_Bedroom, light_Living_Room, light_Dining_Room, light_Master_Bedroom;
    //appliances - app
    @FXML
    Rectangle app_Widescreen_TV;
    private boolean isDataLoaded = false;
    Home home;

    public void useDevice(MouseEvent mouseEvent){
        //find the id on what was clicked on
        String id = mouseEvent.getPickResult().getIntersectedNode().getId();
        //find its index in the home list
        int deviceIndex = home.getDeviceObjIndex(id);
        //toggle on/off
        home.getDevices().get(deviceIndex).toggle();

        //announcer message
        StringBuilder message = new StringBuilder();
        message.append(home.getDevices().get(deviceIndex).getDeviceName());
        message.append(" is now - ").append(home.getDevices().get(deviceIndex).getStatusString());
        announcer.setText(message.toString());
    }

    public void toggleLockEntrancePoint(ScrollEvent scrollEvent){
        //find the id on what was clicked on
        String id = scrollEvent.getPickResult().getIntersectedNode().getId();
        //find its index in the home list
        int deviceIndex = home.getDeviceObjIndex(id);

        //check if scene element is valid and toggle locked/on
        if(home.getDevices().get(deviceIndex) instanceof EntrancePoint entrancePoint){
            entrancePoint.toggleLock();
            //announcer message
            StringBuilder message = new StringBuilder();
            message.append(home.getDevices().get(deviceIndex).getDeviceName());
            message.append(" is now - ").append(home.getDevices().get(deviceIndex).getStatusString());
            announcer.setText(message.toString());
        } else {
            System.out.println("Invalid event on element: " + scrollEvent.getTarget());
        }
    }

    public void loadData(MouseEvent mouseEvent){
        if(!isDataLoaded){
            home = new Home();
            List<Shape> sceneIds = new ArrayList<>(List.of(window_Bedroom, window_Living_Room, window_Dining_Room, window_Master_Bedroom,
                                                           door_Entrance, door_Master_Bedroom, door_Living_To_Dining, door_Bedroom,
                                                           light_Bedroom, light_Living_Room, light_Dining_Room, light_Master_Bedroom,
                                                           app_Widescreen_TV));

            for(Shape shape : sceneIds){
                home.addDevice(home.createDevice(shape));
            }

            home.printDevices();
            System.out.println("Data is loaded.");
            isDataLoaded = true;
        }
    }

    //test events
    @FXML
    public void startRain(){
        for(Device device : home.getDevices()){
            //using 'device instanceof EntrancePoint entrancePoint' gives a local variable 'entrancePoint' instead of casting EntrancePoint
            if(device instanceof EntrancePoint entrancePoint && device.getDeviceType().equalsIgnoreCase("window")){
//                ((EntrancePoint) device).forceOpenCloseEntrancePoint("close");
                entrancePoint.forceOpenCloseEntrancePoint("close");
            }
        }
        announcer.setText("Rain is starting, closing all windows.");
    }
    @FXML
    public void smokeAlarm(){
        for(Device device : home.getDevices()){
            if(device instanceof EntrancePoint entrancePoint){
                entrancePoint.forceOpenCloseEntrancePoint("open");
            }
        }
        announcer.setText("Smoke Alarm triggered opening all windows and doors");
    }
}
