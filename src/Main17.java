import java.util.Date;
import java.util.Vector;

import static java.lang.Math.*;
/**
 * @project HuaWei
 * @package 
 * @filename Main16.java
 */
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月22日 下午4:20:32
 */
public class Main17 extends Date{

	private static final String WeekDay = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main17().init();
	}
	public void init(){
		int x = 1;
		x++;
		//max(a, b)
		System.out.println(super.getClass().getName());
		System.out.println(getClass().getSuperclass().getName());
		System.out.println();
		
		Integer i1 = 128;
		Integer i2 = 128;
		//-128~127之间放在缓存之中，他们相等，其他的范围不相同  享元模式
		
		System.out.println(i1==i2);
		Long l1 = -128l;
		Long l2 = -128l;
		System.out.println(l1==l2);
		
		System.out.println(fun2());
		
		//WeekDay weekday = 7;
		//Vector<E>
	}
	public void fun1(int x,int ... args){
		int sum = x;
		for(int i=0;i<args.length;i++){
			sum+=args[i];
		}
	}
	@SuppressWarnings("finally")
	public int fun2(){
		int x = 1;
		try {
			x=2;
			return x;
		}catch(Exception e){
			
		}finally {
			
			x=3;
			System.err.println("finally");
			return x;
		}
		
	}
}
