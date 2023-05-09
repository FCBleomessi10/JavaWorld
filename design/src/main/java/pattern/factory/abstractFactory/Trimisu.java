package pattern.factory.abstractFactory;

public class Trimisu extends Dessert {

    @Override
    public void show() {
        System.out.println(this.getClass().getSimpleName());
    }
}
