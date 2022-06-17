package test;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
/**
 * Hello world!
 *
 */
public class FlightOutput{

public String bookingName;

public String flightNumber;

public String category;

public String seatsBooked;
public String totalPrice;

public FlightOutput(String inbn, String infn, String inc, String insb, String intp){

    bookingName=inbn;
    flightNumber=infn;
    category=inc;
    seatsBooked= insb;
    totalPrice=intp;
}
    @Override
    public String toString()
    {
        return bookingName + " " + totalPrice;
    }


}