import java.util.Comparator;
import java.util.Iterator;


public class SortedArrayBag implements SortedBag {
    private Student[] students;
    private int size;
    private Comparator<Student> comparator;

    public SortedArrayBag() {
        this(4, null);
    }

    public SortedArrayBag(Comparator<Student> comp) {
        this(4, comp);
    }

    public SortedArrayBag(int capacity) {
        this(capacity < 4 ? 4 : capacity, null);
    }

    public SortedArrayBag(int capacity, Comparator<Student> comp) {
        this.students = new Student[capacity];
        this.size = 0;
        this.comparator = comp;
    }

    public void add(Student s) {
        if (size == students.length) {
            throw new BagFullException();
        }

        int index = findInsertIndex(s);
        System.arraycopy(students, index, students, index + 1, size - index);
        students[index] = s;
        size++;
    }

    public void remove(Student s) {
        int index = findIndex(s);
        if (index != -1) {
            if (index < size - 1) {
                // Shift elements after the removed element
                System.arraycopy(students, index + 1, students, index, size - index - 1);
            }
            students[size - 1] = null;  // Clear the reference to the last element
            size--;
        }
    }
    
    
    public boolean contains(Student s) {
        return findIndex(s) != -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            students[i] = null;
        }
        size = 0;
    }

    public Student first() {
        return size > 0 ? students[0] : null;
    }

    public Student last() {
        return size > 0 ? students[size - 1] : null;
    }

    public Student lower(Student s) {
        int index = findIndex(s);
        return index > 0 ? students[index - 1] : null;
    }

    public Student higher(Student s) {
        int index = findIndex(s);
        return index < size - 1 ? students[index + 1] : null;
    }

    public Iterator<Student> iterator() {
        return new SortedArrayBagIterator();
    }

    private int findIndex(Student s) {
        for (int i = 0; i < size; i++) {
            if (students[i].equals(s)) {
                return i;
            }
        }
        return -1;  // Student not found
    }

    private int findInsertIndex(Student s) {
        if (comparator != null) {
            return binarySearch(s, comparator);
        } else {
            return binarySearch(s, Comparator.naturalOrder());
        }
    }

    private int binarySearch(Student key, Comparator<Student> c) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Student midVal = students[mid];
            int cmp = c.compare(midVal, key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return low;  // key not found
    }

    private class SortedArrayBagIterator implements Iterator<Student> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < size;
        }

        public Student next() {
            if (hasNext()) {
                return students[currentIndex++];
            } else {
                throw new IllegalStateException("No more elements");
            }
        }
    }
}
