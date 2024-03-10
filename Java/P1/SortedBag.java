public interface SortedBag extends Bag {
    Student first();
    Student last();
    Student lower(Student s);
    Student higher(Student s);
}