package test_task.models;

import test_task.helpers.MovieCategory;
import test_task.helpers.PriceClass;

public class Movie {

    public String title;
    public Long code;
    public MovieCategory category;
    public PriceClass priceClass;

    public Movie(String title, Long code, MovieCategory category) {
        this.title = title;
        this.code = code;
        this.category = category;
    }

    public Movie(String title, Long code, MovieCategory category, PriceClass priceClass) {
        this.title = title;
        this.code = code;
        this.category = category;
        this.priceClass = priceClass;
    }

    public PriceClass getPriceClass() {
        return priceClass;
    }

    public void setPriceClass(PriceClass priceClass) {
        this.priceClass = priceClass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public MovieCategory getCategory() {
        return category;
    }

    public void setCategory(MovieCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", code=" + code +
                ", category='" + category + '\'' +
                ", priceClass='" + priceClass + '\'' +
                '}';
    }
}
