package pattern.singleton;

/**
 * 懒汉式：静态内部类方式
 */
public class Singleton5 {

    private Singleton5() {
    }

    static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
