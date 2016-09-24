/**
 * @project HuaWei
 * @package study
 * @filename Reflect.java
 */
package study;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
public class Reflect {
	public static void main(String[] args) throws Exception {
		new Reflect().init();
		
	}
	private void init() throws Exception{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String abc = "abc";
		Class cla1 = abc.getClass();
		Class cla2 = String.class;
		Class cla3 = Class.forName("java.lang.String");
		System.out.println(cla1==cla2);
		System.out.println(cla1==cla3);
		System.out.println(cla2==cla3);
		System.out.println(cla1.isPrimitive());
		System.out.println(int.class.isPrimitive());
		System.out.println(int.class==Integer.class);
		System.out.println(int.class==Integer.TYPE);
		
		Constructor<?> constructor = String.class.getConstructor(StringBuffer.class);
		String str1 = constructor.newInstance(new StringBuffer("abc")).toString();
		System.out.println(str1);
		
		ReflectPoint pt1 = new ReflectPoint(3, 5); 
		Field fieldY = pt1.getClass().getDeclaredField("y");
		fieldY.setAccessible(true);
		System.out.println(fieldY.get(pt1));
		Field fieldX = pt1.getClass().getDeclaredField("x");
		fieldX.setAccessible(true);
		System.out.println(fieldX.get(pt1));
		
		changeString(pt1);
		System.out.println(pt1);
		
		String []te=new String[]{"123","S12"};
		Method methodCharAt = String.class.getMethod("charAt", int.class);
		System.out.println(methodCharAt.invoke(str1, 1));
		
		String tt = "Test";
		String str2 = "java.lang.String";
		Method m1 = Class.forName(str2).getMethod("charAt", int.class);
		System.out.println(m1.invoke(tt, 1));
		
		Method methodMain = TestArgues.class.getMethod("main", String[].class);
//		methodMain.invoke(null, new Object[]{ new String[]{"123","test"}});
		methodMain.invoke(null, (Object)new String[]{"123","test"});
		
		int [] a1 = new int[]{1,2};
		int [] a2 = new int[]{4,5,6};
		int [][] a3 = new int[2][3];
		String [] a4 = new String[]{"a","b","c"};
		
		System.out.println(a1.getClass()==a2.getClass());
		System.out.println(a2.getClass());
		System.out.println(a3.getClass());
		System.out.println(a1.getClass() == a2.getClass());
		System.out.println(a4.getClass());
		System.out.println(a1.getClass().getSuperclass().getName());
		System.out.println(a4.getClass().getSuperclass().getName());
		
		System.out.println(Arrays.asList(a1));
		System.out.println(Arrays.asList(a2));
		System.out.println(Arrays.asList(a4));
		System.out.println("==============");
		Object obj = null;
		printObject(obj);
		printObject("abc");
		printObject(a4);
		List list = new ArrayList<>();
		list.add("xyz");
		list.add("abc");
		printObject(list);
//		Entry<String, Integer> e = (Entry<String, Integer>) new HashMap();
		
	}
	/**
	 * @param obj
	 */
	private void printObject(Object obj) {
		// TODO Auto-generated method stub
		if(obj==null){
			System.out.println(obj);
			return;
		}
		Class clazz = obj.getClass();
		if(clazz.isArray()){
			int len = Array.getLength(obj);
			for(int i=0;i<len;i++)
				System.out.print(Array.get(obj, i));
			System.out.println();
		}else {
			System.out.println(obj);
		}
	}
	public void changeString(Object obj) throws Exception {
		// TODO Auto-generated method stub
		Field [] fields = obj.getClass().getFields();
		for(Field f:fields){
			if(f.getType()==String.class){
				String oldValue = (String)f.get(obj);
				String newValue = oldValue.replace('b', 'a');
				f.set(obj, newValue);
			}
		}
		//System.out.println(obj);
		
	}

}


class TestArgues{
	public static void main(String []args){
		for(String s:args){
			System.out.print(s+" ");
		}
		System.out.println();
	}
}