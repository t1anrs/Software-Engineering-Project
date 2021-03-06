package Community;

import java.util.ArrayList;
import java.util.Iterator;

public class ListOfTeacher {
	
	private ArrayList<Teacher> teachers;
	
	public ListOfTeacher() {
		teachers = new ArrayList<>();
	}
	
	public void addataeacher(Teacher teacher) {
		teachers.add(teacher);
	}
	
	public ArrayList<Teacher> getSuitTeachers() {
		return teachers;
	}
	
	public Teacher getaTeacher(int index) {
		return teachers.get(index);
	}
	
	public int getTeachersSize() {
		return teachers.size();
	}
	
	public void print(ArrayList<Teacher> list) {
		Iterator<Teacher> it = list.iterator();
		while(it.hasNext()) {
			Teacher s = it.next();
			System.out.print(s + " ");
		}
	}

}
