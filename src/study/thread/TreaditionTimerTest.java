/**
 * @project HuaWei
 * @package study.thread
 * @filename TreaditionTimerTest.java
 */
package study.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月24日 下午2:32:59
 */
public class TreaditionTimerTest {
	public static int count = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TreaditionTimerTest().init();
	}
	@SuppressWarnings("deprecation")
	public void init(){
		class MyTimer extends TimerTask{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				count = (count+1)%2;
				System.out.println("bombing...");
				new Timer().schedule(new MyTimer(), 2000*(count+1));
			}
		};
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				count = (count+1)%2;
				// TODO Auto-generated method stub
				System.out.println("bombing...");
				new Timer().schedule(new MyTimer(), 2000*(count+1));
			}
		},2000);
		
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void fun1(){
		
	}

}
