
package test;
public class CardValidator {

    private ICardValidator cardValidator;
    public void setChain(ICardValidator indigitCardValidator,
                              ICardValidator inamexCardValidator,
                              ICardValidator indiscoverCardValidator,
                              ICardValidator inmasterCardValidator,
                              ICardValidator invisaCardValidator){


        ICardValidator digitCardValidator = indigitCardValidator;
        ICardValidator amexCardValidator = inamexCardValidator;
        ICardValidator discoverCardValidator = indiscoverCardValidator;
        ICardValidator masterCardValidator = inmasterCardValidator;
        ICardValidator visaCardValidator = invisaCardValidator;


        discoverCardValidator.setSucessor(masterCardValidator);
        masterCardValidator.setSucessor(amexCardValidator);

        visaCardValidator.setSucessor(discoverCardValidator);


        digitCardValidator.setSucessor(visaCardValidator);


        cardValidator =  digitCardValidator;

    }
    public ICardValidator getCardValidator(){

        return cardValidator;

    }

}