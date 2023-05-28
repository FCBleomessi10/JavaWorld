package pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class StudentAggregateImpl implements StudentAggregate {

    private List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student stu) {
        list.add(stu);
    }

    @Override
    public void removeStudent(Student stu) {
        list.remove(stu);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}
