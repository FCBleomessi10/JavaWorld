package pattern.template;

public class ConcreteClass_BaoCai extends AbstractClass {
    @Override
    public void pourVegetable() {
        System.out.println("pour BaiCai");
    }

    @Override
    public void pourSauce() {
        System.out.println("pour LaJiao");
    }
}
