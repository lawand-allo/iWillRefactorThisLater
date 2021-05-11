package main;

public class NewReleasePriceCategory implements PriceCategory {
    @Override
    public double getPrice(int daysRented) {
        double price = daysRented * 3;
        return price;
    }
}
