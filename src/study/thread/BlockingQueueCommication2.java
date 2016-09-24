/**
 * @project HuaWei
 * @package study.thread
 * @filename TreadtionThreadCommication.java
 */
package study.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月24日 下午7:31:24
 */
public class BlockingQueueCommication2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BlockingQueueCommication2().init();
	}
	public void init() {
		Business business = new Business();
		ArrayBlockingQueue queue1 = new ArrayBlockingQueue(1);
		ArrayBlockingQueue queue2 = new ArrayBlockingQueue(1);
		try {
			queue2.put(2);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						queue2.put(2);
						business.sub(2);
						queue1.take();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
		
		while(true){
			try {
				queue1.put(1);
				business.main(1);
				queue2.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		System.exit(0);
	}
	
	static class Business{
		public void main(int count){
			System.out.println("main thread sequence of "+count);
		}
		public void sub(int count){
			System.out.println("sub thread sequence of "+count);
			
		}
	}

}


