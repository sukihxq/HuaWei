/**
 * @project HuaWei
 * @package study
 * @filename Reflect2.java
 */
package study;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;


/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月23日 下午1:21:11
 */
public class Reflect2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new Reflect2().init();
	}
	
	public void init() throws Exception{
		
//		InputStream ips = new FileInputStream("config.properties");
//		InputStream ips = Reflect2.class.getClassLoader().getResourceAsStream("config.properties");
		InputStream ips = Reflect2.class.getClassLoader().getResourceAsStream("config.properties");
		Properties props = new Properties();
		props.load(ips);
		ips.close();
		String className = props.getProperty("className");
		Collection collection = (Collection)Class.forName(className).newInstance();		
		
		//		Collection collection = new ArrayList();
//		Collection collection = new HashSet();
		ReflectPoint pt1 = new ReflectPoint(1, 1); 
		ReflectPoint pt2 = new ReflectPoint(2, 2); 
		ReflectPoint pt3 = new ReflectPoint(3, 3); 
		ReflectPoint pt4 = new ReflectPoint(3, 3); 
		collection.add(pt1);
		collection.add(pt2);
		collection.add(pt3);
		collection.add(pt4);
		collection.add(pt1);
		
//		pt4.y = 6;
//		collection.remove(pt4);
		
		System.out.println(collection.size());
		
	}

}
