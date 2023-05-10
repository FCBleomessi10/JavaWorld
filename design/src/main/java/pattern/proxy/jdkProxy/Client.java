package pattern.proxy.jdkProxy;

public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        SellTickets proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }
}
