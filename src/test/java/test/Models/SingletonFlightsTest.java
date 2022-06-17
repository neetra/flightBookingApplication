package unittest;
import test.*;


import static org.mockito.Mockito.when;
import org.junit.BeforeClass;
import org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.Assert.asserTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import java.util.*;

import static org.mockito.Mockito.times;


/**
 * Unit test for simple App.
 */

public class SingletonFlightsTest{


    @Test
    public void ShouldReturnSameObjectsForFlights() {

        Flight f1 = new Flight();
        Flight f2 = new Flight();

        f1.flightType = "Economy";
        f1.flightNumber = "XSVFB";

        f2.flightType = "Preminum Economy";
        f2.flightNumber = "DFDRTD";

        List<Flight> allflights = new ArrayList<Flight>();
        allflights.add(f1);
        allflights.add(f2);


        SingletonFlights.SetSingletonFlights(allflights);

        List<Flight> allflights1 = SingletonFlights.getAllFlights();

        allflights1.get(0).flightNumber = "NEWFN";
        List<Flight> allflights2 = SingletonFlights.getAllFlights();

        assertEquals(allflights1, allflights2);
    }

}