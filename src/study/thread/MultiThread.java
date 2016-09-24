/**
 * @project HuaWei
 * @package thread
 * @filename MultiThread.java
 */
package study.thread;
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月23日 下午9:49:20
 */
public class MultiThread {
	
	public static void main(String [] args){
		
		new Thread(new Thread1()).start();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		new Thread(new Thread2()).start();
		
		
	} 
	
	public static class Thread1 implements Runnable{

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (MultiThread.class){
				System.out.println("Enter thread1...");
				System.out.println("thread1 is waiting...");
				try{
					MultiThread.class.wait();
				}catch (Exception e){
					
				}finally {
					System.out.println("thread1 is going on...");
					System.out.println("thread1 is going over!");
				}
			}
		}
		
	}
	
	private static class Thread2 implements Runnable{

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (MultiThread.class) {
				System.out.println("Enter Thread2 ...");
				System.out.println("Thread2 notify other thread can release wait status...");
				System.out.println("thread2 is slping ten milliscond...");
				
				try {
					Thread.sleep(3000);
				} catch(Exception e) {
					// : handle finally clause
				}finally {
					System.out.println("thread2 is going on...");
					System.out.println("thread2 is being over");
				}
				
			}
		}
		
		
	}
	
}
