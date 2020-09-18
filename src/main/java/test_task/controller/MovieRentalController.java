package test_task.controller;

import test_task.models.Client;
import test_task.models.Movie;

public class MovieRentalController {

    public Long countRentalPrice(String priceClass,int days) {
        long price = 0L;
        switch (priceClass) {
            case "LOW":
                price =  (long) (1 + (0.5 * days));
            case "MIDDLE":
                price = (long) (2 + days);
            case "HIGH":
                price = (long) (4 + 2 * days);
        }
        return price;
    }

    public Long countRentalPrice(String priceClass) {
        long price = 0L;
        switch (priceClass) {
            case "LOW":
                price =  (long) 1.5;
            case "MIDDLE":
                price = (long) 3;
            case "HIGH":
                price = (long) 6;
        }
        return price;
    }


    public boolean canClientAffordMovieRent(Client client, int days, Movie movie) {
        return client.moneyBalance >= countRentalPrice(movie.priceClass, days);

    }

    public boolean canClientAffordMovieRent(Client client, Movie movie) {
        return client.moneyBalance >=countRentalPrice(movie.priceClass);

    }


}
