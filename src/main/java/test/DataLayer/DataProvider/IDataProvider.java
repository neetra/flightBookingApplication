package test;
import java.util.*;

public interface IDataProvider{
  public List<Flight>  getAllFlights(String filePath);
  public List<UserBooking>  getAllUserBookings(String filePath);

}