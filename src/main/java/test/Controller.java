package test;
import java.util.*;
import java.util.stream.*;

public class Controller{

    public static void BookTickets(String flightFilePath, String userBookingFilePath, String outputValidFlightBookingFP, String inValidBookingFP){


        IDataProvider csvDataProvider = new CSVDataProvider();
        List<Flight> allFlights= csvDataProvider.getAllFlights(flightFilePath);
        List<UserBooking> userBookings= csvDataProvider.getAllUserBookings(userBookingFilePath);

        SingletonFlights.SetSingletonFlights(allFlights);

        Validator validator = new Validator();
        Result res = validator.validateBookings(userBookings,SingletonFlights.getAllFlights() );



        FileWriterFactory fileWriterFactory = new FileWriterFactory();
        IFileWriter csvFileWriter =  fileWriterFactory.getWriter("CSV");
        IFileWriter textFileWriter = fileWriterFactory.getWriter("TEXT");


        csvFileWriter.writeObject(outputValidFlightBookingFP, res.flightOutputs);
        textFileWriter.writeObject(inValidBookingFP, res.inValidUserFlightBookings);
    }

}