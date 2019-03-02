package com.rshu.lab.entity;

import com.rshu.lab.DateStringConverter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class RecordData implements Entity {

    private int recordID;
    private int bookID;
    private String title;
    private int readerID;
    private String surname;
    private int rentalPrice;
    private Date issueDate;
    private Date returnDate;
    private int totalDays;
    private int totalRent;

    public RecordData(int recordID, int bookID, String title,
                      int readerID, String surname, int rentalPrice,
                      Date issueDate, Date returnDate,
                      int totalDays, int totalRent) {

        this.recordID = recordID;
        this.bookID = bookID;
        this.title = title;
        this.readerID = readerID;
        this.surname = surname;
        this.rentalPrice = rentalPrice;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.totalDays = totalDays;
        this.totalRent = totalRent;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public int getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(int totalRent) {
        this.totalRent = totalRent;
    }

    @Override
    public String toString() {
        return "RecordData{" +
                "recordID=" + recordID +
                ", bookID=" + bookID +
                ", title='" + title + '\'' +
                ", readerID=" + readerID +
                ", surname='" + surname + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", totalDays=" + totalDays +
                ", totalRent=" + totalRent +
                '}';
    }

    public IntegerProperty getRecordIDProp() {
        return new SimpleIntegerProperty(recordID);
    }

    public IntegerProperty getBookIDProp() {
        return new SimpleIntegerProperty(bookID);
    }

    public StringProperty getTitleProp() {
        return new SimpleStringProperty(title);
    }

    public IntegerProperty getReaderIDProp() {
        return new SimpleIntegerProperty(readerID);
    }

    public StringProperty getSurnameProp() {
        return new SimpleStringProperty(surname);
    }

    public IntegerProperty getRentalPriceProp() {
        return new SimpleIntegerProperty(rentalPrice);
    }

    public StringProperty getIssueDateProp() {
        return new SimpleStringProperty(DateStringConverter.convertToString(issueDate));
    }

    public StringProperty getReturnDateProp() {
        return new SimpleStringProperty(DateStringConverter.convertToString(returnDate));
    }

    public IntegerProperty getTotalDaysProp() {
        return new SimpleIntegerProperty(totalDays);
    }

    public IntegerProperty getTotalRentProp() {
        return new SimpleIntegerProperty(totalRent);
    }

}
