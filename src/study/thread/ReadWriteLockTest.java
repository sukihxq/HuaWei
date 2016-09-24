/**
 * @project HuaWei
 * @package study.thread
 * @filename ReadWriteLockTest.java
 */
package study.thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月26日 下午6:49:56
 */
public class ReadWriteLockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReadWriteLockTest().init();
	}
	public void init(){
		readWriteLockTest();
	}
	public void readWriteLockTest (){
		final Queue3 q3 = new Queue3();
		for(int i=0;i<3;i++){
			new Thread(){
				public void run() {
					while(true){
						q3.getData();
					}
				};
			}.start();
			new Thread(){
				public void run() {
					while(true){
						q3.setData(new Random().nextInt(10000));
					}
				};
			}.start();
		}
	}
	
	class Queue3{
		private Object data = 0;
		private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
		public void getData() {
			try{
				rwl.readLock().lock();
				System.out.println(Thread.currentThread().getName()+" be ready to read data!");
				Thread.sleep((long) (Math.random()*1000));
				System.out.println(Thread.currentThread().getName()+" have been read data !");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				rwl.readLock().unlock();
			}
		}
		public void setData(int data) {
			try{
				rwl.writeLock().lock();
				System.out.println(Thread.currentThread().getName()+" be ready to write data!");
				Thread.sleep((long) (Math.random()*1000));
				this.data = new Random().nextInt(50000);
				System.out.println(Thread.currentThread().getName()+" have ben write data :"+data);
			}catch(Exception e){
				
			}finally {
				rwl.writeLock().unlock();
				
			}
		}
		
	}

}
