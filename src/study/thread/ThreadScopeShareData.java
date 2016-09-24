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
public class ThreadScopeShareData {
	public static int data = 0;
	public static Map<Thread, Integer> threadData = new HashMap<>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadScopeShareData().init();
	}
	public void init(){
		for(int i=0;i<3;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+" put data :"+data);
					threadData.put(Thread.currentThread(), data);
					new A().getData();
					new B().getData();
				}
			}).start();
		}
		
	}
	
	static class A{
		public void getData(){
			int data  = threadData.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName()+" get data :"+data);
		}
	}
	static class B{
		int data  = threadData.get(Thread.currentThread());
		public void getData(){
			System.out.println(Thread.currentThread().getName()+" get data :"+data);
		}
	}

}
