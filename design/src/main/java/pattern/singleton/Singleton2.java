package pattern.singleton;

/**
 * 饿汉式：静态代码块
 */
public class Singleton2 {

    private Singleton2() {}

    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
