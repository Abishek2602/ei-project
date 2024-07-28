public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String name;
    private String cvv;

    public CreditCardStrategy(String cardNumber, String name, String cvv) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.cvv = cvv;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card.");
    }
}

