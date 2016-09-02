package net.ukr.geka3;

import java.util.Arrays;
import java.util.Comparator;

public class Group implements AddDeleteStudents, Voenkom {
	private String name;
	//create array for students
	private Student[] array = new Student[10];

	//constructors
	public Group(String name, Student[] array) {
		super();
		this.name = name;
		this.array = array;
	}

	public Group() {
		super();
	}

	@Override
	public void addStudent(Student st) throws FullGroupException {
		// TODO Auto-generated method stub
		if (st == null) {
			throw new NullPointerException("Student is null");

		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = st;
				return;
			}
		}
		throw new FullGroupException("Group " + name + " is full");

	}
	//just delete one student by index
	@Override
	public void deleteStudent(int i) {
		// TODO Auto-generated method stub
		array[i] = null;

	}
	
	//resize array (plus one) 
	public static Student[] arrayPlusOne(Student[] stdArray) {
		Student[] temp = new Student[stdArray.length + 1];
		System.arraycopy(stdArray, 0, temp, 0, stdArray.length);
		return temp;
	}

	//get array student for army
	@Override
	public Student[] getForMilitaryService() {
		int n = 0;
		Student[] temp = new Student[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null && array[i].sex && array[i].age >= 18) {
				temp = arrayPlusOne(temp);
				temp[n] = array[i];
				n++;
			}
		}
		return temp;
	}
	//method for sorting
	public void sort(Comparator comparator) {
		Arrays.sort(this.array, comparator);

	}
	
	public Student[] getArray() {
		return array;
	}

	public String getStudentsInfo() {
		StringBuilder sb = new StringBuilder();
		for (Student student : array) {
			if (student != null) {
				sb.append(student.toString());
			} else {
				sb.append("[null]" + System.lineSeparator());
			}

		}
		return sb.toString();
	}
	//delete student by family return count of deleted students
	@Override
	public int deleteStudentBySurName(String surName) {
		// TODO Auto-generated method stub
		int i = 0;
		for (int j = 0; j < array.length; j++) {
			if(array[j] != null && (array[j].surName).equals(surName)){
				array[j] = null;
				i++;
			}
		}
		return i;
	}

}
