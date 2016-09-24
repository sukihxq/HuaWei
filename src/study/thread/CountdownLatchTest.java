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
public class CountdownLatchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CountdownLatchTest().init();
	}
	public void init(){
		ExecutorService service = Executors.newCachedThreadPool();
		final CountDownLatch cdOrder = new CountDownLatch(1);
		final CountDownLatch cdAnswer = new CountDownLatch(3);
		for(int i=0;i<3;i++){
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						System.out.println("线程 "+Thread.currentThread().getName()+" 正在准备接受任务");
						cdOrder.await();
						System.out.println("线程 "+Thread.currentThread().getName()+" 已经接受命令");
						Thread.sleep((long) (10000*Math.random()));
						System.out.println("线程 "+Thread.currentThread().getName()+" 回应命令的处理结果");
						cdAnswer.countDown();
					}catch(Exception e){
						
					}finally {
						// TODO: handle finally clause
					}
				}
			};
			service.execute(runnable);
		}
		
		
		try{
			
			Thread.sleep((long)(10000*Math.random()));
			System.out.println("线程 "+Thread.currentThread().getName()+" 即将发布命令");
			cdOrder.countDown();
			System.out.println("线程 "+Thread.currentThread().getName()+" 已发布命令，等待结果中");
			cdAnswer.await();
			System.out.println("线程 "+Thread.currentThread().getName()+" 收到结果响应");
			
		}catch(Exception e){
			
		}
		
	service.shutdown();
	}

}
