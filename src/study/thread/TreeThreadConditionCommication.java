package study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TreeThreadConditionCommication {
	public static void main(String[] args) {
		new TreeThreadConditionCommication().init();
	}
	public void init(){
		Business business = new Business();
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=5;i++)
					business.sub2(i);
			}
		});
		thread1.start();
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=5;i++)
					business.sub3(i);
			}
		});
		thread2.start();
		for(int i=1;i<=5;i++)
			business.main(i);
		
//		System.exit(0);
	}
	static	class Business{
		Lock lock = new ReentrantLock();
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		Condition condition3 = lock.newCondition();
		public static int subShould = 1;
		public void main(int count){
			lock.lock();
			try{
				while(subShould!=1){
					try {
//						this.wait();
						condition1.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int i=1;i<=10;i++){
					System.out.println("main thread sequence of "+i+", loop of "+count);
				}
				subShould = 2;
				condition2.signal();
			}finally{
				lock.unlock();
				
			}
//			this.notifyAll();
		}
		public void sub2(int count){
			lock.lock();
			try{
				
				while(subShould!=2){
					try {
//						this.wait();
						condition2.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int i=1;i<=20;i++){
					System.out.println("sub2 thread sequence of "+i+", loop of "+count);
				}
				subShould = 3;
				condition3.signal();
			}finally{
				
			}
//			this.notifyAll();
			lock.unlock();
		}
		public void sub3(int count){
			lock.lock();
			try{
				
				while(subShould!=3){
					try {
//						this.wait();
						condition3.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int i=1;i<=30;i++){
					System.out.println("sub3 thread sequence of "+i+", loop of "+count);
				}
				subShould = 1;
				condition1.signal();
			}finally{
				
			}
//			this.notifyAll();
			lock.unlock();
		}
	}

}



