package test;
public class AmexCardValidator implements  ICardValidator{

    private ICardValidator cardValidator;
    public boolean isCardValid(String cardNumber){


        int len = cardNumber.length();
        if(len == 15){
                if(cardNumber.charAt(0) == '3' && (cardNumber.charAt(1) == '4'
                        || cardNumber.charAt(1) == '7'
                )
                         ){
                    return true;
                }

        }
    return false;

    }
    public void setSucessor(ICardValidator incardValidator){


        cardValidator = incardValidator;

    }

}