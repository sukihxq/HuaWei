package test;
import java.util.Scanner;

/**
 * @project LeetCode
 * @package 
 * @filename Main5.java
 */
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月15日 下午8:32:37
 */
public class Main05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main05().init();
	}
	
	public void init(){
		//int []data = {9,10};
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			
			String[]strs = scanner.nextLine().split(" ");
			int [] data = new int[strs.length];
			for(int i=0;i<strs.length;i++){
				data[i] = Integer.parseInt(strs[i]);
			}
			fun(data);
		}
	}
	public void fun(int []data){
		if(data.length==1){
			System.out.println(data[0]+","+data[0]);
			return ;
		}
		int max = data[0];
		int second = Integer.MIN_VALUE;
		for(int i = 1;i<data.length;i++){
			int tep = data[i];
			if(tep>max){
				second = max;
				max = tep;
			}else if(tep>second) {
				second=tep;
			}
			
		}
		System.out.println(max+","+second);
	}

}
