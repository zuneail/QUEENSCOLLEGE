public class Test22_23_24 {
	static int Test1(){
		int score = 0;
		SortedBag bag = new SortedArrayBag(10);

		Student [] students = new Student[5];
		students[0] = new Student(4, "Omar Vazques", Department.GEO);
		students[1] = new Student(1, "John Doe", Department.CSCI);
		students[2] = new Student(3, "Sarit Agrawal", Department.BIO);
		students[3] = new Student(5, "Jennifer Wu", Department.CHEM);
		students[4] = new Student(2, "Judy Johnson", Department.PHYSICS);
		Student dummyStudent = new Student(6, "No name", Department.NONE);

		// Test bag.add()
		for (int i=0; i<students.length; i++){
			bag.add(students[i]);
		} // end-for
		
		if (bag.size() == students.length) score += 2;
		if (!bag.isEmpty()) score += 2;

		// Test bag.clear()
		bag.clear();
		if (bag.isEmpty()) score += 2;
		if (bag.size() == 0) score += 2;

		// Add all students again
		for (int i=0; i<students.length; i++){
			bag.add(students[i]);
		} // end-for

		// Test first & last
		if (bag.first().equals(students[1])) score += 5;
		if (bag.last().equals(students[3])) score += 5;

		// Test lower & higher
		Student lower = bag.lower(students[4]);
		if (lower.equals(students[1])) score += 5;

		Student higher = bag.higher(students[2]);
		if (higher.equals(students[0])) score += 5;

		// Test the Iterator
		boolean ok = true;
		int id = 1;
		for (var s: bag){
			if (s.getId() != id){
				ok = false;
				break;
			}
			id++;
		} // end-for
		if (ok) score += 30;

		// Test contains & remove
		for (int i=0; i<students.length; i++){
			if (bag.contains(students[i])) score += 2;
		} // end-for

		if (!bag.contains(dummyStudent)) score += 5;
		bag.remove(dummyStudent);
		if (!bag.contains(dummyStudent)) score += 5;

		for (int i=0; i<students.length; i++){
			bag.remove(students[i]);
			if (!bag.contains(students[i])) score += 2;
			if (bag.size() == students.length-i-1) score += 2;
		} // end-for

		if (bag.isEmpty()) score += 2;
		
		return score;
	} // end-Test1

	static int Test2(){
		int score = 0;		

		// Sorted in reverse order wrt. id.		
		SortedBag bag = new SortedArrayBag(10, (s1, s2)->s2.getId()-s1.getId());

		Student [] students = new Student[5];
		students[0] = new Student(4, "Omar Vazques", Department.GEO);
		students[1] = new Student(1, "John Doe", Department.CSCI);
		students[2] = new Student(3, "Sarit Agrawal", Department.BIO);
		students[3] = new Student(5, "Jennifer Wu", Department.CHEM);
		students[4] = new Student(2, "Judy Johnson", Department.PHYSICS);
		Student dummyStudent = new Student(6, "No name", Department.NONE);

		// Test bag.add()
		for (int i=0; i<students.length; i++){
			bag.add(students[i]);
		} // end-for
		
		if (bag.size() == students.length) score += 2;
		if (!bag.isEmpty()) score += 2;

		// Test bag.clear()
		bag.clear();
		if (bag.isEmpty()) score += 2;
		if (bag.size() == 0) score += 2;

		// Add all students again
		for (int i=0; i<students.length; i++){
			bag.add(students[i]);
		} // end-for

		// Test first & last
		if (bag.first().equals(students[3])) score += 5;
		if (bag.last().equals(students[1])) score += 5;

		// Test lower & higher
		Student lower = bag.lower(students[4]);
		if (lower.equals(students[2])) score += 5;

		Student higher = bag.higher(students[2]);
		if (higher.equals(students[4])) score += 5;

		// Test the Iterator
		boolean ok = true;
		int id = 5;
		for (var s: bag){
			if (s.getId() != id){
				ok = false;
				break;
			}
			id--;
		} // end-for
		if (ok) score += 30;

		// Test contains & remove
		for (int i=0; i<students.length; i++){
			if (bag.contains(students[i])) score += 2;
		} // end-for

		if (!bag.contains(dummyStudent)) score += 5;
		bag.remove(dummyStudent);
		if (!bag.contains(dummyStudent)) score += 5;

		for (int i=0; i<students.length; i++){
			bag.remove(students[i]);
			if (!bag.contains(students[i])) score += 2;
			if (bag.size() == students.length-i-1) score += 2;
		} // end-for

		if (bag.isEmpty()) score += 2;
		
		return score;
	} // end-Test2	

	static int Test3(){
		int score = 0;		

		// Sorted in ascending order by name
		SortedBag bag = new SortedArrayBag(10, (s1, s2)->s1.getName().compareTo(s2.getName()));

		Student [] students = new Student[5];
		students[0] = new Student(4, "Omar Vazques", Department.GEO);
		students[1] = new Student(1, "John Doe", Department.CSCI);
		students[2] = new Student(3, "Sarit Agrawal", Department.BIO);
		students[3] = new Student(5, "Jennifer Wu", Department.CHEM);
		students[4] = new Student(2, "Judy Johnson", Department.PHYSICS);
		Student dummyStudent = new Student(6, "No name", Department.NONE);

		// Test bag.add()
		for (int i=0; i<students.length; i++){
			bag.add(students[i]);
		} // end-for
		
		if (bag.size() == students.length) score += 2;
		if (!bag.isEmpty()) score += 2;

		// Test bag.clear()
		bag.clear();
		if (bag.isEmpty()) score += 2;
		if (bag.size() == 0) score += 2;

		// Add all students again
		for (int i=0; i<students.length; i++){
			bag.add(students[i]);
		} // end-for

		// Test first & last
		if (bag.first().equals(students[3])) score += 5;
		if (bag.last().equals(students[2])) score += 5;

		// Test lower & higher
		Student lower = bag.lower(students[4]);
		if (lower.equals(students[1])) score += 5;

		Student higher = bag.higher(students[0]);
		if (higher.equals(students[2])) score += 5;

		// Test the Iterator
		boolean ok = true;
		int [] expectedIds = {5, 1, 2, 4, 3};
		int index = 0;
		for (var s: bag){
			if (s.getId() != expectedIds[index++]){
				ok = false;
				break;
			}
		} // end-for
		if (ok) score += 30;

		// Test contains & remove
		for (int i=0; i<students.length; i++){
			if (bag.contains(students[i])) score += 2;
		} // end-for

		if (!bag.contains(dummyStudent)) score += 5;
		bag.remove(dummyStudent);
		if (!bag.contains(dummyStudent)) score += 5;

		for (int i=0; i<students.length; i++){
			bag.remove(students[i]);
			if (!bag.contains(students[i])) score += 2;
			if (bag.size() == students.length-i-1) score += 2;
		} // end-for

		if (bag.isEmpty()) score += 2;
		
		return score;
	} // end-Test3	

	public static void main(String [] args){
		int score = 0;

		score += Test1();
		score += Test2();
		score += Test3();

		System.out.printf("Your lab score %.2f\n", score/3.0);
	} // end-main
} //end-SortedLinkedbagTest