package test;
import java.util.Scanner;
public class Main27 {
	public static void main(String[] args) {
		new Main27().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			if(n>=100&&n<=m&&m<=999)
				fun(n,m);
		}
		scanner.close();
	}
	
	public void fun(int n,int m){
		boolean flag = false;
		StringBuffer sb = new StringBuffer();
		for(int i=n;i<=m;i++){
			if(check2(i)){
				sb.append(i+" ");
				flag = true;
			}
		}
		if(!flag)
			System.out.println("no");
		else
			System.out.println(sb.toString().trim());
	}
	public boolean check(int n){
		int count = 0;
		int tep = n;
		while (tep!=0) {
			int m = tep%10;
			tep = tep/10;
			count+=Math.pow(m, 3);
		}
		if(count==n)
			return true;
		else
			return false;
	}
	public boolean check2(int n){
		int gw,sw,bw;
		gw = n%10;
		sw = n/10%10;
		bw = n/100;
		if((gw*gw*gw+bw*bw*bw+sw*sw*sw)==n)
			return true;
		else
			return false;
	}
}
