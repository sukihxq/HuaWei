/**
 * @project HuaWei
 * @package study.thread
 * @filename TreadtionThreadSynchronized.java
 */
package study.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月24日 下午3:14:48
 */
public class TreadtionThreadLockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TreadtionThreadLockTest().init();
	}
	public void init(){
		fun1();
	}
	public void fun1(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
					Outer.outer("xushihua");
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
					Outer.outer("liudehua");
			}
		}).start();
	}
	static class Outer{
		static Lock lock = new ReentrantLock();
		public static void outer(String name){
			lock.lock();
			try {
				for(int i=0;i<name.length();i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
				
			} finally {
				lock.unlock();
			}
		}
	}
	

}
