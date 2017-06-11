package test;
import java.util.*;
public class Main33 {
	public static void main(String[] args) {
		new Main33().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			List<Integer> data = new ArrayList<>();
			for(int i=0;i<n;i++){
				data.add(scanner.nextInt());
			}
			fun(data,m);
			data.clear();
		}
		scanner.close();
	}
	public void fun(List<Integer> data,int m){
		int count = 0;
		for(int i=0;i<data.size()-1;i++){
			for(int j=i+1;j<data.size();j++){
				int tepi = data.get(i);
				int tepj = data.get(j);
				if((tepi^tepj)>m){
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
