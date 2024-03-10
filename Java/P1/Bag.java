import java.util.Iterator;

interface Bag extends Iterable<Student> {
    void add(Student s);
    void remove(Student s);
    boolean contains(Student s);
    boolean isEmpty();
    int size();
    void clear();
    Iterator<Student> iterator();
}