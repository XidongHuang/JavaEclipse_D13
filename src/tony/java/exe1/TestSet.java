package tony.java.exe1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import javax.crypto.Cipher;
import javax.print.attribute.Size2DSyntax;

import org.junit.Test;
/*
 *  Collection 接口: 
 *  	|----List接口：
 *  			|---- ArrayList(主要的实现类)， 
 *  			|---- LinkedList(对于频繁的插入，删除操作)， 
 *  			|---- Vector(古老的实现类，线程安全的， 但效率要低于ArrayList)			
 * 		|----Set 接口:存储无序的，不可重复的元素, Set中常用的方法都是Collection下定义的。
 * 				|---- HashSet, (主要实现类)
 * 				|---- LinkedHashSet, 
 * 				|---- TreeSet
 * 
 * 
 * 
 */
public class TestSet {
	
	@Test
	public void testTreeSet3(){

		//创建匿名定制排序类
		TreeSet set = new TreeSet(new Comparator() {
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Customer && o2 instanceof Customer){
					Customer c1 = (Customer)o1;
					Customer c2 = (Customer)o2;
					int i = c1.getId().compareTo(c2.getId());
					if(i == 0){
						return c1.getName().compareTo(c2.getName());
					}
					
					return i;
					
					
				}
				
				return 0;
			}
		});
		
		set.add(new Customer("AA", 1003));
		set.add(new Customer("MM", 1001));
		set.add(new Customer("KK", 1005));
		set.add(new Customer("BB", 1001));
		
		for(Object str:set){
			System.out.println(str);
		}
		
	}
	
	
	
	/*
	 * TreeSet 的定制排序：当编写程序的时候，创建的类不能修改，那只能在外创建插口
	 * 步骤:
	 * 
	 * 
	 * compare()与hashCode()以及equals()三者保持一致
	 * 
	 */
	
	@Test
	public void testTreeSet2(){
		
		
		//1. 创建一个实现了Comparater接口的类的对象
		Comparator com = new Comparator(){
			//向TreeSet中添加Customer类的对象，在此compare()方法中，指名是按照Customer
			//的哪个属性排序的。
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Customer && o2 instanceof Customer){
					Customer c1 = (Customer)o1;
					Customer c2 = (Customer)o2;
					int i = c1.getId().compareTo(c2.getId());
					if(i == 0){
						return c1.getName().compareTo(c2.getName());
					}
					
					return i;
					
					
				}
				
				return 0;
			}
			
		};
		
		//2. 将此对象作为形参传递给TreeSet的构造器中
		TreeSet set = new TreeSet(com);
		//3. 向TreeSet中添加Comparator接口中的compare方法中涉及的类的对象
		set.add(new Customer("AA", 1003));
		set.add(new Customer("MM", 1001));
		set.add(new Customer("KK", 1005));
		set.add(new Customer("BB", 1001));
		
		for(Object str:set){
			System.out.println(str);
		}
		
	}
	
	
	/*
	 * TreeSet:
	 * 1. 向TreeSet 中添加的元素必须是同一个类的。
	 * 2. 可以按照添加进集合中的元素的指定的顺序遍历。像String, 包装类等默认按照从小到大的顺序遍历。
	 * 3. 当向TreeSet中添加自定义类的对象时，有两种排序方法：a. 自然排序 b. 定制排序
	 * 4. 自然排序：要求自定义类实现java.lang.Comparable接口并重写其comparaTo(Object obj)方法
	 * 	在此方法中，指名按照自定义类的哪个属性进行排序。
	 * 5. 向TreeSet中添加元素时，首先按照compareTo() 进行比较，一旦返回0，虽然仅是两个对象的此属性值相同，
	 * 	但程序会认为这两个对象是相同过的，进而后一个对象就不能添加进来。
	 * 
	 * >所以要求compareTo() 与 hashCode()以及 equals()保持一直
	 * 
	 * 
	 */
	
	@Test
	public void testTreeSet1(){
		Set set = new TreeSet();
//		set.add(123);
//		set.add(456);
//		set.add("AA");
//		set.add("BB");
//		set.add("NN");
//		set.add("CC");
		
		
		//当Person类没有实现Comparable接口时，当向TreeSet中添加Person对象时，报ClassCastException.
		set.add(new Person("CC", 23));
		set.add(new Person("GG", 24));
		set.add(new Person("MM", 21));
		set.add(new Person("DD", 27));
		set.add(new Person("AA", 30));
		set.add(new Person("LL", 30));
		
		for(Object i: set){
			System.out.println(i);
		}
		System.out.println();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}
	
	
	
	
	
	
	
	
	/*
	 * LinkedHashSet: 使用链表维护类一个添加进集合中的顺序。导致当我们遍历LinkedHashSet集合
	 * 元素时，是按照添加进去的顺序遍历！
	 * LinkedHashSet 插入性能略低于HashSet, 但在迭代访问Set 里的全部元素时很好的性能。
	 * 
	 */
	
	
	@Test
	public void testLinkedHashSet(){
		Set set = new LinkedHashSet();
		set.add(123);
		set.add(456);
		set.add("AA");
		set.add("BB");
		set.add(null);
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		
		System.out.println(set);
	}
	
	
	
	/*
	 * Set: 存储的元素是无须的，不可重复的！
	 * 1. 无序性：无序性！= 随机性。 真正的无须性，指的是元素在底层存储的位置是无序的
	 * 2. 不可重复性： 当向Set中添加进相同的元素的时候，后面的这个不能添加进去；
	 * 
	 * 说明：要求添加进Set 中的元素所在的类，一定要重写equals()和hashCode()方法
	 * 进而保证Set 中元素的不可重复性！
	 * 
	 * Set 中的元素是如何存储的呢？使用 hash 算法
	 * 当向Set中添加对象时，首先调用此对象所在类的hashCode()方法，计算此对象的hash值，
	 * 此hash值决定类次对想在Set中的存储位置，若此位置之前没有对象存储，则这个对象直接存储到此位置。 若此位置已有对象存储，再通过equals()比较这两个对象时候相同。如果相同，后一个对象就不能再添加进来。
	 * 万一返回false呢。(不建议如此)
	 * > 要求：hashCode()方法要与equals()方法一致。
	 * 
	 */
	
	@Test
	public void testHashSet(){
		Set set = new HashSet();
		set.add(123);
		set.add(456);
		set.add("AA");
		set.add("BB");
		set.add(null);
		Person p1 = new Person("GG", 23);
		Person p2 = new Person("GG", 23);
		System.out.println(p1.equals(p2));
		set.add(p1);
		set.add(p2);
		
		System.out.println(set.size());
		System.out.println(set);
			
	}
	
	@Test
	public void test1(){
		Set s = new HashSet();
		s.add(3452);
		s.add("41");
		s.add("tew");
		s.add('d');
		
		Iterator i = s.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		System.out.println();
		System.out.println(s);
		
		
	}
	
	
}
