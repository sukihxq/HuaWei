/**
 * @project HuaWei
 * @package study.thread
 * @filename CallableAndFuture.java
 */
package study.thread;

import java.net.Inet4Address;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月26日 下午5:02:07
 */
public class CallableAndFuture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CallableAndFuture().init();
	}
	public void init(){
		callableAndFuture();
	}
	public void callableAndFuture(){
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<String> future = 
			threadPool.submit(
				new Callable<String>() {
					public String call() throws Exception{
						Thread.sleep(5000);
						return "Hello";
					}
				}
			);
		System.out.println("结果是：");
		try {
			System.out.println("结果是："+future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			threadPool.shutdown();
		}
		
		
		ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = new ExecutorCompletionService<>(threadPool2);
		for(int i=1;i<=10;i++){
			final int seq = i;
			completionService.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					Thread.sleep(new Random().nextInt(5000));
					
					
					return seq;
				}
				
			});
		}
		for(int i=0;i<10;i++){
			try {
				System.out.println("test"+i);
				System.out.println("the task is "+completionService.take().get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		threadPool2.shutdown();
		
	}

}
