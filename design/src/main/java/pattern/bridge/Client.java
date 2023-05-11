package pattern.bridge;

public class Client {
    public static void main(String[] args) {
        OperatingSystem mac = new Mac(new AviFile());
        mac.play("a.avi");

        OperatingSystem windows = new Windows(new RmvbFile());
        windows.play("a.rmvb");
    }
}
