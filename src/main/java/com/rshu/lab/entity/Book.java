package com.rshu.lab.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book implements Entity {

    private int bookID;
    private String title;
    private String author;
    private int pledge;
    private int rentalPrice;
    private String genre;

    public Book(String title, String author, int pledge, int rentalPrice, String genre) {
        this.title = title;
        this.author = author;
        this.pledge = pledge;
        this.rentalPrice = rentalPrice;
        this.genre = genre;
    }

    public Book(int bookID, String title, String author, int pledge, int rentalPrice, String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.pledge = pledge;
        this.rentalPrice = rentalPrice;
        this.genre = genre;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPledge() {
        return pledge;
    }

    public void setPledge(int pledge) {
        this.pledge = pledge;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return bookID + ": " + title + " - " + author;
    }

    public IntegerProperty getBookIDProp() {
        return new SimpleIntegerProperty(bookID);
    }

    public StringProperty getTitleProp() {
        return new SimpleStringProperty(title);
    }

    public StringProperty getAuthorProp() {
        return new SimpleStringProperty(author);
    }

    public IntegerProperty getPledgeProp() {
        return new SimpleIntegerProperty(pledge);
    }

    public IntegerProperty getRentalPriceProp() {
        return new SimpleIntegerProperty(rentalPrice);
    }

    public StringProperty getGenreProp() {
        return new SimpleStringProperty(genre);
    }

}
