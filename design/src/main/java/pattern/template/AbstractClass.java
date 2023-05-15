package pattern.template;

public abstract class AbstractClass {

    public void cookProcess() {
        pourOil();
        heatOil();
        pourVegetable();
        pourSauce();
        fry();
    }

    public void pourOil() {
        System.out.println("pourOil");
    }

    public void heatOil() {
        System.out.println("hearOil");
    }

    public abstract void pourVegetable();

    public abstract void pourSauce();

    public void fry() {
        System.out.println("fry");
    }
}
