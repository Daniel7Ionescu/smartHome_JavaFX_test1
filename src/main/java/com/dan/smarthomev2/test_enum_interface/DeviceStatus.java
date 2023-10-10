package com.dan.smarthomev2.test_enum_interface;

//extends abstract class Enum
public enum DeviceStatus {

    ON(0),
    OFF(1),
    LOCKED(2);

    private final int statusAccessRank; //to use for User access


    DeviceStatus(int statusAccessRank){
        this.statusAccessRank = statusAccessRank;
    }

    public int getStatusAccessRank() {
        return statusAccessRank;
    }
}