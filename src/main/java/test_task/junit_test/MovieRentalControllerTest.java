package test_task.junit_test;

import org.junit.Assert;
import org.junit.Test;
import test_task.exceptionHandler.NoEnoughMoneyException;
import test_task.helpers.HelperInterface;
import test_task.controller.MovieRentalController;
import test_task.helpers.MovieCategory;
import test_task.helpers.PriceClass;
import test_task.models.Client;
import test_task.models.Movie;


public class MovieRentalControllerTest implements HelperInterface {

    private MovieRentalController controller = new MovieRentalController();
    private Client client = new Client("Sheldon Cooper", 23L);


    @Test
    public void clientCanRentMovieWithGivenDays() throws NoEnoughMoneyException {
        int days = 4;
        Movie movie = new Movie("Mamma mia", generateCode(), MovieCategory.COMEDY, PriceClass.LOW);
        boolean canAffordMovie = controller.canClientAffordMovieRent(client, days, movie);
        Assert.assertTrue(canAffordMovie);
    }

    @Test
    public void clientCanRentMovieWithOutGivenDays() throws NoEnoughMoneyException {
        Movie movie = new Movie("Shall we dance", generateCode(), MovieCategory.COMEDY, PriceClass.HIGH);
        boolean canAffordMovie = controller.canClientAffordMovieRent(client, movie);
        Assert.assertTrue(canAffordMovie);
    }

    @Test(expected = NoEnoughMoneyException.class)
    public void clientCannotRentMovieWithGivenDays() throws NoEnoughMoneyException {
            int days = 14;
            Movie movie = new Movie("Mamma mia", generateCode(), MovieCategory.COMEDY, PriceClass.HIGH);
            controller.canClientAffordMovieRent(client, days, movie);

    }
}
