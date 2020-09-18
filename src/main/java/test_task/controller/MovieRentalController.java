package test_task.controller;

import test_task.exceptionHandler.NoEnoughMoneyException;
import test_task.helpers.PriceClass;
import test_task.models.Client;
import test_task.models.Movie;

public class MovieRentalController {

    public Long countRentalPrice(PriceClass priceClass, int days) {
        long price = 0L;
        if (priceClass== PriceClass.LOW) {
            price = (long) (1 + (0.5 * days));
        }
        else if (priceClass== PriceClass.MIDDLE) {
            price = (long) (2 + days);
        }
        else if (priceClass == PriceClass.HIGH) {
            price = (long) (4 + 2 * days);
        }
        return price;
    }

    public Long countRentalPrice(PriceClass priceClass) {
        long price = 0L;
        if (priceClass== PriceClass.LOW) {
            price = (long) 1.5;
        }
        else if (priceClass== PriceClass.MIDDLE) {
            price = (long) 3;
        }
        else if (priceClass == PriceClass.HIGH) {
            price = (long) 6;
        }

        return price;
    }


    public boolean canClientAffordMovieRent(Client client, int days, Movie movie) throws NoEnoughMoneyException {
        boolean canRent = client.moneyBalance >= countRentalPrice(movie.priceClass, days);
        if (!canRent) {
            throw new NoEnoughMoneyException(client.name + " hasn't enough money to rent this movie");
        }
        else {
            return canRent;
        }
    }

    public boolean canClientAffordMovieRent(Client client, Movie movie) throws NoEnoughMoneyException {
        boolean canRent = client.moneyBalance >= countRentalPrice(movie.priceClass);;
        if (!canRent) {
            throw new NoEnoughMoneyException(client.name + " hasn't enough money to rent this movie");
        }
        else {
            return canRent;
        }

    }


}
