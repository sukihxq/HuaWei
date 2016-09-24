/**
 * @project HuaWei
 * @package study.thread
 * @filename ThreaditionThread.java
 */
package study.thread;
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月24日 下午2:05:28
 */
public class TreaditionThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TreaditionThread().init(); 
	}
	public void init(){
		Thread thread = new Thread(){
			/* (non-Javadoc)
			 * @see java.lang.Thread#run()
			 */
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("1\t"+Thread.currentThread().getName());
//					System.out.println("2\t"+this.getName());
				}
			}
		};
		thread.start();
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("2\t"+Thread.currentThread().getName());
				}
			}
			
		});
		thread2.start();
		
		new Thread(
				new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						while(true){
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("runnable\t"+Thread.currentThread().getName());
						}
					}
				}){
			@Override
			public void run(){
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("3\t"+Thread.currentThread().getName());
				}
			}
		}.start();
		
		
	}
	
	public void fun1(){
		
	}
}
