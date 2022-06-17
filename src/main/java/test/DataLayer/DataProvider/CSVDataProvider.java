
package  test;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;




//import com.opencsv.bean.*;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.lang.Object;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.lang.reflect.*;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;


import java.util.*;
import java.util.stream.*;


public class CSVDataProvider implements IDataProvider {
    String fileName  = "E:/NetraMasters/202/FlightBooking/flight-booking-app/inputfiles/flights.csv";
    public List<Flight>  getAllFlights(String filePath){

        try{

            List<Flight
                    > beans  = new CsvToBeanBuilder(new FileReader(filePath))
                    .withType(Flight.class)
                    .withSkipLines(1)
                    .build()
                    .parse();


        return beans;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  new ArrayList<Flight>();
    }

    public List<UserBooking>  getAllUserBookings(String filePath){

        try{

            List<UserBooking> beans  = new CsvToBeanBuilder(new FileReader(filePath))
                    .withType(UserBooking.class)
                    .withSkipLines(1)
                    .build()
                    .parse();

            return beans;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  new ArrayList<UserBooking>();
    }
}