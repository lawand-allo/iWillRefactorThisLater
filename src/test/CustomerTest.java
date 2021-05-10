import main.Customer;
import main.Movie;
import main.Rental;
import org.junit.Before;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;
    @Before
    public void setUp() {
        customer = new Customer("Mustermann");
    }

    @Test
    public void testRent() {
        String movieName = "The Godfather I";
        int daysRented = 2;
        Rental rental = new Rental(new Movie(movieName,2),daysRented);
        customer.addRental(rental);
        String statement = "main.Rental Record for Mustermann\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\t"+movieName+"\t\t"+daysRented+"\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        System.out.println(statement);
        assertEquals(statement,customer.statement());
    }
}
