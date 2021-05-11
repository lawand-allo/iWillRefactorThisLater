package main;

public class NewReleasePriceCategory implements PriceCategory {
    @Override
    public double getPrice(int daysRented) {
        return daysRented * 3;
    }
}
