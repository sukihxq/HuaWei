import java.util.Scanner;
import java.util.Stack;

/**
 * @project LeetCode
 * @package 
 * @filename Main20.java
 */
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月6日 下午6:46:05
 */
public class Main02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String a = scanner.nextLine();
			String b = scanner.nextLine();
			int count = new Main02().init(a,b);
			System.out.println(count);
		}
		
	}
	
	public int  init(String a,String b){
		int count = 0;
		for(int i=0;i<=a.length();i++){
			StringBuffer ab = new StringBuffer(a);
			ab.insert(i, b);
			//System.out.println(ab.toString());
			if(huiwen(ab.toString())){
				count++;
				//System.out.println(ab.toString());
			}
			//System.out.println();
		}
		return count;
	}
	public boolean huiwen(String str){
		if(str==null)
			return true;
		char [] ss = str.toCharArray();
		int len = ss.length;
		int count = len/2;
		int i;
		int j;
		if(len%2==0){
			i = len/2-1;
			j = len/2;
		}else {
			j = len/2;
			i = j;
		}
		while(i>=0&&j<len){
			if(ss[i]==ss[j]){
				i--;
				j++;
				continue;
			}
			else
				return false;
		}
		return true;
		
	/*	if(str.length()==1)
			return true;*/
		/*int size = str.length();
		Stack<Character> s = new Stack<>();
		for(int i=0;i<str.length()/2;i++){
		}*/
	}
}
