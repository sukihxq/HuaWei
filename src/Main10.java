import java.util.ArrayList;
import java.util.Scanner;
public class Main10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String []str = sc.nextLine().split(" ");
			//new Main2().fun(str);
			
			int []data = new int[str.length];
			for(int i=0;i<data.length;i++){
				data[i] = Integer.parseInt(str[i]);
				
			}
			ArrayList<Integer> arr = new ArrayList<>();
			for(int d:data)
				arr.add(d);
			new Main10().fun(arr);
				
		}
		
	}
	public void fun(ArrayList<Integer> data){
		if(data.size()<3){
			print(data);
		}
		boolean flag = false;
		while(!flag){
			int i=0,j=0;
			flag=true;
			while(i<=j&&j<data.size()){
				if(data.get(i)==data.get(j)){
					j++;
				}else{
					if(j-i>2){
						break;
					}
					i=j;
					j++;
				}
			}
			
			int num = j-i;
			if(num>2){
				remove(data, i, num);
				flag = false;
				continue;
			}
			
			if(flag==true){
				print(data);
			}
			
		}
		
	}
	public void print(ArrayList<Integer> data){
		if(data==null||data.size()<1){
			
			System.out.println("none");
			return ;
		}
		for(int t:data)
			System.out.print(t+" ");
		return ;
	}
	
	public void equal(ArrayList<Integer> data){
		int i=0,j=0;
		while(i<=j&&j<data.size()){
			if(data.get(i)==data.get(j)){
				j++;
			}else{
				int num = j-i;
				if(num>2){
					remove(data, i, num);
				}
				i=j;
			}
		}
	}
	
	public void remove(ArrayList<Integer> data,int start,int num){
		int i=0;
		while(i<num){
			data.remove(start);
			i++;
		}
	}
}
 