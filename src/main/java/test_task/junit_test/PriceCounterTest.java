package test_task.junit_test;

import org.junit.Assert;
import org.junit.Test;
import test_task.controller.MovieRentalController;
import test_task.helpers.PriceClass;

public class PriceCounterTest {
    private MovieRentalController controller = new MovieRentalController();

    @Test
    public void priceForHighClassMovieCountedRightWithGivenDays() {
        long fullPrice = controller.countRentalPrice(PriceClass.HIGH, 14);
        Assert.assertEquals(fullPrice, 32);
    }

    @Test
    public void priceForMiddleClassMovieCountedRightWithNoDays() {
        long fullPrice = controller.countRentalPrice(PriceClass.MIDDLE);
        Assert.assertEquals(fullPrice, 3);
    }
}
