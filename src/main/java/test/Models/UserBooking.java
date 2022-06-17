package test;
import com.opencsv.bean.CsvBindByPosition;

public class UserBooking{
    // @CsvBindByName(column = "Category(Economy,PremiumEconomy,Business)")
    @CsvBindByPosition(position = 0)
    public String bookingName;

    //@CsvBindByName(column = "FlightNumber")
    @CsvBindByPosition(position = 1)
    public String flightNumber;
    //
//
//
//    @CsvBindByName(column = "AvailableSeats")
    @CsvBindByPosition(position = 2)
    public String seatCategory;
    ////
    //@CsvBindByName(column = "Price")
    @CsvBindByPosition(position = 3)
    public String numberOfSeats;
    ////
//    @CsvBindByName(column = "Arrival")
    @CsvBindByPosition(position = 4)
    public String paymentCardNumber;



}

