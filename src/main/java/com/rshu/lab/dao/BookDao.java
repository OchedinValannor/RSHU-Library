package com.rshu.lab.dao;

import com.rshu.lab.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDao extends Dao<Book> {

    public BookDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public void add(Book book) {

        jdbcTemplate.update(
                "INSERT INTO Book (Title, Author, Pledge, RentalPrice, Genre) VALUES (?, ?, ?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getPledge(), book.getRentalPrice(), book.getGenre());
    }

    public void remove(Book book) {

        jdbcTemplate.update("DELETE FROM Book WHERE BookID=(?)", book.getBookID());
    }

    public void update(Book book) {

        jdbcTemplate.update(
                "UPDATE Book SET Title=(?), Author=(?), Pledge=(?), RentalPrice=(?), Genre=(?) WHERE BookID=(?)",
                book.getTitle(), book.getAuthor(), book.getPledge(),
                book.getRentalPrice(), book.getGenre(), book.getBookID());
    }

    public Book getByID(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM Book WHERE BookID=(?)",
                new Object[]{id},
                ((resultSet, i) -> new Book(
                            id,
                            resultSet.getString("Title"),
                            resultSet.getString("Author"),
                            resultSet.getInt("Pledge"),
                            resultSet.getInt("RentalPrice"),
                            resultSet.getString("Genre")
                    )));
    }

    public List<Book> getAll() {

        return jdbcTemplate.query("SELECT * FROM Book",
                ((resultSet, i) -> new Book(
                            resultSet.getInt("BookID"),
                            resultSet.getString("Title"),
                            resultSet.getString("Author"),
                            resultSet.getInt("Pledge"),
                            resultSet.getInt("RentalPrice"),
                            resultSet.getString("Genre")
                    )));
    }
}
