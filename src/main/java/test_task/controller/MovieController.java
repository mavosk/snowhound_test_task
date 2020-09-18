package test_task.controller;


import test_task.models.Movie;
import test_task.models.MovieShelf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MovieController {

    public HashMap<MovieShelf, HashMap<Long, Movie>> shelves = new HashMap<>();
    public HashMap<Long, Movie> movieRental = new HashMap<>();

    public void addMovieRental(Movie movie) {
        movieRental.put(movie.code, movie);
    }

    public Movie getMovieFromRental(Long code) {
        return movieRental.get(code);
    }

    public void removeMovieFromRental(Long code) {
        movieRental.remove(code);
    }

    public List<Movie> getAllMoviesFromCertainCategory(String categoryName) {
        List<Movie> allMovies = new ArrayList<>(movieRental.values());
        return allMovies.stream().filter(x -> x.category.equals(categoryName))
                .collect(Collectors.toList());
    }

}
