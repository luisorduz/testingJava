package com.co.gocho.movies.service;

import com.co.gocho.movies.data.MovieRepository;
import com.co.gocho.movies.model.Genre;
import com.co.gocho.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.co.gocho.movies.model.Genre.*;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class MovieServiceShould {

    //@InjectMocks
    //MovieService movieService;

    //@Mock
    //MovieRepository movieRepository;

    private MovieRepository movieRepository;
    private MovieService movieService;


    @Before
    public void setUp() {

        movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION,"director1"),
                new Movie(2, "Memento", 113, THRILLER,"director2"),
                new Movie(3, "There's Something About Mary", 119, COMEDY,"director2"),
                new Movie(4, "Super 8", 112, THRILLER,"director3"),
                new Movie(5, "Scream", 111, HORROR,"director3"),
                new Movie(6, "Home Alone", 103, COMEDY,"director4"),
                new Movie(7, "Matrix", 136, ACTION,"director5")
        ));

        Mockito.when(movieRepository.findById(1)).thenReturn(new Movie(1, "Dark Knight", 152, ACTION,"director1")
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre(){

        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);
        assertThat(getMovieIds(movies),CoreMatchers.is(Arrays.asList(3,6)));
    }



    @Test
    public void return_movies_by_length(){

        Collection<Movie> movies = movieService.findMoviesByLength(119);

        List<Integer> movieIds = getMovieIds(movies);
        assertThat(movieIds,CoreMatchers.is(Arrays.asList(2,3,4,5,6)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        List<Integer> movieIds = movies.stream().map(Movie::getId).collect(Collectors.toList());
        return movieIds;
    }

    @Test
    public void findByName() {

        Collection<Movie> movies = movieService.findByName("Mat");
        List<String> moviesName = movies.stream().map(Movie::getName).collect(Collectors.toList());
        assertThat(moviesName,CoreMatchers.is(Arrays.asList("There's Something About Mary","Matrix")));

    }

    @Test
    public void findByDirector() {

        Collection<Movie> movies = movieService.findByDirector("2");
        List<Integer> movieIds = getMovieIds(movies);
        assertThat(movieIds,CoreMatchers.is(Arrays.asList(2,3)));

    }

    @Test()
    public void findByTemplate() {
        Collection<Movie> movies = movieService.findMoviesByTemplate(new Movie(1,"MATRIX",112, ACTION,"director1"));
        List<Integer> movieIds = getMovieIds(movies);
        assertThat(movieIds,CoreMatchers.is(Arrays.asList(1)));
    }


    @Test(expected = IllegalArgumentException.class)
    public void findByTemplateIlegal() {
        Collection<Movie> movies = movieService.findMoviesByTemplate(new Movie(1,"MATRIX",-2, ACTION,"director1"));
        List<Integer> movieIds = getMovieIds(movies);
    }


}