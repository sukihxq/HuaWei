/**
 * @project HuaWei
 * @package study.thread
 * @filename ThreadPoolTest.java
 */
package study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月26日 下午3:18:19
 */
public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadPoolTest().init();
	}

	public void init(){
//		ExecutorService threadPool = Executors.newFixedThreadPool(3);
//		ExecutorService threadPool = Executors.newCachedThreadPool();
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		System.out.println("10 task is commiting");
		for(int i=1;i<=10;i++){
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int j = 1;
					
					try{
						Thread.sleep(500);
					}catch(Exception e){
						
					}
					
					while(j<=10){
						j++;
						System.out.println(Thread.currentThread().getName()+" is looping "+j+" for task of "+task);
					}
				}
			});
			
		}
		System.out.println("10 task is commit");
		threadPool.shutdown();
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bombing...");
			}
		}, 6,2,TimeUnit.SECONDS);
	}
}
