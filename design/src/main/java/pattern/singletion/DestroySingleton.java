package pattern.singletion;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DestroySingleton {
    public static void main(String[] args) throws Exception {
        writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    public static void readObjectFromFile() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("a.txt")));
        Singleton o = (Singleton) ois.readObject();
        System.out.println(o);
        ois.close();
    }

    public static void writeObject2File() throws Exception {
        Singleton instance = Singleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("a.txt")));
        oos.writeObject(instance);
        oos.close();
    }
}

//class Singleton implements Serializable {
//
//    private Singleton() {
//    }
//
//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    public static Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//
//    public Object readResolve() {
//        return SingletonHolder.INSTANCE;
//    }
//}
