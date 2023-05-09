package pattern.factory.abstractFactory;

public class MatchaMousse extends Dessert {

    @Override
    public void show() {
        System.out.println(this.getClass().getSimpleName());
    }
}
