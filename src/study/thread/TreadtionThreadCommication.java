/**
 * @project HuaWei
 * @package study.thread
 * @filename TreadtionThreadCommication.java
 */
package study.thread;
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月24日 下午7:31:24
 */
public class TreadtionThreadCommication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TreadtionThreadCommication().init();
	}
	public void init(){
		Business business = new Business();
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<=100;i++)
					business.sub(i);
			}
		});
		thread1.start();
		for(int i=1;i<=100;i++)
			business.main(i);
		
		System.exit(0);
	}
	
	static class Business{
		public static boolean subShould = true;
		public synchronized void main(int count){
			while(subShould){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int i=1;i<=50;i++){
				System.out.println("main thread sequence of "+i+", loop of "+count);
			}
			subShould = true;
			this.notifyAll();
		}
		public synchronized void sub(int count){
			while(!subShould){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int i=1;i<=10;i++){
				System.out.println("sub thread sequence of "+i+", loop of "+count);
			}
			subShould = false;
			this.notifyAll();
		}
	}

}


