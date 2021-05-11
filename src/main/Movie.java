package main;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private final String title;
    private PriceCategory priceCategory;
    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        setPriceCode(newpriceCode);
    }

    private void setPriceCode(int newpriceCode) {
        switch (newpriceCode) {
            case Movie.CHILDRENS:
                priceCategory = new ChildrenPriceCategory();
                break;
            case Movie.NEW_RELEASE:
                priceCategory = new NewReleasePriceCategory();
                break;
            case Movie.REGULAR:
                priceCategory = new RegularPriceCategory();
                break;
            default:
                throw new IllegalArgumentException("invalid price code");
        }
    }

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }
    public String getTitle (){
        return title;
    };
}