package pattern.mediator;

public class HouseOwner extends Person {
    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void contact(String message) {
        mediator.contact(message, this);
    }

    public void getMessage(String message) {
        System.out.println("房主" + name + "获取到的信息是：" + message);
    }
}
