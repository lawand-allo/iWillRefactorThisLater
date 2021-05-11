package main;


import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private final String name;
    private final Vector rentals = new Vector();
    private int frequentRenterPoints = 0;
    private double totalAmount = 0;

    public Customer(String newname) {
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration enum_rentals = rentals.elements();
        StringBuilder statementBuilder = new StringBuilder();
        statementBuilder.append(getHeader());
        statementBuilder.append(getTotalAmount(enum_rentals));
        statementBuilder.append(getFooter());
        return statementBuilder.toString();
    }

    private String getFooter() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Amount owed is ").append(totalAmount).append("\n");
        stringBuilder.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return stringBuilder.toString();
    }

    private String getHeader() {
        StringBuilder statementBuilder = new StringBuilder("main.Rental Record for " + this.getName() + "\n");
        statementBuilder.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");
        return statementBuilder.toString();
    }

    private String getTotalAmount(Enumeration enum_rentals ) {
        StringBuilder stringBuilder = new StringBuilder();
        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enum_rentals.nextElement();
            thisAmount = each.getCharge();
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCategory().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;
            //show figures for this rental
            stringBuilder.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t").append(each.getDaysRented()).append("\t").append(String.valueOf(thisAmount)).append("\n");
            totalAmount += thisAmount;
        }
        return stringBuilder.toString();
    }

}
    