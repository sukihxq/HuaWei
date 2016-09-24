/**
 * @project HuaWei
 * @package study.thread
 * @filename SemaphoreTest.java
 */
package study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月27日 下午1:23:30
 */
public class SemaphoreTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SemaphoreTest().init();
	}
	public void init(){
		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore sp = new Semaphore(3);
		for(int i=0;i<10;i++){
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						sp.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("线程 "+Thread.currentThread().getName()+" 已经进入，当前已有"+
					(3-sp.availablePermits())+" 个线程");
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("线程 "+Thread.currentThread().getName()+" 即将离开");
					sp.release();
					System.out.println("线程 "+Thread.currentThread().getName()+" 已离开");
				}
			};
			service.execute(runnable);
		}
		service.shutdown();
	}
	
}
