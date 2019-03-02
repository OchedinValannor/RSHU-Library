package com.rshu.lab.service;

import com.rshu.lab.dao.ReaderDao;
import com.rshu.lab.entity.Reader;

import java.util.ArrayList;
import java.util.List;

public class ReaderService {

    private ReaderDao readerDao;

    public ReaderService(ReaderDao readerDao) {
        this.readerDao = readerDao;
    }

    public void add(Reader reader) {
        readerDao.add(reader);
    }

    public void remove(Reader reader) {
        readerDao.remove(reader);
    }

    public void update(Reader reader) {
        readerDao.update(reader);
    }

    public Reader getByID(int id) {
        return readerDao.getByID(id);
    }

    public List<Reader> getAll() {
        return readerDao.getAll();
    }

    public List<String> getStrings() {
        List<String> idName = new ArrayList<>();
        for (Reader reader : getAll()) {
            String s = reader.toString();
            idName.add(s);
        }

        return idName;
    }
}
