package test;
import java.util.Scanner;
public class Main25 {
	public static void main(String[] args) {
		new Main25().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			fun(str.substring(1));
		}
		scanner.close();
	}
	public void fun(String str){
		StringBuffer sb = new StringBuffer("#");
		for(int i=0;i<6;i+=2){
			String t = str.substring(i,i+2);
			int tep = Integer.parseInt(t, 16);
			String tep1 = Integer.toHexString(255-tep).toUpperCase();
			if(tep1.length()!=2)
				sb.append("0"+tep1);
			else
				sb.append(tep1);
		}
		System.out.println(sb);
	}
}
