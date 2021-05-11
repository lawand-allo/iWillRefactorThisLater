package main;

public class ChildrenPriceCategory  implements PriceCategory {

    @Override
    public double getPrice(int daysRented) {
        double price = 1.5;
        if (daysRented > 3)
             price+= (daysRented - 3) * 1.5;
        return price;
    }
}
