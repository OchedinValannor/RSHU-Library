package com.rshu.lab.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Reader implements Entity {

    private int readerID;
    private String surname;
    private String firstName;
    private String patronymic;
    private String homeAddress;
    private int phoneNumber;

    public Reader(String surname, String firstName, String patronymic, String homeAddress, int phoneNumber) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
    }

    public Reader(int readerID, String surname, String firstName, String patronymic, String homeAddress, int phoneNumber) {
        this.readerID = readerID;
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
    }

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return readerID + ": " + surname + " " + firstName;
    }

    public IntegerProperty getReaderIDProp() {
        return new SimpleIntegerProperty(readerID);
    }

    public StringProperty getSurnameProp() {
        return new SimpleStringProperty(surname);
    }

    public StringProperty getFirstNameProp() {
        return new SimpleStringProperty(firstName);
    }

    public StringProperty getPatronymicProp() {
        return new SimpleStringProperty(patronymic);
    }

    public StringProperty getHomeAddressProp() {
        return new SimpleStringProperty(homeAddress);
    }

    public IntegerProperty getPhoneNumberProp() {
        return new SimpleIntegerProperty(phoneNumber);
    }

}
