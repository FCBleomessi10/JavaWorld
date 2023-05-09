package pattern.factory.before;

public abstract class Coffee {

    public abstract String getName();

    public void addSugar() {
        System.out.println(getName() + ": addSugar()");
    }

    public void addMilk() {
        System.out.println(getName() + ": addMilk()");
    }
}
