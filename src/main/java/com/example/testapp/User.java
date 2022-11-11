package com.example.testapp;

public class User {
    private String carType;
    private String carID;
    private String carLevel;
    private String userName;
    private String userFamilyName;
    private String passport;
    private String dataOfExpiryPassport;
    private String driverLicense;
    private String dataOfExpiryDriverLicense;
    private String dataOfIssue;
    private String dataOfExpiry;
    private String currentStatus;
    private String phoneNumber;

    public User() { }

    public User(String carType, String carID, String carLevel,
                String userName, String userFamilyName, String passport,
                String dataOfExpiryPassport, String driverLicense,
                String dataOfExpiryDriverLicense, String dataOfIssue,
                String dataOfExpiry, String currentStatus, String phoneNumber) {
        this.carType = carType;
        this.carID = carID;
        this.carLevel = carLevel;
        this.userName = userName;
        this.userFamilyName = userFamilyName;
        this.passport = passport;
        this.dataOfExpiryPassport = dataOfExpiryPassport;
        this.driverLicense = driverLicense;
        this.dataOfExpiryDriverLicense = dataOfExpiryDriverLicense;
        this.dataOfIssue = dataOfIssue;
        this.dataOfExpiry = dataOfExpiry;
        this.currentStatus = currentStatus;
        this.phoneNumber = phoneNumber;

    }

    public User(String carType, String carID,
                String carLevel, String currentStatus) {
        this.carType = carType;
        this.carID = carID;
        this.carLevel = carLevel;
        this.currentStatus = currentStatus;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getCarLevel() {
        return carLevel;
    }

    public void setCarLevel(String carLevel) {
        this.carLevel = carLevel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFamilyName() {
        return userFamilyName;
    }

    public void setUserFamilyName(String userFamilyName) {
        this.userFamilyName = userFamilyName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDataOfExpiryPassport() {
        return dataOfExpiryPassport;
    }

    public void setDataOfExpiryPassport(String dataOfExpiryPassport) {
        this.dataOfExpiryPassport = dataOfExpiryPassport;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getDataOfExpiryDriverLicense() {
        return dataOfExpiryDriverLicense;
    }

    public void setDataOfExpiryDriverLicense(String dataOfExpiryDriverLicense) {
        this.dataOfExpiryDriverLicense = dataOfExpiryDriverLicense;
    }

    public String getDataOfIssue() {
        return dataOfIssue;
    }

    public void setDataOfIssue(String dataOfIssue) {
        this.dataOfIssue = dataOfIssue;
    }

    public String getDataOfExpiry() {
        return dataOfExpiry;
    }

    public void setDataOfExpiry(String dataOfExpiry) {
        this.dataOfExpiry = dataOfExpiry;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
