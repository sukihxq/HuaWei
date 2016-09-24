/**
 * @project HuaWei
 * @package study
 * @filename IntroSpectorTest.java
 */
package study;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;


/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月23日 下午2:37:52
 */
public class IntroSpectorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		new IntroSpectorTest().init();
	}
	public void init() throws Exception{
		fun();
	}
	public void fun() throws Exception{
		ReflectPoint pt1 = new ReflectPoint(3, 5);
		String propertyName = "x";
		Object retVal = getProperty(pt1,propertyName);
		System.out.println(retVal);
		
		Object value = 7;
		setProperties(pt1, propertyName, value);
		System.out.println(pt1.getX());
		
		System.out.println(BeanUtils.getProperty(pt1, "x").getClass().getName());
		BeanUtils.setProperty(pt1, "y", "11");
		System.out.println(BeanUtils.getProperty(pt1, "y"));
		
		
//		Map map = {name:"xx",age:dd};
		PropertyUtils.setProperty(pt1, "x", 9);
		
	}
	public void setProperties(Object pt1, String propertyName, Object value)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, pt1.getClass());
		Method methodSet = pd.getWriteMethod();
		methodSet.invoke(pt1, value);
	}

	public Object getProperty(Object obj,String propertyName) throws Exception{
		/*PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
		Method methodGet = pd.getReadMethod();
		Object retVal = methodGet.invoke(obj);*/
		
		
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor [] pd = beanInfo.getPropertyDescriptors();
		Object retVal = null;
		for(PropertyDescriptor pdTep:pd){
			if(pdTep.getName().equals(propertyName)){
				Method methodGetX = pdTep.getReadMethod();
				retVal = methodGetX.invoke(obj); 
			}
		}
		
		
		
		
		return retVal;
	}
}


















