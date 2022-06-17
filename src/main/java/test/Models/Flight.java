package test;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
/**
 * Hello world!
 *
 */
public class Flight{


       // @CsvBindByName(column = "Category(Economy,PremiumEconomy,Business)")
        @CsvBindByPosition(position = 0)
        public String flightType;

    //@CsvBindByName(column = "FlightNumber")
    @CsvBindByPosition(position = 1)
    public String flightNumber;
//
//
//
//    @CsvBindByName(column = "AvailableSeats")
    @CsvBindByPosition(position = 2)
        public String availableSeats;
////
    //@CsvBindByName(column = "Price")
        @CsvBindByPosition(position = 3)
          public String price;
////
//    @CsvBindByName(column = "Arrival")
@CsvBindByPosition(position = 4)
           public String arrival;
////
//    @CsvBindByName(column = "Departure")
@CsvBindByPosition(position = 5)
          public String departure;
//

}
