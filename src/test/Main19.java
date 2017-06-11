package test;

import java.util.Scanner;
public class Main19 {
	public static void main(String[] args) {
		new Main19().init();
	}
	public void init(){
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			int money = scanner.nextInt();
			fun(money);
		}
		scanner.close();	
	}
	public void fun(int money){
		int count = 0;
	}

}
