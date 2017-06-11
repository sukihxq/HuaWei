package test;
import java.util.Scanner;
public class Main28 {
	public static void main(String[] args) {
		new Main28().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			if(n>=1&&n<=1000)
				fun(n);
		}
		scanner.close();
	}
	
	public void fun(int n){
		int count = 0;
		while(n!=0){
			count+=n/5;
			n/=5;
		}
		System.out.println(count);
	}
}
