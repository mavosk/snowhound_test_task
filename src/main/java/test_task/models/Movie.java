package test_task.models;

public class Movie {

    public String title;
    public Long code;
    public String category;
    public String priceClass;

    public Movie(String title, Long code, String category) {
        this.title = title;
        this.code = code;
        this.category = category;
    }

    public Movie(String title, Long code, String category, String priceClass) {
        this.title = title;
        this.code = code;
        this.category = category;
        this.priceClass = priceClass;
    }

    public String getPriceClass() {
        return priceClass;
    }

    public void setPriceClass(String priceClass) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
