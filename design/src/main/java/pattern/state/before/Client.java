package pattern.state.before;

public class Client {
    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setState(ILift.OPENING_STATE);

        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}
