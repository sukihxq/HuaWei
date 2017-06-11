package test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main21 {
	int [] prime = new int[1001];
	public static void main(String[] args) {
		new Main21().init();
	}
	public void init(){
		initPrime();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			fun(n);
		}
		scanner.close();
	}
	
	public void fun(int n){
		List<Integer> all = new ArrayList<>();
		for(int i=0;i<=n;i++){
			if(prime[i]==1&&prime[n-i]==1){
				if(!all.contains(i)&&!all.contains(n-i)){
					all.add(i);
				}
			}
		}
		System.out.println(all.size());
	}
	public void initPrime(){
		prime[0] = 0;
		for(int i=1;i<=1000;i++){
			if(isPrime(i)){
				prime[i] = 1;
			}else
				prime[i] = 0;
		}
	}
	public boolean isPrime(int n){
		if(n<=2)
			return true;
		for (int i = 2; i<=n/2; i++){
			if(n%i == 0){
				return false;
			}
		}
		return true;
	}
}
