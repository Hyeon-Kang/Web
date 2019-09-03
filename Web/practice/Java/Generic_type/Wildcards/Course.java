package WildCards;

public class Course<T> { // 일반인, 학생, 근로자 등등 여러 타입의 사람이 들어올 수 있도록 하는것이 목표

	// T 타입에 따라 수강생 종류 변경
	private String name;
	private T[] students;

	public Course(String name, int capacity) {
		this.name = name;
		students = (T[])(new Object[capacity]);
	}

	public String getName() {return name;}
	public T[] getStudents() {return students;}

	public void add(T t) {
		for(int i =0; i<students.length;i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}

}
