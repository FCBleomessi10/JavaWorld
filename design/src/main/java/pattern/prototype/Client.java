package pattern.prototype;

public class Client {
    public static void main(String[] args) throws Exception {
        Realizetype realizetype = new Realizetype();
        Object clone = realizetype.clone();
        System.out.println(realizetype == clone);
    }
}
