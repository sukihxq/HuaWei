/**
 * @project HuaWei
 * @package study
 * @filename ClassLoderTest.java
 */
package study;

import java.util.logging.Logger;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月30日 下午4:00:25
 */
public class ClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClassLoaderTest().init();
	}
	public void init(){
		System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getName());
		System.out.println(System.class.getClassLoader());
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		while(loader!=null){
			System.out.println(loader.getClass().getName());
			loader = loader.getParent();
		}
	}

}
