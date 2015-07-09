package tony.java.exe1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
/*
 * 操作Collection以及Map的工具类: Collections
 * 
 * 面试题： 区分Collection与Collections
 * Collection:
 * 
 * 
 */
public class TestCollections {

	/*
	 * reverse(List):反转 List 中元素的顺序
	 * shuffle(List): 对List 集合元素进行随机排序
	 * sort(List)： 根据元素的自然顺序对指定List集合元素按升序排序
	 * sort(List, Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
	 * swap（List, int, int): 将指定list 集合中的i出元素和j处元素进行交换
	 * 
	 * 
	 * 
	 */
	
	@Test
	public void testCollections1(){
		List list= new ArrayList();
		
		list.add(123);
		list.add(532);
		list.add(12);
		list.add(643);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.swap(list, 0, 2);
		System.out.println(list);
		
		
		
	}
	
	
	@Test
	public void testCollections2(){
		List list = new ArrayList();
		list.add(123);
		list.add(543);
		list.add(98);
		list.add(61);
		
		Object object = Collections.max(list);
		System.out.println(object);
		int count = Collections.frequency(list, 543);
		System.out.println(count);
		
		System.out.println();
//		List list1 = new ArrayList(); 错误的实现方式
		List list1 = Arrays.asList(new Object[list.size()]);
		Collections.copy(list1, list);
		System.out.println(list1);
		//通过如下的方法保证list的线程安全性
		List list2 = Collections.synchronizedList(list);
		System.out.println(list2);
		
	}
	
	
	
}
