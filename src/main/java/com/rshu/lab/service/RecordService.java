package com.rshu.lab.service;

import com.rshu.lab.dao.RecordDao;
import com.rshu.lab.dao.RecordDataDao;
import com.rshu.lab.entity.Record;
import com.rshu.lab.entity.RecordData;

import java.util.Date;
import java.util.List;

public class RecordService {

    private RecordDao recordDao;
    private RecordDataDao recordDataDao;

    public RecordService(RecordDao recordDao, RecordDataDao recordDataDao) {
        this.recordDao = recordDao;
        this.recordDataDao = recordDataDao;
    }

    public void add(Record record) {
        recordDao.add(record);
    }

    public void remove(Record record) {
        recordDao.remove(record);
    }

    public void update(Record record) {
        recordDao.update(record);
    }

    public Record getByID(int id) {
        return recordDao.getByID(id);
    }

    public List<Record> getAll() {
        return recordDao.getAll();
    }


    //finished-unfinished
    public List<RecordData> getFinished() {
        return recordDataDao.getFinished();
    }

    public List<RecordData> getUnfinished() {
        return recordDataDao.getUnfinished();
    }


    //Meta-data
    public List<RecordData> getAllMetaData() {
        return recordDataDao.getAll();
    }

    public List<RecordData> getMetaDataAfterDate(Date from) {
        return recordDataDao.getAfterDate(from);
    }

    public List<RecordData> getMetaDataBeforeDate(Date till) {
        return recordDataDao.getBeforeDate(till);
    }

    public List<RecordData> getMetaDataInPeriod(Date from, Date till) {
        return recordDataDao.getByDates(from, till);
    }


    //Calculations
    public int incomeAfterDate(Date from) {
        return recordDataDao.incomeAfterDate(from);
    }

    public int incomeBeforeDate(Date till) {
        return recordDataDao.incomeBeforeDate(till);
    }

    public int incomeInPeriod(Date from, Date till) {
        return recordDataDao.incomeInPeriod(from, till);
    }

    public int totalIncome() {
        return recordDataDao.totalIncome();
    }
}
