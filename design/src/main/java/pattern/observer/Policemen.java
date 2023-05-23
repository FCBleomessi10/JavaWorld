package pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Policemen implements Observer {

    private String name;

    public Policemen(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(((Thief) o).getName());
    }
}
