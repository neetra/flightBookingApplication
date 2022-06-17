package  test;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class CSVFileWriter implements IFileWriter<FlightOutput>{

    public boolean writeObject(String filePath, List<FlightOutput> flightOutput){
       return  writeValidFlightBookings(filePath, flightOutput);


    }
    public boolean writeValidFlightBookings(String filePath, List<FlightOutput> flightOutput){
        File file = new File(filePath);

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile, ',',CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            List<String[]> data = new ArrayList<String[]>();
             String[] header = new String[] {
                     "Booking name", "flight number", "Category", "number of seats booked", "total price"

             };

            for (FlightOutput b: flightOutput
            ) {
                // System.out.println(b.flightType);
                data.add(new String[] { b.bookingName, b.flightNumber, b.category, b.seatsBooked, b.totalPrice });

            }



            //
            // Flight ff = inputObjects.stream().filter(f -> f.flightNumber.equals("SJ456")).findFirst().orElse(null);
         //   List<Flight> ff = flightOutput.stream().filter(f -> f.flightNumber.equals("SJ6")).collect(Collectors.toList());

//            for (Flight flig:ff
//            ) {
//                System.out.println(flig.flightNumber);
//
//            }

           writer.writeAll(data);

            // closing writer connection
            writer.close();

            return true;

        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        return false;
    }

    public boolean writeInvalidFlightBookings(String filePath, List<InValidUserFlightBooking> flightOutput){



        return false;
    }




}