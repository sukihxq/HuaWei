import java.util.*; 
public class Main{
    public static void main(String []args){
        new Main().init();
    }
	public void init() {
		/*Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int m = scanner.nextInt();
			fun(m);
		}
		scanner.close();*/
		int [] arr = {1,2,49,34,73,44,3,4,5,6,7};
		fun(arr);
	}
    public int fun(int[] data){
    	int m=0;
    	int max = data[0];
    	int sec = data[0];
    	
    	for(int i=0;i<data.length;i++){
    		if(data[i]>sec){
    			//1
    			sec = data[i];
    		}
    		if(sec>max){
    			max += sec;
    			//2
    			sec = max-sec;
    			max-=sec;
    		}
    	}
    	//3
    	System.out.println(max);
    	System.out.println(sec);
    	return max;
    }
}