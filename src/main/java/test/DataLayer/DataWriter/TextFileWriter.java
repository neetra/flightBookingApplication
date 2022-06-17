package  test;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class TextFileWriter implements IFileWriter<InValidUserFlightBooking>{

    public boolean writeObject(String filePath, List<InValidUserFlightBooking> invalidBookings){
        return writeInvalidFlightBookings(filePath, invalidBookings);
    }
    private boolean writeInvalidFlightBookings(String filePath, List<InValidUserFlightBooking> invalidBookings){


        try{

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            String msg = "Please enter correct booking details for ";

            writer.write("");
            for (InValidUserFlightBooking invalidBooking: invalidBookings
                 ) {

                String finalMsg = msg + invalidBooking.bookingName + " : " + invalidBooking.message;
                System.out.println(finalMsg);
                writer.append(finalMsg);
                writer.newLine();
            }

            writer.close();
        return true;
        }
        catch (IOException e) {
            System.out.println("An error occurred.");

            e.printStackTrace();

        }

        return false;

    }


}