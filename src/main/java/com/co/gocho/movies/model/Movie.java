package com.co.gocho.movies.model;

import java.util.Objects;

public class Movie {

    private Integer id;
    private String name;
    private Integer minutes;
    private Genre genre;
    private String director;


    public Movie(String name, int minutes, Genre genre, String director) {
        this(null,name,minutes,genre,director);
    }

    public Movie(Integer id, String name, int minutes, Genre genre, String director) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public String getDirector() {
        return director;
    }

    public Genre getGenre() {
        return genre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return minutes == movie.minutes && id.equals(movie.id) && name.equals(movie.name) && genre == movie.genre && director.equals(movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genre, director);
    }
}
