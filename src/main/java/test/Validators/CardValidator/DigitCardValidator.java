package test;

import java.util.regex.*;

public class DigitCardValidator implements  ICardValidator{

    private ICardValidator cardValidator;
    public boolean isCardValid(String cardNumber){


        if(onlyDigits(cardNumber) && cardNumber.length() < 19){

            return cardValidator.isCardValid(cardNumber);

        }

    return false;

    }

    private boolean  onlyDigits(String str)
    {
        // Regex to check string
        // contains only digits
        String regex = "[0-9]+";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (str == null) {
            return false;
        }

        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        Matcher m = p.matcher(str);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }

    public void setSucessor(ICardValidator incardValidator){

        cardValidator = incardValidator;

    }

}