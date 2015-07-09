package tony.java.exe2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestTreeSet {
	@Test
	public void test2(){
		Comparator com =  new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Employee1 && o2 instanceof Employee1){
					Employee1 e1 = (Employee1)o1;
					Employee1 e2 = (Employee1)o2;
					MyDate b1 = e1.getBirthday();
					MyDate b2 = e2.getBirthday();
					
					if(b1.getYear() != b2.getYear()){
						return b1.getYear() - b2.getYear();
					} else {
						if(b1.getMonth() != b2.getMonth()){
							return b1.getMonth() - b2.getMonth();
						} else {
							return b1.getDay() - b2.getDay();
						}
					}
					
					
				}
				return 0;
			}
		};
		
		
		
		TreeSet set1 = new TreeSet(com);
		Employee1 e1 = new Employee1("MM", 32, new MyDate(12, 23, 1978));
		Employee1 e2 = new Employee1("SS", 23, new MyDate(5, 23, 1995));
		Employee1 e3 = new Employee1("WW", 54, new MyDate(1, 6, 1974));
		Employee1 e4 = new Employee1("FF", 21, new MyDate(6, 20, 1984));
		Employee1 e5 = new Employee1("GG", 64, new MyDate(8, 4, 1994));
		Employee1 e6 = new Employee1("BB", 23, new MyDate(6, 12, 1987));
		Employee1 e7 = new Employee1("JJ", 35, new MyDate(2, 7, 1996));
		Employee1 e8 = new Employee1("JJ", 36, new MyDate(5, 8, 1995));
		set1.add(e5);
		set1.add(e1);
		set1.add(e2);
		System.out.println(e2.getName());
		System.out.println(set1.contains(e1));
		set1.add(e3);
		set1.add(e4);
		set1.add(e5); 
		set1.add(e6);
		set1.add(e7);
		set1.add(e8);
		System.out.println(set1.size());
		
//		Iterator i = set.iterator();
//		while(i.hasNext()){
//			System.out.println(i.next());
//		}
		
		for(Object i : set1){
			System.out.println(i);
		}
		
		
	}
	
	
	
	
	
	
	@Test
	public void test1() {
		Set set = new TreeSet();

		Employee e1 = new Employee("MM", 32, new MyDate(12, 23, 1978));
		Employee e2 = new Employee("SS", 23, new MyDate(5, 23, 1995));
		Employee e3 = new Employee("WW", 54, new MyDate(1, 6, 1974));
		Employee e4 = new Employee("FF", 21, new MyDate(6, 20, 1984));
		Employee e5 = new Employee("GG", 64, new MyDate(8, 4, 1994));
		Employee e6 = new Employee("BB", 23, new MyDate(6, 12, 1987));
		Employee e7 = new Employee("JJ", 35, new MyDate(2, 7, 1996));
		Employee e8 = new Employee("JJ", 36, new MyDate(5, 8, 1995));
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		set.add(e6);
		set.add(e7);
//		set.add(e8);
		System.out.println(set.contains(e8));
		
		Iterator i = set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}
}
