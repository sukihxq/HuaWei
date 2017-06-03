import java.util.*; 
public class Main39{
    public static void main(String []args){
        new Main39().init();
    }
	public void init() {
		
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String strs = input.nextLine();
			fun(strs);
		}
		input.close();
	}
    public void fun(String strs){
//    	System.out.println(path);
//    	System.out.println(path.substring(path.lastIndexOf(".")+1));
    	Map<Character, Integer> map = new HashMap<>();
    	char [] chs = strs.toCharArray();
    	for(char ch:chs){
    		if(ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'){
    			if(map.containsKey(ch)){
    				int count = map.get(ch);
    				if(count==2){
    					System.out.println(ch);
    					return;
    				}
    				map.put(ch, count+1);
    			}else{
    				map.put(ch, 1);
    			}
    		}
    	}
	}
}