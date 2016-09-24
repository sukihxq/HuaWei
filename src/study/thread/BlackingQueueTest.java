/**
 * @project HuaWei
 * @package study.thread
 * @filename BlackingQueueTest.java
 */
package study.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月27日 下午3:09:03
 */
public class BlackingQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BlackingQueueTest().init();
	}
	public void init(){
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
		//2 put 1 out
		for(int i=0;i<2;i++){
			new Thread(){
				public void run() {
					while(true){
						try {
							Thread.sleep((long) (4000*Math.random()));
							System.out.println(Thread.currentThread().getName()+"准备放数据");
							queue.put(Thread.currentThread().getName());
							System.out.println(Thread.currentThread().getName()+"已经放入数据，已经有"+queue.size()+"个数据");
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				};
			}.start();
		}
		new Thread(){
			public void run() {
				while(true){
					try {
						Thread.sleep((long) (1000));
						System.out.println(Thread.currentThread().getName()+"准备取数据");
						queue.take();
						System.out.println(Thread.currentThread().getName()+"已经取完数据，还有"+queue.size()+"个数据");
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			};
		}.start();
	}

}
