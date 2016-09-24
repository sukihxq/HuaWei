/**
 * @project HuaWei
 * @package study.thread
 * @filename TreadtionThreadCommication.java
 */
package study.thread;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import study.thread.ReadWriteLockTest.Queue3;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月24日 下午7:31:24
 */
public class BlockingQueueCommication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BlockingQueueCommication().init();
	}
	public void init() {
		Business business = new Business();
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					business.sub(2);
				}
			}
		});
		thread1.start();
		
		while(true){
			business.main(1);
			
		}
		
//		System.exit(0);
	}
	
	static class Business{
		ArrayBlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);
		ArrayBlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);
		{
			Collections.synchronizedMap(null);
			try {
				queue2.put(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void main(int count){
			try {
				queue1.put(1);
				System.out.println("main thread sequence of "+count);
				queue2.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void sub(int count){
			try {
				queue2.put(2);
				System.out.println("sub thread sequence of "+count);
				queue1.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}


