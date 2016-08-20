import java.util.Scanner;

/**
 * @project LeetCode
 * @package 
 * @filename Main7.java
 */
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月15日 下午10:19:13
 */
public class Main07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main07().init();
		
	}

	public void init(){
		int x = 3;
		int y = 6;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			x = sc.nextInt();
			y = sc.nextInt();
			fun(x,y);
		}
	} 
	
	public void fun(int x,int y){
		int count = 0;
		for(int i=1;i<=x;i++){
			for(int j=1;j<=x;j++){
				for(int k=1;k<=x;k++){
					if(i+j+k==x&&(3*i+2*j+k)==y){
						//System.out.println("man="+i+"\twoman="+j+"\tchildren="+k);
						count++;
					}
				}
			}
		}
		//System.out.println("the count="+count);
		System.out.println(count);
	}
}
