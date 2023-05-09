package pattern.factory.simple;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        store.orderCoffee("latte");
    }
}
