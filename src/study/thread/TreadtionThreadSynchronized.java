/**
 * @project HuaWei
 * @package study.thread
 * @filename TreadtionThreadSynchronized.java
 */
package study.thread;
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月24日 下午3:14:48
 */
public class TreadtionThreadSynchronized {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TreadtionThreadSynchronized().init();
	}
	public void init(){
		fun1();
	}
	public void fun1(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
					outer("xushihua");
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
					outer("liudehua");
			}
		}).start();
	}
	
	
	
	public synchronized void outer(String name){
		for(int i=0;i<name.length();i++){
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}

}
