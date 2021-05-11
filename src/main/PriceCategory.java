package main;

public abstract class PriceCategory {
    public abstract int getPriceCode();
    public abstract double getPrice(int daysRented);
}
