package com.rshu.lab.dao;

import com.rshu.lab.entity.Reader;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReaderDao extends Dao<Reader> {

    public ReaderDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public void add(Reader reader) {

        jdbcTemplate.update(
                "INSERT INTO Reader (Surname, FirstName, Patronymic, HomeAddress, PhoneNumber) VALUES (?, ?, ?, ?, ?)",
                reader.getSurname(), reader.getFirstName(), reader.getPatronymic(),
                reader.getHomeAddress(), reader.getPhoneNumber());
    }

    public void remove(Reader reader) {

        jdbcTemplate.update("DELETE FROM Reader WHERE ReaderID=(?)", reader.getReaderID());
    }

    public void update(Reader reader) {

        jdbcTemplate.update(
                "UPDATE Reader SET Surname=(?), FirstName=(?), Patronymic=(?), HomeAddress=(?), PhoneNumber=(?) WHERE ReaderID=(?)",
                reader.getSurname(), reader.getFirstName(), reader.getPatronymic(),
                reader.getHomeAddress(), reader.getPhoneNumber(), reader.getReaderID());
    }

    public Reader getByID(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM Reader WHERE ReaderID=(?)",
                new Object[]{id},
                ((resultSet, i) -> new Reader(
                            id,
                            resultSet.getString("Surname"),
                            resultSet.getString("FirstName"),
                            resultSet.getString("Patronymic"),
                            resultSet.getString("HomeAddress"),
                            resultSet.getInt("PhoneNumber")
                    )));
    }

    public List<Reader> getAll() {

        return jdbcTemplate.query("SELECT * FROM Reader",
                ((resultSet, i) -> new Reader(
                            resultSet.getInt("ReaderID"),
                            resultSet.getString("Surname"),
                            resultSet.getString("FirstName"),
                            resultSet.getString("Patronymic"),
                            resultSet.getString("HomeAddress"),
                            resultSet.getInt("PhoneNumber")
                    )));
    }
}
