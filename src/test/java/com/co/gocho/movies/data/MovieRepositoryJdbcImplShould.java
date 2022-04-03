package com.co.gocho.movies.data;

import com.co.gocho.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static com.co.gocho.movies.model.Genre.*;
import static org.junit.Assert.*;

public class MovieRepositoryJdbcImplShould {

    @Test
    public void load_all_movies() throws SQLException {

        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        MovieRepositoryJdbcImpl movieRepositoryJdbc = new MovieRepositoryJdbcImpl(jdbcTemplate);

         Collection<Movie> movies = movieRepositoryJdbc.findAll();

         assertThat(movies, CoreMatchers.is(Arrays.asList(new Movie(1, "Dark Knight", 152, ACTION),
                 new Movie(2, "Memento", 113, THRILLER),
                 new Movie(3, "Matrix", 136, ACTION))));
    }
}