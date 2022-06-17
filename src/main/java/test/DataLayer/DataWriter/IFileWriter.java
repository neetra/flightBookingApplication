package  test;
import java.util.*;
public interface IFileWriter<T>{
//    public boolean writeValiTdFlightBookings(String filePath, List<FlightOutput> flightOutput);
//    public boolean writeInvalidFlightBookings(String filePath, List<InValidUserFlightBooking> flightOutput);
    public boolean writeObject(String filePath, List<T> flightOutput);
}