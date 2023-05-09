package pattern.singleton;

import java.lang.reflect.Constructor;

public class InflectDestroy {
    public static void main(String[] args) throws Exception {
        Class<Singleton> clazz = Singleton.class;
        Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton instance1 = constructor.newInstance();
        Singleton instance2 = constructor.newInstance();
        System.out.println(instance1 == instance2);
    }
}

class Singleton {

    private static boolean flag = false;

    public Singleton() {
        synchronized (Singleton.class) {
            if (flag) {
                throw new RuntimeException();
            } else {
                flag = true;
            }
        }
    }

    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance != null) {
            instance = new Singleton();
        }
        return instance;
    }
}
