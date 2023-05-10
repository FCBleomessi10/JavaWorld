package pattern.builder.case1;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("samsung")
                .memory("memory")
                .mainboard("huashuo")
                .build();
        System.out.println(phone);
    }
}
