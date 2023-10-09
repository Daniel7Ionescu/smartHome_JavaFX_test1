package com.dan.smarthomev2;

import com.dan.smarthomev2.devices.Device;
import com.dan.smarthomev2.devices.EntrancePoint;
import com.dan.smarthomev2.home.Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
        String id = mouseEvent.getPickResult().getIntersectedNode().getId();
        int deviceIndex = home.getDeviceObjIndex(id);
        home.getDevices().get(deviceIndex).toggleOnOff();

        //announcer message
        StringBuilder message = new StringBuilder();
        message.append(home.getDevices().get(deviceIndex).getDeviceName());
        message.append(" is now - ").append(home.getDevices().get(deviceIndex).getStatusText());
        announcer.setText(message.toString());
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

    public void startRain(ActionEvent event){
        for(Device device : home.getDevices()){
            if(device instanceof EntrancePoint && device.getDeviceType().equalsIgnoreCase("window")){
                ((EntrancePoint) device).forceOpenCloseEntrancePoint("close");
            }
        }
        announcer.setText("Rain is starting, closing all open windows.");
    }

    public void smokeAlarm(ActionEvent event){
        for(Device device : home.getDevices()){
            if(device instanceof EntrancePoint){
                ((EntrancePoint) device).forceOpenCloseEntrancePoint("open");
            }
        }
        announcer.setText("Smoke Alarm triggered opening all windows and doors");
    }
}
