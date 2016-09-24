/**
 * @project HuaWei
 * @package study.thread
 * @filename ExchangerTest.java
 */
package study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Exchanger;;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月27日 下午2:49:51
 */
public class ExchangerTest {
	public static void main(String []args){
		new ExchangerTest().init();
	}
	public void init(){
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger<String> exchanger = new Exchanger<String>();
		service.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String data1 = "xsh";
					System.out.println(Thread.currentThread().getName()+"正在把数据"+data1+"换出去");
					Thread.sleep((long)(Math.random()*10000));
					String data2 = (String) exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName()+"换回的数据"+data2);
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		service.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String data1 = "xshqhua";
					System.out.println(Thread.currentThread().getName()+"正在把数据"+data1+"换出去");
					Thread.sleep((long)(Math.random()*10000));
					String data2 = (String) exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName()+"换回的数据"+data2);
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		service.shutdown();
		
	}
}
