package com.co.gocho.movies.data;

import com.co.gocho.movies.model.Genre;
import com.co.gocho.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MovieRepositoryJdbcImpl implements MovieRepository {

    JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("select * from movies where id = ?",args,movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("select * from movies",movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

        jdbcTemplate.update("insert into movies(name,minutes,genre) values(?,?,?)",
                movie.getName(),movie.getMinutes(),movie.getGenre().toString());

    }

    private  static RowMapper<Movie> movieMapper = (resultSet, i) -> new Movie(resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("minutes"),
            Genre.valueOf(resultSet.getString("genre")));
}
