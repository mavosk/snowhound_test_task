package test_task.junit_test;

import org.junit.Assert;
import org.junit.Test;
import test_task.controller.HelperInterface;
import test_task.controller.MovieController;
import test_task.models.Movie;

import java.util.List;
import java.util.Random;


public class MovieControllerTest implements HelperInterface {
    private MovieController controller = new MovieController();

    @Test
    public void movieIsAddedToMovieRentalList() {
        Movie movie = new Movie("Midnight in Paris", generateCode(), "COMEDY", "HIGH");
        Long movieCode = movie.code;
        controller.addMovieRental(movie);

        Assert.assertEquals(controller.getMovieFromRental(movieCode), movie);
    }

    @Test
    public void movieIsReachableByCode() {
        Movie movie = new Movie("Bright Corpe", generateCode(), "HORROR", "LOW");
        Long movieCode = movie.code;
        Movie movie2 = new Movie("Amely", generateCode(), "DRAMA", "LOW");
        Movie movie3 = new Movie("16 candles", generateCode(), "TEENAGE DRAMA", "LOW");
        controller.addMovieRental(movie);
        controller.addMovieRental(movie2);
        controller.addMovieRental(movie3);

        Assert.assertEquals(controller.getMovieFromRental(movieCode), movie);

    }

    @Test
    public void removeMovieFromRentalByCode() {
        Movie movie = new Movie("Mamma mia", generateCode(), "COMEDY", "LOW");
        Movie movie2 = new Movie("Sleepless in Siettle", generateCode(), "DRAMA", "LOW");
        Movie movie3 = new Movie("Blue Ivy", generateCode(), "TEENAGE DRAMA", "LOW");
        controller.addMovieRental(movie);
        controller.addMovieRental(movie2);
        controller.addMovieRental(movie3);

        controller.removeMovieFromRental(movie.code);
        controller.removeMovieFromRental(movie2.code);
        Assert.assertEquals(controller.movieRental.size(), 1);
        Assert.assertEquals(controller.getMovieFromRental(movie3.code), movie3);

    }

    @Test
    public void getAllMoviesFromCertainCategory() {
        Movie movie1 = new Movie("Back in Future", generateCode(), "COMEDY", "HIGH");
        Movie movie2 = new Movie("The anchorman", generateCode(), "COMEDY", "HIGH");
        Movie movie3 = new Movie("Halloween", generateCode(), "HORROR", "LOW");
        Movie movie4 = new Movie("The imitation game", generateCode(), "HISTORICAL", "LOW");
        Movie movie5 = new Movie("The king speech", generateCode(), "FICTION", "LOW");

        controller.addMovieRental(movie1);
        controller.addMovieRental(movie2);
        controller.addMovieRental(movie3);
        controller.addMovieRental(movie4);
        controller.addMovieRental(movie5);

        List<Movie> comedyMovies = controller.getAllMoviesFromCertainCategory("COMEDY");
        Assert.assertEquals(comedyMovies.size(), 2);
        Assert.assertTrue(comedyMovies.contains(movie1));
        Assert.assertTrue(comedyMovies.contains(movie2));



    }


}
