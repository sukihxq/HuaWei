import java.util.Scanner;

/**
 * @project LeetCode
 * @package 
 * @filename Main.java
 */
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月6日 下午6:46:05
 */
public class Main03 {
	public int count1 = 0;
	public static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			long a = scanner.nextLong();
			new Main03().init(a,1);
			System.out.println(count);
		}
	}
	
	public void init(long k,int level){
		if(checked(k)){
			this.count1++;
			return ;
		}
		if(level<10){
			init(four(k),level+1);
			init(seven(k),level+1);
		}
		//System.out.println("--");
	}
	
	public long four(long x){
		return 4*x+3;
	}
	public long seven(long x){
		return 8*x+7;
	}
	public boolean checked(long k){
		if(k%1000000007==0)
			return true;
		return false;
	} 
}
