/**
 * @project HuaWei
 * @package study
 * @filename XSHAnnotation.java
 */
package study;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月23日 下午4:31:32
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface XSHAnnotation {
	String color() default "blue";
	String value();
	int [] arrayList() default {1,2,3,4};
	
}
