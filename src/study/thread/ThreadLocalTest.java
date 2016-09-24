/**
 * @project HuaWei
 * @package study.thread
 * @filename ThreadScopeShareData.java
 */
package study.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月24日 下午8:09:29
 */
public class ThreadLocalTest {
	public static int data = 0;
	public static Map<Thread, Integer> threadData = new HashMap<>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadLocalTest().init();
	}
	public void init(){
		for(int i=0;i<3;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+" put data :"+data);
					//threadData.put(Thread.currentThread(), data);
					
					Person p =Person.getInstance();
					p.setAge(data);
					p.setName("name-"+data);
					new A().getData();
					new B().getData();
				}
			}).start();
		}
		
	}
	
	static class A{
		public void getData(){
			//int data  = threadData.get(Thread.currentThread());
			Person p = Person.getInstance();
			System.out.println(Thread.currentThread().getName()+" get data :"+p.getName());
		}
	}
	static class B{
//		int data  = threadData.get(Thread.currentThread());
		public void getData(){
			Person p = Person.getInstance();
			System.out.println(Thread.currentThread().getName()+" get data :"+p.getName());
		}
	}

}



class Person{
	private Person(){}
	private static ThreadLocal<Person> threadLocal = new ThreadLocal<>();
	private static Person person = new Person();
	
	public final static Person getInstance(){
		Person p = threadLocal.get();
		if(p==null){
			p = new Person();
			threadLocal.set(p);
		}
		return p;
	}
	
	
	int age= 0;
	String name = "";
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
