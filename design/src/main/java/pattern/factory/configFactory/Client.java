package pattern.factory.configFactory;

public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee.getName());
        coffee = CoffeeFactory.createCoffee("latte");
        System.out.println(coffee.getName());
    }
}
