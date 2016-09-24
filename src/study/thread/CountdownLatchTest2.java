/**
 * @project HuaWei
 * @package study.thread
 * @filename CountdownLatchTest.java
 */
package study.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.midi.SysexMessage;
import javax.swing.plaf.SliderUI;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月27日 下午2:07:01
 */
public class CountdownLatchTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CountdownLatchTest2().init();
	}
	public void init(){
		ExecutorService service = Executors.newCachedThreadPool();
		final CountDownLatch cdOrder = new CountDownLatch(3);
		final CountDownLatch cdAnswer = new CountDownLatch(1);
		for(int i=0;i<3;i++){
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						
						System.out.println("线程 "+Thread.currentThread().getName()+" 正在准备");
						Thread.sleep((long) (10000*Math.random()));
						
						System.out.println("线程 "+Thread.currentThread().getName()+" 已经结束");
						cdOrder.countDown();
						
					}catch(Exception e){
						
					}finally {
						// TODO: handle finally clause
						
					}
				}
			};
			service.execute(runnable);
		}
		
		
		try{
			
			Thread.sleep((long) (10000*Math.random()));
			System.out.println("线程 "+Thread.currentThread().getName()+" 等待签字");
			cdOrder.await();
			cdAnswer.countDown();
			System.out.println("线程 "+Thread.currentThread().getName()+" 收到所有的签字结果");
			
		}catch(Exception e){
			
		}
		
		service.shutdown();
	
	}

}
