package main;

public class Movie {
    private final String title;
    private PriceCategory priceCategory;
    public Movie(String newtitle, PriceCategory priceCategory) {
        title = newtitle;
        setPriceCode(priceCategory);
    }

    private void setPriceCode(PriceCategory priceCategory) {
        this.priceCategory = priceCategory;
    }

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }
    public String getTitle (){
        return title;
    };
}