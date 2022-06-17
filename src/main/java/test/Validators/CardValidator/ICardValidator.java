package test;

public interface ICardValidator{

        public boolean isCardValid(String cardNumber);
        public void setSucessor(ICardValidator cardValidator);

        }