package pattern.prototype.case2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CitationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Citation c1 = new Citation();
        Student student = new Student();
        student.setName("s1");
        c1.setStu(student);

        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("a.txt")));
        oos.writeObject(c1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("a.txt")));
        Citation c2 = (Citation) ois.readObject();
        ois.close();
        Student stu = c2.getStu();
        stu.setName("s2");

        c1.show();
        c2.show();
    }
}
