
package test;
public class DiscoverCardValidator implements  ICardValidator{

    private ICardValidator cardValidator;
    public boolean isCardValid(String cardNumber){


        int len = cardNumber.length();
        if(len == 16){
                if(cardNumber.charAt(0) == '6' && cardNumber.charAt(1) == '0'
                        && cardNumber.charAt(2) == '1'
                        && cardNumber.charAt(3) == '1'
                         ){
                    return true;
                }

        }
    return cardValidator.isCardValid(cardNumber);

    }
    public void setSucessor(ICardValidator incardValidator){

        cardValidator = incardValidator;

    }

}