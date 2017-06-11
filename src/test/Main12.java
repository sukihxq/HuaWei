package test;
import java.util.Scanner;

public class Main12 {
	public static void main(String []arg){
		new Main12().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			int num = Integer.parseInt(str);
			int n = fun(num);
			System.out.println(n);
		}
		System.out.println();
	}
	
	public int fun(int num){
		int size = 1000000;
		int start = num;
		while(true){
			start++;
			if(huiwen(""+start)){
				break;
			}
			if(start>=size){
				start=0;
			}
		}
		int n1 = 0;
		if(start>num){
			n1=start-num;
		}else{
			n1=size-num+start-1;
		}
		return n1;
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
	}
}
