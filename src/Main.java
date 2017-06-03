import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().init();
	}
	public void init(){
		Scanner s = new Scanner(System.in);
		List<Integer> nums = new ArrayList<>();
		while(s.hasNext()){
			String[] n = s.nextLine().split(",");
			for(String n1:n){
				nums.add(Integer.parseInt(n1));
			}
			fun(nums);
			nums.clear();
		}
		s.close();
	}
	public void  fun(List<Integer> nums){
		Collections.sort(nums);
		List<Integer> res = new ArrayList<>();
		int start = nums.get(0);
		res.add(start);
		for(int i=1;i<nums.size();i++){
			if(start==nums.get(i)||start+1==nums.get(i)){
				start = nums.get(i);
			}else{
				if(!res.contains(start)){
					res.add(start);
				}
				start = nums.get(i);
			}
		}
		if(!res.contains(start)){
			res.add(start);
		}
		for(int value:res){
			System.out.print(value+" ");
		}
	}
}
