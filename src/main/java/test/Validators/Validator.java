package test;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Validator {

    private String INVALIDFLIGHTMESSAGE  = "Invalid Flight Number";

    private String INVALIDSEATS  = "Invalid Number of Seats";
    private String INVALIDPAYMENTCARD  = "Invalid Card Number";

    public ICardValidator getCardValidator(){

        ICardValidator digitCardValidator = new DigitCardValidator();
        ICardValidator amexCardValidator = new AmexCardValidator();
        ICardValidator discoverCardValidator = new DiscoverCardValidator();
        ICardValidator masterCardValidator = new MasterCardValidator();
        ICardValidator visaCardValidator = new VisaCardValidator();


        discoverCardValidator.setSucessor(masterCardValidator);
        masterCardValidator.setSucessor(amexCardValidator);

        visaCardValidator.setSucessor(discoverCardValidator);


        digitCardValidator.setSucessor(visaCardValidator);


        return digitCardValidator;

    }
    public Result validateBookings(List<UserBooking> userBookings, List<Flight> allFlights)
    {


        Result res = new Result();


        CardValidator cardValidator = new CardValidator();
        cardValidator.setChain(new DigitCardValidator(),
                new AmexCardValidator(),
                new DiscoverCardValidator(),
                new MasterCardValidator(),
                new VisaCardValidator()
                );
        ICardValidator cardValid = cardValidator.getCardValidator();
        for (UserBooking userBooking: userBookings
             ) {


            System.out.println(userBooking.bookingName);
            List<Flight> validFlights = allFlights.stream().filter(f ->
                    f.flightNumber.equals(userBooking.flightNumber))
                    .collect(Collectors.toList());
            if(validFlights ==  null || validFlights.size() == 0){

                res.inValidUserFlightBookings.add(new InValidUserFlightBooking(userBooking.bookingName , INVALIDFLIGHTMESSAGE));
                System.out.println(INVALIDFLIGHTMESSAGE);
                continue;
            }
            Flight flight    = validFlights.stream().filter(f ->
                                        f.flightType.equals(userBooking.seatCategory) &&
                                        Integer.parseInt(userBooking.numberOfSeats) <= Integer.parseInt(f.availableSeats)
                                        ).findAny().orElse(null);
            if(flight == null){

                res.inValidUserFlightBookings.add(new InValidUserFlightBooking(userBooking.bookingName , INVALIDSEATS));
                System.out.println(INVALIDSEATS);
                continue;
            }
            if(cardValid.isCardValid(userBooking.paymentCardNumber))
            {
                int currentSeats = Integer.parseInt(flight.availableSeats) - Integer.parseInt(userBooking.numberOfSeats);
                flight.availableSeats = Integer.toString(currentSeats);

                double price = Double.parseDouble(flight.price) * Integer.parseInt(userBooking.numberOfSeats);
                res.flightOutputs.add(
                        new FlightOutput(userBooking.bookingName , userBooking.flightNumber, userBooking.seatCategory, userBooking.numberOfSeats,Double.toString(price) )
                );
                System.out.println("Seats updated " + currentSeats + "for " + flight.flightNumber);
                // add entry in utput.csv
            }
            else{
                System.out.println(INVALIDPAYMENTCARD);
                res.inValidUserFlightBookings.add(new InValidUserFlightBooking(userBooking.bookingName , INVALIDPAYMENTCARD));
                // add error card invalid
            }

        }
    return  res;
    }

}