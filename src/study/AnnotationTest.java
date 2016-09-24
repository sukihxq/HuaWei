package study;
/**
 * @project HuaWei
 * @package study
 * @filename AnnotationTest.java
 */

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月23日 下午4:14:51
 */
@XSHAnnotation(color="red",value="abc")
//@XSHAnnotation(value="abc")

public class AnnotationTest {

	/**
	 * @param args
	 */
	@Deprecated
	@XSHAnnotation("abc")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AnnotationTest().init();
	}
	@SuppressWarnings("deprecation")
	@XSHAnnotation(color="red",value="bcd",arrayList=1)
	public void init(){
		System.runFinalizersOnExit(true);
		
		if(AnnotationTest.class.isAnnotationPresent(XSHAnnotation.class)){
			XSHAnnotation annotation = (XSHAnnotation)AnnotationTest.class.getAnnotation(XSHAnnotation.class);
			System.out.println(annotation);
			System.out.println(annotation.color());
			System.out.println(annotation.arrayList().length);
		}
		
		fun();
	}
	@Deprecated
	public void fun(){
		
	}
}
