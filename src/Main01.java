import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @project LeetCode
 * @package 
 * @filename Main.java
 */
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月6日 下午6:46:05
 */
public class Main01 {
	List<List<Integer>> res = new ArrayList<>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int  a = scanner.nextInt();
			for(int i=0;i<a;i++){
				data.add(scanner.nextInt());
			}
			new Main().init(data);
			data.clear();
		}*/
		List<Integer> data = new ArrayList<>();
		data.add(1);
		data.add(3);
		data.add(2);
		data.add(1);
		new Main01().init(data);
	}
	
	public void  init(List<Integer> data){
		int count = 0;
		res.clear();
		for(int i=1;i<=data.size();i++){
			List<Integer> data2 = new ArrayList<>(data);
			combination(data2,i);
		}
		for(int i=0;i<res.size();i++){
			List<Integer> data2 = new ArrayList<>(res.get(i));
			if(xingyun(data2))
				count++;
		}
		System.out.println(count);
	}
			
	public boolean xingyun(List<Integer> data){
		if(data==null)
			return false;
		if(data.size()==1)
			return false;
		long num1 = 1;
		long num2 = 0;
		for(int a:data){
			num1*=a;
			num2+=a;
		}
		if(num2>num1)
			return true;
		return false;
	}
	
	public void combination(List<Integer> data,int k){
		int [] index = new int [k];
		combination(data,index,k,k,data.size());
	}
	
	public void combination(List<Integer> data,int [] index,int k,int m,int size){
		for(int i=size-1;i>=k-1;--i){
			index[k-1] = i;
			if(k>1)
				combination(data, index,k-1,m,i);
			else{
				List<Integer> arr = new ArrayList<>();
				for(int j=0;j<m;j++){
					System.out.print(data.get(index[j]));
					arr.add(data.get(index[j]));
				}
				res.add(arr);
				System.out.println();
			}
		}
	}
}
