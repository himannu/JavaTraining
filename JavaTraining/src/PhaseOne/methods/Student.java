package PhaseOne.methods;

public class Student {
	int rollNumber;
	String name;
	static String college = "MIT";
	
	Student(int id, String name) {
		this.rollNumber = id;
		this.name = name;
	}
	
	private static void changeCollege(String name) {
		college = name;
	}
	
	private void display() {
		System.out.println(this.rollNumber + "," + this.name + "," + Student.college);
	}
	
	public static void main(String[] args) {
		Student.changeCollege("DSP");
		Student s1 = new Student(111, "Mike");
		Student s2 = new Student(222, "John");
		Student s3 = new Student(333, "Smith");
		
		s1.display();
		s2.display();
		s3.display();
	}
	
}
