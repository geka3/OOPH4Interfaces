package net.ukr.geka3;

import java.util.Comparator;

public class ComparatorStudents implements Comparator{
	
	
	
	@Override
	public int compare(Object o1, Object o2) {
		
		if(o1 == null){
			return 1;
		}
		if(o2 == null){
			return -1;
		}
		return 0;
	}

	

}
