package net.ukr.geka3;

import java.util.Comparator;

public class ComparatorStudentsName implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		System.out.println("i am here");
		if(o1 == null){
			return -1;
		}
		if(o2 == null){
			return 1;
		}
		
		if(o1.getClass() == Student.class && o2.getClass() == Student.class){
		Student st1 = (Student) o1;
		Student st2 = (Student) o2;
		return (st1.name).compareToIgnoreCase(st2.name);
		}else {
			System.out.println("Error in classes");
			return 0;
		}
	}
	
}
