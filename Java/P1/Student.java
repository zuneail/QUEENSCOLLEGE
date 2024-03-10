
public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private Department department;

    public Student(int id, String name, Department dept) {
        setId(id).setName(name);
        this.department = dept;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public Student setDepartment(Department dept) {
        this.department = dept;
        return this;
    }

    public int hashCode() {
        return id;
    }

    public Student setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        return this;
    }

    public Student setName(String name) {
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id && name.equals(student.name) && department == student.department;
    }

    @Override
    public int compareTo(Student s) {
        return Integer.compare(this.id, s.id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
