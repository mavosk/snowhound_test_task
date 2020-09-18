package test_task.junit_test;

import org.junit.Assert;
import org.junit.Test;
import test_task.controller.HelperInterface;
import test_task.controller.MovieController;
import test_task.controller.MovieRentalController;
import test_task.models.Client;
import test_task.models.Movie;

import java.util.Random;

import static org.junit.Assert.*;

public class MovieRentalControllerTest implements HelperInterface {

    private MovieRentalController controller = new MovieRentalController();
    private Client client = new Client("Sheldon Cooper", 23L);


    @Test
    public void clientCanRentMovieWithGivenDays() {
        int days = 4;
        Movie movie = new Movie("Mamma mia", generateCode(), "COMEDY", "LOW");
        boolean canAffordMovie = controller.canClientAffordMovieRent(client, days, movie);
        Assert.assertTrue(canAffordMovie);
    }

    @Test
    public void clientCanRentMovieWithOutGivenDaya() {
        Movie movie = new Movie("Shall we dance", generateCode(), "COMEDY", "HIGH");
        boolean canAffordMovie = controller.canClientAffordMovieRent(client, movie);
        Assert.assertTrue(canAffordMovie);
    }

    @Test
    public void clientCannotRentMovieWithGivenDays() {
        int days = 14;
        Movie movie = new Movie("Mamma mia", generateCode(), "COMEDY", "HIGH");
        boolean canAffordMovie = controller.canClientAffordMovieRent(client, days, movie);
        Assert.assertFalse(canAffordMovie);

    }
}
