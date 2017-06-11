package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main36 {
	HashMap<Integer, Integer> map = new HashMap<>();
	int total = 2048;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main15().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		List<String> lines = new ArrayList<>();
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			if(str.equals("end")){
				fun(lines);
				lines.clear();
			}
			lines.add(str);
		}
	}
	public void fun(List<String> lines){
		for(String str:lines){
			int index1 = str.indexOf(":")+1;
			if(str.contains("memsize")){
				total = Integer.parseInt(str.substring(index1));
			}else if(str.contains("alloc")){
				String[] nums = str.substring(index1).split(",");
				int id = Integer.parseInt(nums[0]);
				if(map.containsKey(id)){
					continue;
				}
				int num = Integer.parseInt(nums[1]);
				if(total<num)
					continue;
				
				map.put(id, num);
				total-=num;
			}else if(str.contains("free")){
				String[] nums = str.substring(index1).split(",");
				int id = Integer.parseInt(nums[0]);
				if(!map.containsKey(id)){
					continue;
				}
				int num = map.get(id);
				total+=num;
				map.remove(id);
			}
		}
		System.out.println(total);
	}
}
//=======