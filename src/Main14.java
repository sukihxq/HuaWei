import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main14().init();
	}
	public void init(){
		
//		System.out.println(shuixianhua(153));
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String []strs = scanner.nextLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			fun(a, b);
		}
	}
	public void fun(int start,int end){
		int count = 0;
//		StringBuffer sb = new StringBuffer(); 
		for(int i = start;i<=end;i++){
			if(shuixianhua(i)){
				//System.out.println(i);
				//sb.append("，"+i);
				count++;
			}
//			System.out.println(i);
		}
//		System.out.print(start+"~"+end+"的水仙花数有：");
//		//String re
//		System.out.println(sb.toString().substring(1));
		System.out.println(count);
		
	}
	
	public boolean shuixianhua(int num){
		List<Integer> nums = new ArrayList<>();
		int num1 = num;
		while(num1!=0){
			nums.add(num1%10);
			num1 = num1/10;
		}
		
		int count = 0;
		for(int a:nums)
			count+=Math.pow(a, nums.size());
		//System.out.println(count);
		if(count==num)
			return true;
		return false;
	}

}
