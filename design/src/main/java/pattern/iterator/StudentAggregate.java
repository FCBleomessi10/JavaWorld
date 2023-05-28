package pattern.iterator;

public interface StudentAggregate {
    void addStudent(Student stu);

    void removeStudent(Student stu);

    StudentIterator getStudentIterator();
}
