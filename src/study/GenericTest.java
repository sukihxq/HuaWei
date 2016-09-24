/**
 * @project HuaWei
 * @package study
 * @filename GenericTest.java
 */
package study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月30日 下午2:00:00
 */
public class GenericTest < T extends Comparable>{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new GenericTest().init();
	}
	public void init() throws Exception{
		ArrayList collection1 = new ArrayList();
		collection1.add(1);
		collection1.add(1l);
		collection1.add("abc");
		int i = (int) collection1.get(0);
		ArrayList<String> collection2 = new ArrayList();
//		collection1.add(1);
//		collection1.add(1l);
		collection2.add("abc");
		String tep1 = collection2.get(0);
		
		Constructor<String> constructor = String.class.getConstructor(String.class);
		String str = constructor.newInstance("abc");
		System.out.println(str);
		
		ArrayList<Integer> collection3 = new ArrayList<>();
		System.out.println(collection3.getClass()==collection2.getClass());
		
		collection3.getClass().getMethod("add", Object.class).invoke(collection3, "cde");
		System.out.println(collection3.get(0));
		
//		Vector<Integer>vector[] = new Vector<Integer>()[10];
		System.out.println("===============?===============");
		printCollection(collection3);
		
		System.out.println("==============================");
//		String.class.asSubclass(Number.class);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("stu", 20);
		map.put("stu2", 10);
		map.put("stu1", 15);
		
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for(Map.Entry<?, ?> entry:entries)
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		
		System.out.println("==============================");
		Object obj = "abc";
		String str1 = autoType(obj);
		
		Method method = GenericTest.class.getMethod("applyGeneric", Vector.class);
		Type[] type = method.getGenericParameterTypes();
		ParameterizedType pType = (ParameterizedType) type[0];
		System.out.println(pType);
		System.out.println(pType.getRawType());
		System.out.println(pType.getActualTypeArguments()[0]);
		
		
	}
	
	public void applyGeneric(Vector<Date> vector){
		
	}
	
	public <T>  T autoType(Object obj){
		return (T)obj;
	}
	public void printCollection(Collection<?> collection){
//		System.out.println(collection.size());
		for(Object obj:collection)
			System.out.println(obj);
	}
	public <T> void printCollection2(Collection<T> collection){
//		System.out.println(collection.size());
		for(Object obj:collection)
			System.out.println(obj);
	}
	
	public <T>T add(T x,T y){
		return null;
	}

}
