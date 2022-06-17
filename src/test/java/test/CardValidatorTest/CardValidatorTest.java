package unittest;
import test.*;


import static org.mockito.Mockito.when;
import org.junit.BeforeClass;
import org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


import static org.mockito.Mockito.times;


@RunWith(MockitoJUnitRunner.class)
public class CardValidatorTest
{
    /**
     * Rigorous Test :-)
     */

    @InjectMocks
    static CardValidator cardValidator;
    static ICardValidator mastercv;
    static ICardValidator digitCV;
    static   ICardValidator amexCV;
    static   ICardValidator visaCV;
    static ICardValidator discoverCV;
    static ICardValidator cv;

    @BeforeClass public static void setup() {
        cardValidator = new CardValidator();
        mastercv = spy(MasterCardValidator.class);
        digitCV = spy(DigitCardValidator.class);
        amexCV = spy(AmexCardValidator.class);
        visaCV = spy(VisaCardValidator.class);
        discoverCV = spy(DiscoverCardValidator.class);
        cardValidator.setChain(digitCV,
                amexCV,
                discoverCV,
                mastercv,
                visaCV
        );

        cv = cardValidator.getCardValidator();
    }
    @Test
    public void invalidCard_ShouldReturnFromdigitCardValidator()
    {
        String cardNumber = "abc";
        assertFalse(cv.isCardValid(cardNumber));


        verify(digitCV, times(1)).isCardValid(cardNumber);
        verify(visaCV, times(0)).isCardValid(cardNumber);


    }

    @Test
    public void validVisaCard_ShouldReturnFromVisaCardValidator()
    {

        String cardNumber = "4120000000000";
        assertTrue(cv.isCardValid(cardNumber));


        verify(digitCV, times(1)).isCardValid(cardNumber);
        verify(visaCV, times(1)).isCardValid(cardNumber);
        verify(discoverCV, times(0)).isCardValid(cardNumber);
    }

    @Test
    public void validDiscoverCard_ShouldReturnFromDiscoverCardValidator()
    {

        String cardNumber = "6011111111111117";
        assertTrue(cv.isCardValid(cardNumber));


        verify(digitCV, times(1)).isCardValid(cardNumber);
        verify(visaCV, times(1)).isCardValid(cardNumber);
        verify(discoverCV, times(1)).isCardValid(cardNumber);
        verify(mastercv, times(0)).isCardValid(cardNumber);
    }

    @Test
    public void validMasterCard_ShouldReturnFromMasterrCardValidator()
    {

        String cardNumber = "5555555555554444";
        assertTrue(cv.isCardValid(cardNumber));


        verify(digitCV, times(1)).isCardValid(cardNumber);
        verify(visaCV, times(1)).isCardValid(cardNumber);
        verify(discoverCV, times(1)).isCardValid(cardNumber);
        verify(mastercv, times(1)).isCardValid(cardNumber);
    }

    @Test
    public void validAmexCard_ShouldReturnFromAmexCardValidator()
    {
        String cardNumber = "348282246310005";
        assertTrue(cv.isCardValid(cardNumber));

        verify(digitCV, times(1)).isCardValid(cardNumber);
        verify(visaCV, times(1)).isCardValid(cardNumber);
        verify(discoverCV, times(1)).isCardValid(cardNumber);
        verify(mastercv, times(1)).isCardValid(cardNumber);
        verify(amexCV, times(1)).isCardValid(cardNumber);
    }

    @Test
    public void inValidCard_ShouldReturnFalseFromAmexCardValidator()
    {
        String cardNumber = "3482822463100051";
        assertFalse(cv.isCardValid(cardNumber));

        verify(digitCV, times(1)).isCardValid(cardNumber);
        verify(visaCV, times(1)).isCardValid(cardNumber);
        verify(discoverCV, times(1)).isCardValid(cardNumber);
        verify(mastercv, times(1)).isCardValid(cardNumber);
        verify(amexCV, times(1)).isCardValid(cardNumber);
    }

    @Test
    public void inValidCard_ShouldReturnFalseFromDigitCardValidator()
    {
        String cardNumber = "34828224631000511234";
        assertFalse(cv.isCardValid(cardNumber));

        verify(digitCV, times(1)).isCardValid(cardNumber);
        verify(visaCV, times(0)).isCardValid(cardNumber);

    }


}
