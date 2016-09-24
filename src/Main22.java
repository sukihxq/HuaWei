import java.util.Scanner;

public class Main22 {
	public static void main(String []args){
		new Main22().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			fun(n);
		}
		scanner.close();
	}
	public void fun(int n){
		int count = 6;
		int start = -90;
		int end = 90;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<count;i++){
			int mid = (start+end)/2;
			if(n>=mid){
				sb.append("1");
				start = mid;
			}else{
				sb.append("0");
				end = mid;
			}
		}
		System.out.println(sb);
	}
}
