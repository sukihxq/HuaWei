package test;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main24 {
	public Map<Integer, Long> key = new HashMap<Integer, Long>();
	public static void main(String[] args) {
		new Main24().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			System.out.println(fun(n));;
		}
		scanner.close();
	}
	public long fun(int n){
		if(n%2==1){
			int count =(n/2+1)*(n/2+1);
			return count+dp(n-1);
		}else{
			int count = (n/2)*(n/2);
			return count+fun(n/2);
		}
	}
	public long dp(int n){
//		if()
		return dp(n/2);
	}  
}
