package com.example.testapp;

public class Cars {
    private String carType;
    private String carIP;
    private String carLevel;
    private String currentStatus;

    public Cars() { }


    public Cars(String carType, String carIP,
                String carLevel, String currentStatus) {
        this.carType = carType;
        this.carIP = carIP;
        this.carLevel = carLevel;
        this.currentStatus = currentStatus;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarIP() {
        return carIP;
    }

    public void setCarIP(String carIP) {
        this.carIP = carIP;
    }

    public String getCarLevel() {
        return carLevel;
    }

    public void setCarLevel(String carLevel) {
        this.carLevel = carLevel;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }


}
