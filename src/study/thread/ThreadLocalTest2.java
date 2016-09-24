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
public class ThreadLocalTest2 {
	public static int data = 0;
	private static ThreadLocal<Integer> x = new ThreadLocal<>();
	private static ThreadLocal<Person> personThread = new ThreadLocal<>();
	public static Map<Thread, Integer> threadData = new HashMap<>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadLocalTest2().init();
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
					x.set(data);
					
					Person p = new Person();
					p.setAge(data);
					p.setName("name-"+data);
					personThread.set(p);
					new A().getData();
					new B().getData();
				}
			}).start();
		}
		
	}
	
	static class A{
		public void getData(){
			//int data  = threadData.get(Thread.currentThread());
			int data  = x.get();
			Person p = personThread.get();
			System.out.println(Thread.currentThread().getName()+" get data :"+data);
			System.out.println(Thread.currentThread().getName()+" get data :"+p.getName());
		}
	}
	static class B{
//		int data  = threadData.get(Thread.currentThread());
		public void getData(){
			int data  = x.get();
			Person p = personThread.get();
			System.out.println(Thread.currentThread().getName()+" get data :"+data);
			System.out.println(Thread.currentThread().getName()+" get data :"+p.getName());
		}
	}
	class Person{
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
}
