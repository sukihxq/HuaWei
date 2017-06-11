package test;
import java.util.*;
public class Main32 {
	public static void main(String[] args) {
		new Main32().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			List<Integer> data = new ArrayList<>();
			for(int i=0;i<n;i++){
				data.add(scanner.nextInt());
			}
			Collections.sort(data);
			fun(data);
			data.clear();
		}
		scanner.close();
	}
	public void fun(List<Integer> data){
		boolean [] tag = new boolean[data.size()];
		for(int i=0;i<tag.length;i++)
			tag[i] = false;
		int count = 0;
		int size = data.size();
		while(true){
			int last = data.get(0);
			int start = 1;
			int tep = 0; 
			while(tep<2&&start<data.size()){
				if(last-data.get(start)>=10){
					last = data.get(start);
					tep++;
					data.remove(start);
				}
				start++;
			}
			if(start>=data.size())
				break;
		}
		
		count = data.size()%3;
		if(count!=0){
			count = 3-count;
		}
		System.out.println(count);
	}
}
