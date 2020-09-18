package test_task.junit_test;

import org.junit.Assert;
import org.junit.Test;
import test_task.helpers.HelperInterface;
import test_task.controller.MovieController;
import test_task.helpers.MovieCategory;
import test_task.helpers.PriceClass;
import test_task.models.Movie;

import java.util.List;


public class MovieControllerTest implements HelperInterface {
    private MovieController controller = new MovieController();

    @Test
    public void movieIsAddedToMovieRentalList() {
        Movie movie = new Movie("Midnight in Paris", generateCode(), MovieCategory.COMEDY, PriceClass.HIGH);
        Long movieCode = movie.code;
        controller.addMovieRental(movie);

        Assert.assertEquals(controller.getMovieFromRental(movieCode), movie);
    }

    @Test
    public void movieIsReachableByCode() {
        Movie movie = new Movie("Bright Corpe", generateCode(), MovieCategory.HORROR, PriceClass.LOW);
        Long movieCode = movie.code;
        Movie movie2 = new Movie("Amely", generateCode(), MovieCategory.DRAMA, PriceClass.LOW);
        Movie movie3 = new Movie("16 candles", generateCode(), MovieCategory.TEENAGE_DRAMA, PriceClass.LOW);
        controller.addMovieRental(movie);
        controller.addMovieRental(movie2);
        controller.addMovieRental(movie3);

        Assert.assertEquals(controller.getMovieFromRental(movieCode), movie);

    }

    @Test
    public void removeMovieFromRentalByCode() {
        Movie movie = new Movie("Mamma mia", generateCode(), MovieCategory.COMEDY);
        Movie movie2 = new Movie("Sleepless in Siettle", generateCode(), MovieCategory.DRAMA);
        Movie movie3 = new Movie("Blue Ivy", generateCode(), MovieCategory.TEENAGE_DRAMA);
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
        Movie movie1 = new Movie("Back in Future", generateCode(), MovieCategory.COMEDY);
        Movie movie2 = new Movie("The anchorman", generateCode(), MovieCategory.COMEDY);
        Movie movie3 = new Movie("Halloween", generateCode(), MovieCategory.HORROR);
        Movie movie4 = new Movie("The imitation game", generateCode(), MovieCategory.HISTORICAL);
        Movie movie5 = new Movie("The king speech", generateCode(), MovieCategory.DRAMA);

        controller.addMovieRental(movie1);
        controller.addMovieRental(movie2);
        controller.addMovieRental(movie3);
        controller.addMovieRental(movie4);
        controller.addMovieRental(movie5);

        List<Movie> comedyMovies = controller.getAllMoviesFromCertainCategory(MovieCategory.COMEDY);
        Assert.assertEquals(comedyMovies.size(), 2);
        Assert.assertTrue(comedyMovies.contains(movie1));
        Assert.assertTrue(comedyMovies.contains(movie2));



    }


}
