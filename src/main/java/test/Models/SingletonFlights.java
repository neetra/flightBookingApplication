package test;
import java.util.*;

public class SingletonFlights{

    private static  List<Flight> allFlights = new ArrayList<Flight>();

    public static void SetSingletonFlights(List<Flight> inAllFlights)
    {

        List<Flight> mergedFlights = new ArrayList<Flight>();
        for (Flight flight: inAllFlights
             ) {
            Flight mflight = mergedFlights.stream()
                    .filter(f -> f.flightNumber.equals(flight.flightNumber) && f.flightType.equals(flight.flightType))
                    .findAny()
                    .orElse(null);
            if(mflight == null){

                mergedFlights.add(flight);

            }
            else{
                mflight.availableSeats =  Integer.toString(Integer.parseInt(mflight.availableSeats) + Integer.parseInt(flight.availableSeats)) ;
            }

        }

        allFlights = mergedFlights;


    }
    public static List<Flight> getAllFlights(){

               return allFlights;

    }
}