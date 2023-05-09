package pattern.factory.factory;

public class LatterCoffeeFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
