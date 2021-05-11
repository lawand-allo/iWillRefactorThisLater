package main;

public class NewReleasePriceCategory extends PriceCategory {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getPrice(int daysRented) {
        double price = daysRented * 3;
        return price;
    }
}
