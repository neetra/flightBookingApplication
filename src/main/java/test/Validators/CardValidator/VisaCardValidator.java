package test;
public class VisaCardValidator implements  ICardValidator{

    private ICardValidator cardValidator;
    public boolean isCardValid(String cardNumber){

        int len = cardNumber.length();
        if(len == 13 || len == 16){
                if(cardNumber.charAt(0) == '4'){
                    return true;
                }
        }

    return cardValidator.isCardValid(cardNumber);

    }
    public void setSucessor(ICardValidator incardValidator){


        cardValidator = incardValidator;

    }

}