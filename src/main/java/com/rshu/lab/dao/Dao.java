package com.rshu.lab.dao;

import com.rshu.lab.entity.Entity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class Dao<T extends Entity> {

    protected JdbcTemplate jdbcTemplate;

    public Dao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public abstract void add(T entity);

    public abstract void remove(T entity);

    public abstract void update(T entity);

    public abstract T getByID(int id);

    public abstract List<T> getAll();

}
