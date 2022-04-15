package com.co.gocho.movies.service;

import com.co.gocho.movies.data.MovieRepository;
import com.co.gocho.movies.model.Genre;
import com.co.gocho.movies.model.Movie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        if (template.getId() != null) {
            Movie movie = movieRepository.findById(template.getId());
            return movie != null ? Collections.singletonList(movie) : new ArrayList<>();
        }else
        if (template.getMinutes() < 0){
            throw new IllegalArgumentException("duration must be greater or equal than zero.");
        }
        else {
            return movieRepository.findAll().stream().
                    filter(movie -> {
                        return movie.getName().equalsIgnoreCase(template.getName()) ||
                                movie.getMinutes().equals(template.getMinutes()) ||
                                movie.getGenre().equals(template.getGenre());
                    })
                    .collect(Collectors.toList());
        }
    }
/*
    public Collection<Movie> findByTemplate(Movie template) {

        if (template.getId() != null) {
            Movie movie = findById(template.getId());
            return movie != null ? Collections.singletonList(movie) : new ArrayList<>();
        }

        if (template.getMinutes() < 0) {
            throw new IllegalArgumentException("duration must be greater or equal than zero.");
        }

        List<Predicate<Movie>> filters = new ArrayList<>();

        if (template.getName() != null) {
            filters.add(movie -> movie.getName().toLowerCase().contains(template.getName().toLowerCase().trim()));
        }
        if (template.getMinutes() != null) {
            filters.add(movie -> movie.getMinutes() <= template.getMinutes());
        }
        if (template.getGenre() != null) {
            filters.add(movie -> movie.getGenre().equals(template.getGenre()));
        }
        if (template.getDirector() != null) {
            filters.add(movie -> movie.getDirector().toLowerCase().contains(template.getDirector().toLowerCase().trim()));
        }

        return repository.findAll().stream()
                .filter(movie -> filters.stream().allMatch(filter -> filter.test(movie)))
                .collect(Collectors.toList());
    }*/
}
