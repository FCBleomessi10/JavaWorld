package pattern.proxy.jdkProxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    private TrainStation station = new TrainStation();

    public SellTickets getProxyObject() {
        /*
          返回代理对象
               ClassLoader loader: 类加载其，用于加载代理类，可以通过目标对象获取类加载器
               Class<?>[] interfaces: 代理类实现的接口的字节码对象
               InvocationHandler h: 代理对象的调用处理程序
         */
        SellTickets proxyObject = (SellTickets) Proxy.newProxyInstance(
                station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                /*
                  Object proxy: 代理对象。和 proxyObject 对象是同一个对象，在 invoke 方法中基本不用
                  Method method: 对接口中的方法进行封装的 method 对象
                  Object[] args: 调用方法的实际参数
                  返回值: 方法的返回值
                 */
                (proxy, method, args) -> {
                    System.out.println("收取服务费");
                    Object obj = method.invoke(station, args);
                    return obj;
                }
        );
        return proxyObject;
    }
}
