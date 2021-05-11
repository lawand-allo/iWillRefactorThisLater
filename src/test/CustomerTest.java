import main.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class CustomerTest {
    private Customer customer;
    @Before
    public void setUp() {
        customer = new Customer("Mustermann");
    }

    @Test
    public void rentOneMovie() {
        String movieName = "The Godfather I";
        int daysRented = 2;
        double amountForMovie = 7.0;
        Rental rental = mock(Rental.class);
        Movie movie = mock(Movie.class);
        when(movie.getTitle()).thenReturn(movieName);
        when(movie.getPriceCategory()).thenReturn(new RegularPriceCategory());
        when(rental.getMovie()).thenReturn(movie);
        when(rental.getCharge()).thenReturn(amountForMovie);
        when(rental.getDaysRented()).thenReturn(daysRented);
        customer.addRental(rental);
        String expStatement = "main.Rental Record for Mustermann\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\t"+movieName+"\t\t"+daysRented+"\t"+amountForMovie+"\n" +
                "Amount owed is "+amountForMovie+"\n" +
                "You earned 1 frequent renter points";
        System.out.println(expStatement);
        assertEquals(expStatement,customer.statement());
    }
    @Test
    public void rentTwoMovies() {
        String movieName1 = "The Godfather I";
        String movieName2 = "The Godfather II";
        int daysRented = 2;

        Rental rental1 = mock(Rental.class);
        Rental rental2 = mock(Rental.class);
        Movie movie1 = mock(Movie.class);
        Movie movie2 = mock(Movie.class);
        double amountForMovie1 = 2.0;
        double amountForMovie2 = 2.5;
        when(movie1.getTitle()).thenReturn(movieName1);
        when(movie1.getPriceCategory()).thenReturn(new RegularPriceCategory());
        when(movie2.getTitle()).thenReturn(movieName2);
        when(movie2.getPriceCategory()).thenReturn(new NewReleasePriceCategory());
        when(rental1.getMovie()).thenReturn(movie1);
        when(rental2.getMovie()).thenReturn(movie2);
        when(rental1.getCharge()).thenReturn(amountForMovie1);
        when(rental2.getCharge()).thenReturn(amountForMovie2);
        when(rental1.getDaysRented()).thenReturn(2);
        when(rental2.getDaysRented()).thenReturn(2);
        int frequentRenterPoints = 3;
        double amountOwed = amountForMovie1 + amountForMovie2;
        customer.addRental(rental1);
        customer.addRental(rental2);
        String expStatement = "main.Rental Record for Mustermann\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\t"+movieName1+"\t\t"+daysRented+"\t"+amountForMovie1+"\n" +
                "\t"+movieName2+"\t\t"+daysRented+"\t"+amountForMovie2+"\n"+
                "Amount owed is "+amountOwed+"\n" +
                "You earned "+frequentRenterPoints+" frequent renter points";
        assertEquals(expStatement,customer.statement());
    }
}
