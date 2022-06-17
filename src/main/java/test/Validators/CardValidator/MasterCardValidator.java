package test;
public class MasterCardValidator implements  ICardValidator{

    private ICardValidator cardValidator;
    public boolean isCardValid(String cardNumber){

        int len = cardNumber.length();
        if(len == 16){
                if(cardNumber.charAt(0) == '5' && (cardNumber.charAt(1) == '1'
                        || cardNumber.charAt(1) == '2'
                          || cardNumber.charAt(1) == '3'
                        || cardNumber.charAt(1) == '4'
                        || cardNumber.charAt(1) == '5') ){
                    System.out.println("Mastert card valid");
                    return true;
                }

        }
    return cardValidator.isCardValid(cardNumber);

    }
    public void setSucessor(ICardValidator incardValidator){

        cardValidator = incardValidator;

    }

}