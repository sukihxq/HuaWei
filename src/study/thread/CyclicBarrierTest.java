/**
 * @project HuaWei
 * @package study.thread
 * @filename CyclicBarrierTest.java
 */
package study.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.print.attribute.standard.Severity;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月27日 下午1:42:56
 */
public class CyclicBarrierTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CyclicBarrierTest().init();
	}
	public void init(){
		ExecutorService service = Executors.newCachedThreadPool();
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		for(int i=0;i<3;i++){
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep((long) (10000*Math.random()));
						System.out.println("线程 "+Thread.currentThread().getName()+" 即将到达地点1，当前已有"
						+(cyclicBarrier.getNumberWaiting()+1)+" 到达,"+(cyclicBarrier.getNumberWaiting()==2?"全部到齐，大家一起走！":"正在等候！"));
						cyclicBarrier.await();
						Thread.sleep((long) (10000*Math.random()));
						System.out.println("线程 "+Thread.currentThread().getName()+" 即将到达地点2，当前已有"
						+(cyclicBarrier.getNumberWaiting()+1)+" 到达,"+(cyclicBarrier.getNumberWaiting()==2?"全部到齐，大家一起走！":"正在等候！"));
						cyclicBarrier.await();Thread.sleep((long) (10000*Math.random()));
						System.out.println("线程 "+Thread.currentThread().getName()+" 即将到达地点3，当前已有"
						+(cyclicBarrier.getNumberWaiting()+1)+" 到达,"+(cyclicBarrier.getNumberWaiting()==2?"全部到齐，大家一起走！":"正在等候！"));
						cyclicBarrier.await();Thread.sleep((long) (10000*Math.random()));
						System.out.println("线程 "+Thread.currentThread().getName()+" 即将到达地点4，当前已有"
						+(cyclicBarrier.getNumberWaiting()+1)+" 到达,"+(cyclicBarrier.getNumberWaiting()==2?"全部到齐，大家一起走！":"正在等候！"));
						cyclicBarrier.await();
						
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			};
			
			service.execute(runnable);
		}
		service.shutdown();
//		System.out.println("全部到达，任务结束！");
	}

}
