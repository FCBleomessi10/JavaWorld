package pattern.singleton;

import java.io.Serializable;

/**
 * 饿汉式：静态成员变量
 */
public class Singleton1 implements Serializable {

    private Singleton1() {
    }

    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }
}
