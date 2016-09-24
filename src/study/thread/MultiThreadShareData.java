/**
 * @project HuaWei
 * @package study.thread
 * @filename MultiThreadShareData.java
 */
package study.thread;
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月24日 下午10:23:30
 */
public class MultiThreadShareData {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiThreadShareData().init();
	}
	public void init(){
		ShareData data1 = new ShareData();
		new Thread(new ThreadRunnable1(data1)).start();
		new Thread(new ThreadRunnable2(data1)).start();
	}
	
	class ThreadRunnable1 implements Runnable {
		private ShareData shareData;
		public ThreadRunnable1(ShareData shareData){
			this.shareData = shareData;
		}
		public void run() {
			shareData.increment();
		}
	}
	class ThreadRunnable2 implements Runnable {
		private ShareData shareData;
		public ThreadRunnable2(ShareData shareData){
			this.shareData = shareData;
		}
		public void run() {
			shareData.decrement();
		}
	}
	
	
	class ShareData{
		private int j = 0;
		public synchronized void increment(){
			j++;
			System.out.println(Thread.currentThread().getName()+" j++ "+j);
		}
		public synchronized void decrement(){
			j--;
			System.out.println(Thread.currentThread().getName()+" j-- "+j);
		}
		
		
		
	}

}

