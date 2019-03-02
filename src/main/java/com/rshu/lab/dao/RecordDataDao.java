package com.rshu.lab.dao;

import com.rshu.lab.entity.RecordData;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class RecordDataDao extends Dao<RecordData> {

    public RecordDataDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Deprecated
    public void add(RecordData entity) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void remove(RecordData entity) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void update(RecordData entity) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public RecordData getByID(int id) {
        throw new UnsupportedOperationException();
    }


    //finished-unfinished
    public List<RecordData> getFinished() {
        return jdbcTemplate.query(
                "SELECT * FROM record_meta_data WHERE ReturnDate<=?",
                new Object[]{new Date()},
                ((resultSet, i) -> getRecordData(resultSet)));
    }

    public List<RecordData> getUnfinished() {
        return jdbcTemplate.query(
                "SELECT * FROM record_meta_data WHERE ReturnDate>?",
                new Object[]{new Date()},
                ((resultSet, i) -> getRecordData(resultSet)));
    }


    //according dates
    public List<RecordData> getBeforeDate(Date till) {
        return jdbcTemplate.query(
                "SELECT * FROM record_meta_data WHERE ReturnDate<=?",
                new Object[]{till},
                ((resultSet, i) -> getRecordData(resultSet)));
    }

    public List<RecordData> getAfterDate(Date from) {
        return jdbcTemplate.query(
                "SELECT * FROM record_meta_data WHERE IssueDate>=?",
                new Object[]{from},
                ((resultSet, i) -> getRecordData(resultSet)));
    }

    public List<RecordData> getByDates(Date from, Date till) {
        return jdbcTemplate.query(
                "SELECT * FROM record_meta_data WHERE IssueDate>=? AND ReturnDate<=?",
                new Object[]{from, till},
                ((resultSet, i) -> getRecordData(resultSet)));
    }


    //all meta-data
    @Override
    public List<RecordData> getAll() {
        return jdbcTemplate.query("SELECT * FROM record_meta_data",
                ((resultSet, i) -> getRecordData(resultSet)));
    }


    private RecordData getRecordData(ResultSet resultSet) throws SQLException {
        return new RecordData(
                resultSet.getInt("recordID"),
                resultSet.getInt("BookID"),
                resultSet.getString("Title"),
                resultSet.getInt("ReaderID"),
                resultSet.getString("Surname"),
                resultSet.getInt("RentalPrice"),
                resultSet.getDate("IssueDate"),
                resultSet.getDate("ReturnDate"),
                resultSet.getInt("Total_days"),
                resultSet.getInt("Total_rent")
        );
    }


    //Income calculations
    public int incomeAfterDate(Date from) {
        return jdbcTemplate.queryForObject(
                "SELECT SUM(Total_rent) FROM record_meta_data WHERE IssueDate>?",
                new Object[]{from}, Integer.class);
    }

    public int incomeBeforeDate(Date till) {
        return jdbcTemplate.queryForObject(
                "SELECT SUM(Total_rent) FROM record_meta_data WHERE ReturnDate<?",
                new Object[]{till}, Integer.class);
    }

    public int incomeInPeriod(Date from, Date till) {
        return jdbcTemplate.queryForObject(
                "SELECT SUM(Total_rent) FROM record_meta_data WHERE IssueDate>? AND ReturnDate<?",
                new Object[]{from, till}, Integer.class);
    }

    public int totalIncome() {
        return jdbcTemplate.queryForObject("SELECT SUM(Total_rent) FROM record_meta_data", Integer.class);
    }
}
