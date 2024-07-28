public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("1234", 100);
        Item item2 = new Item("5678", 300);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new PayPalStrategy("abisansha1903@gmail.com", "myabi"));
        cart.pay(new CreditCardStrategy("1234567890123456", "Abishek", "123"));
    }
}

