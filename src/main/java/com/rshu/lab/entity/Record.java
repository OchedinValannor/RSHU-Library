package com.rshu.lab.entity;

import java.util.Date;

public class Record implements Entity {

    private int recordID;
    private int bookID;
    private int readerID;
    private Date issueDate;
    private Date returnDate;

    public Record(int bookID, int readerID, Date issueDate, Date returnDate) {
        this.bookID = bookID;
        this.readerID = readerID;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public Record(int recordID, int bookID, int readerID, Date issueDate, Date returnDate) {
        this.recordID = recordID;
        this.bookID = bookID;
        this.readerID = readerID;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
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

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
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

    @Override
    public String toString() {
        return "Record{" +
                "recordID=" + recordID +
                ", bookID=" + bookID +
                ", readerID=" + readerID +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
