package pattern.observer;

import java.util.Observable;

public class Thief extends Observable {
    private String name;

    public Thief(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void steal() {
        System.out.println("小偷偷东西");
        super.setChanged();
        super.notifyObservers();
    }
}
