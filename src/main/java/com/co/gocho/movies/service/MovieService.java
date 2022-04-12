package com.co.gocho.movies.service;

import com.co.gocho.movies.data.MovieRepository;
import com.co.gocho.movies.model.Genre;
import com.co.gocho.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());

    }

    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> findByName(String name){

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    public Collection<Movie> findByDirector(String director){

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector().toLowerCase().contains(director.toLowerCase())).collect(Collectors.toList());
    }
}
