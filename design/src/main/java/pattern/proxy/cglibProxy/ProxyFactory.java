package pattern.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    private TrainStation station = new TrainStation();

    public TrainStation getProxyObject() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TrainStation.class); // 设置父类的字节码对象
        enhancer.setCallback(this); // 设置回调函数
        TrainStation proxyObject = (TrainStation) enhancer.create(); // 创建代理对象
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法执行了");
        return method.invoke(station, objects);
    }
}
