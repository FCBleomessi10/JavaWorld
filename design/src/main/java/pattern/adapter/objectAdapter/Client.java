package pattern.adapter.objectAdapter;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println(computer.readSD(new SDAdapterTF(new TFCardImpl())));
    }
}
