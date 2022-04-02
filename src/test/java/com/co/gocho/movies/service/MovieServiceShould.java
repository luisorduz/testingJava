package com.co.gocho.movies.service;

import com.co.gocho.movies.data.MovieRepository;
import com.co.gocho.movies.model.Genre;
import com.co.gocho.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
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

    @Before
    public void setUp() {

        movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "There's Something About Mary", 119, COMEDY),
                new Movie(4, "Super 8", 112, THRILLER),
                new Movie(5, "Scream", 111, HORROR),
                new Movie(6, "Home Alone", 103, COMEDY),
                new Movie(7, "Matrix", 136, ACTION)
        ));
    }

    @Test
    public void return_movies_by_genre(){
        MovieService movieService = new MovieService(movieRepository);

        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);
        List<Integer> movieIds = movies.stream().map(Movie::getId).collect(Collectors.toList());
        assertThat(movieIds,CoreMatchers.is(Arrays.asList(3,6)));
    }

}