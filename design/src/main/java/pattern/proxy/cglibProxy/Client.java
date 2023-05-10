package pattern.proxy.cglibProxy;

public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        TrainStation proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }
}
