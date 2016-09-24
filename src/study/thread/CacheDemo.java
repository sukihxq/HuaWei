/**
 * @project HuaWei
 * @package study.thread
 * @filename CacheDemo.java
 */
package study.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月26日 下午8:20:48
 */
public class CacheDemo {
	public Map<String, Object> cache = new HashMap<>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CacheDemo().init();
	}

	public void init() {
		String key = "";
		System.out.println(cacheDemo(key));
	}
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	public Object cacheDemo(String key){
		rwl.readLock().lock();
		Object value = null;
		try{
			value = cache.get(key);
			if (value==null) {
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				if(value==null)
					value = "aaa";
				rwl.writeLock().unlock();
				rwl.readLock().lock();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			rwl.readLock().unlock();
		}
		
		
		
		
		
		
		return value;
		
	}
}
