package com.rshu.lab.service;

import com.rshu.lab.dao.BookDao;
import com.rshu.lab.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void add(Book book) {
        bookDao.add(book);
    }

    public void remove(Book book) {
        bookDao.remove(book);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public Book getByID(int id) {
        return bookDao.getByID(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public List<String> getStrings() {
        List<String> idTitle = new ArrayList<>();
        for (Book book : getAll()) {
            String s = book.toString();
            idTitle.add(s);
        }

        return idTitle;
    }
}
