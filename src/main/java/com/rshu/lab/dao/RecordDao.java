package com.rshu.lab.dao;

import com.rshu.lab.entity.Record;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RecordDao extends Dao<Record> {

    public RecordDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public void add(Record record) {

        jdbcTemplate.update(
                "INSERT INTO Record (BookID, ReaderID, IssueDate, ReturnDate) VALUES (?, ?, ?, ?)",
                record.getBookID(), record.getReaderID(), record.getIssueDate(), record.getReturnDate());
    }

    public void remove(Record record) {

        jdbcTemplate.update("DELETE FROM Record WHERE RecordID=(?)", record.getRecordID());
    }

    public void update(Record record) {

        jdbcTemplate.update(
                "UPDATE Record SET BookID=(?), ReaderID=(?), IssueDate=(?), ReturnDate=(?) WHERE RecordID=(?)",
                record.getBookID(), record.getReaderID(), record.getIssueDate(), record.getReturnDate(), record.getRecordID());
    }

    public Record getByID(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM Record WHERE RecordID=(?)",
                new Object[]{id},
                ((resultSet, i) -> new Record(
                        id,
                        resultSet.getInt("BookID"),
                        resultSet.getInt("ReaderID"),
                        resultSet.getDate("IssueDate"),
                        resultSet.getDate("ReturnDate")
                )));
    }

    public List<Record> getAll() {

        return jdbcTemplate.query("SELECT * FROM Record",
                ((resultSet, i) -> new Record(
                        resultSet.getInt("RecordID"),
                        resultSet.getInt("BookID"),
                        resultSet.getInt("ReaderID"),
                        resultSet.getDate("IssueDate"),
                        resultSet.getDate("ReturnDate")
                )));
    }

//    public int incomeAfterDate(Date from) {
//        return jdbcTemplate.queryForObject(
//                "SELECT SUM(RentalPrice) FROM Rent_Date WHERE IssueDate>?",
//                new Object[]{from}, Integer.class);
//    }
//
//    public int incomeBeforeDate(Date till) {
//        return jdbcTemplate.queryForObject(
//                "SELECT SUM(RentalPrice) FROM Rent_Date WHERE ReturnDate<?",
//                new Object[]{till}, Integer.class);
//    }
//
//    public int incomeInPeriod(Date from, Date till) {
//        return jdbcTemplate.queryForObject(
//                "SELECT SUM(RentalPrice) FROM Rent_Date WHERE IssueDate>? AND ReturnDate<?",
//                new Object[]{from, till}, Integer.class);
//    }
//
//    public int totalIncome() {
//        return jdbcTemplate.queryForObject("SELECT SUM(RentalPrice) FROM Rent_Date", Integer.class);
//    }
}
