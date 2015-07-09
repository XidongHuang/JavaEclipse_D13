package tony.java.exe1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import tony.java.exe2.Employee1;
import tony.java.exe2.MyDate;
/*
 * Collection 接口
 * 
 * Map 接口
 * 	|—— HashMap: Map的主要实现类
 * 	|—— LinkedHashMap:使用链表维护添加进Map中的顺序。故遍历Map时，是按添加的顺序遍历的。
 * 	|—— TreeMap:按照添加进Map中的元素的指定属性进行排序。要求:key必须是同一个类的对象(要比较)
 * 			针对：自然排序 VS 定制排序
 * 	|—— Hashtable:古老的现实类，线程安全，不建议使用
 * 		|—— Properties:常用来处理文件。键和值都为String类型的
 *
 * 
 * 
 */


public class TestMap {
	//使用properties处理文件
	@Test
	public void test6() throws FileNotFoundException, IOException{
		Properties pros = new Properties();
		pros.load(new FileInputStream(new File("jdf.properties")));
		String user = pros.getProperty("user");
		System.out.println(user);
		String password = pros.getProperty("password");
		System.out.println(password);
		
	}
	
	
	
	//定制排序
	@Test
	public void test5(){
		Comparator com = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Employee1 && o2 instanceof Employee1){
					Employee1 e1= (Employee1)o1;
					Employee1 e2 = (Employee1)o2;
					
					int i = e1.getAge().compareTo(e1.getAge());
					if(i == 0){
						return e1.getName().compareTo(e2.getName());
					}
					return i;
					
				}
				return 0;
			}
		};
		
		TreeMap map = new TreeMap(com);
		map.put(new Employee1("AA",25,new MyDate(6, 24, 1998)), 89);
		map.put(new Employee1("FF",26,new MyDate(2, 8, 1999)), 45);
		map.put(new Employee1("BB",83,new MyDate(3, 14, 1975)), 99);
		map.put(new Employee1("YY",13,new MyDate(11, 26, 1964)), 69);
		
		Set set2 = map.keySet();
		
		for(Object j : set2){
			System.out.println(j+"------"+map.get(j));
		}
		
	}
	
	
	
	//自然排序
	@Test
	public void test4(){
			Map map = new TreeMap();
			map.put(new Person("AA",23), 89);
			map.put(new Person("FF",20), 45);
			map.put(new Person("BB",23), 99);
			map.put(new Person("MM",18), 69);
			
			
			Set set1 = map.keySet();
			for(Object s:set1){
				System.out.println(s+"-----"+map.get(s));
			}
			
			
			
	}
	
	
	
	
	@Test
	public void test3(){
		Map map = new LinkedHashMap();
		map.put("AA", 231);
		map.put("BB", 53);
		map.put(123,"CC");
		map.put(null,null);
		map.put(new Person("DD", 23),89);
		
		Set set1= map.keySet();
		for(Object s:set1){
			System.out.println(s+"-----"+map.get(s));
		}
	}
	
	
	
	/*
	 * 如何遍历Map
	 * Set keySet()
	 * Collection values()
	 * Set entrySet()
	 * 
	 */
	
	@Test
	public void test2(){
		Map map = new HashMap();
		map.put("AA", 231);
		map.put("BB", 53);
		map.put(123,"CC");
		map.put(null,null);
		map.put(new Person("DD", 23),89);
		
		
		//1. 遍历key集
		Set set = map.keySet();
		
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		//2. 遍历value集
		Collection values = map.values();
		Iterator i = values.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		System.out.println();
		//3.如何遍历key-value对
		//方式一：
		Set set1 = map.keySet();
		for(Object q : set1){
			System.out.println(q+"-----"+ map.get(q));
		}
		System.out.println();
		//方式二：
		Set set2 = map.entrySet();
		for(Object w: set2){
			Map.Entry entry = (Map.Entry)w;
			System.out.println(entry);
		}
	
		
	}
	
	
	
	
	
	/*
	 * Object put(Object key, Object value): 向Map中添加一个元素
	 * Object remove(Object key):按指定index删除key-value
	 * void puttAll(Map t):
	 * void clear():清空
	 * Object get(Object key):获取指定key的value值 。若无此key, 则返回null
	 * boolean containsKey(Object key):
	 * boolean containsValue(Object value):
	 * int size():返回集合的长度
	 * boolean isEmpaty():
	 * boolean eauqls(Object obj)
	 * 
	 * HashMap: 
	 * 1. Key是用Set来存放的，不可重复。value是用Coolection来存放的，可重复一个key-value对，是
	 * 一个Entry。所有Entry是用来Set存放的，也是不可重复的。
	 * 2. 向HashMap添加元素时，会调用key所在类的equals()方法，判断两个key是否相同。若相同
	 * 
	 * 
	 */
	
	
	
	
}
