package test;
import java.util.Scanner;

/**
 * @project LeetCode
 * @package 
 * @filename Main6.java
 */
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月15日 下午9:01:04
 */
public class Main06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main06().init();
	}
	public void init(){
		Scanner sc = new Scanner(System.in);
		String str = "";
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n<10){
				System.out.println(n+" is so small");
				continue;
			}
			str = ""+n;
			fun(str);
		}
	}
	public void fun(String str){
		if(str.length()>=2)
		System.out.println(str.substring(1,str.length()));
	}
}
