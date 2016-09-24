package study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommication {
	public static void main(String[] args) {
		new ConditionCommication().init();
	}
	public void init(){
		Business business = new Business();
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=100;i++)
					business.sub(i);
			}
		});
		thread1.start();
		for(int i=1;i<=100;i++)
			business.main(i);
		
//		System.exit(0);
	}
	static	class Business{
		Lock lock = new ReentrantLock();
		Condition condition  = lock.newCondition();
		public static boolean subShould = true;
		public void main(int count){
			lock.lock();
			try{
				while(subShould){
					try {
//						this.wait();
						condition.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int i=1;i<=50;i++){
					System.out.println("main thread sequence of "+i+", loop of "+count);
				}
				subShould = true;
				condition.signal();
			}finally{
				lock.unlock();
				
			}
//			this.notifyAll();
		}
		public void sub(int count){
			lock.lock();
			try{
				
				while(!subShould){
					try {
//						this.wait();
						condition.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int i=1;i<=10;i++){
					System.out.println("sub thread sequence of "+i+", loop of "+count);
				}
				subShould = false;
				condition.signal();
			}finally{
				
			}
//			this.notifyAll();
			lock.unlock();
		}
	}

}



