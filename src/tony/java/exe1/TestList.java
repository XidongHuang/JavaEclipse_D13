package tony.java.exe1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class TestList {
	@Test
	public void testList()
	{
		List list = new ArrayList();
		list.add(234);
		list.add(753);
		list.add("ADS");
		list.add("BB");
		
		Iterator iterator = list.iterator();
		//
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		//增强for循环
		for(Object i: list){
			System.out.println(i);
		}
		System.out.println();
		//一般for循环
		for(int i = 0; i< list.size();i++){
			System.out.println(list.get(i));
		}

	}
	
	@Test
	public void test1(){
		List<Integer> list1 = new ArrayList();
		
		list1.add(new Integer("33"));
		list1.add(new Integer(54));
		list1.add(new Integer(31));
		list1.add(new Integer("12"));
		
		Iterator iterator = list1.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println(list1);
	}
	
}
