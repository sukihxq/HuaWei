import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main57 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main57().init();
	}
	public void init(){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			String[] str = s.nextLine().split(" ");
			fun(str[0],str[1]);
		}
	}
	public void fun(String str,String value){
		Map<Character,Integer> map = new HashMap<>();
		char [] chs = str.toCharArray();
		char [] chs1 = value.toCharArray();
		for(char cs:chs1){
			if(!map.containsKey(cs))
				map.put(cs, 0);
		}
		
		for(char c:chs){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}
		}
		
		for(char cs:chs1){
			System.out.print(map.get(cs)+" ");
		}
	}

}
