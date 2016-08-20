import java.util.Scanner;


/**
 * @project LeetCode
 * @package 
 * @filename Main4.java
 */
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月15日 下午7:58:33
 */
public class Main04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n=1;
		while(scanner.hasNextInt()){
			n=scanner.nextInt();
			new Main04().fun(n);
		}
	}
	public void fun(int num){
		if(num<1||num>121){
			System.out.println("the number must 1<= x <=121");
			return ;
		}
		for(int one =-1;one<=1;one++){
			for(int thre=-1;thre<=1;thre++){
				for(int nine=-1;nine<=1;nine++){
					for(int i=-1;i<=1;i++){
						for(int j=-1;j<=1;j++){
							if(1*one+thre*3+nine*9+i*27+j*81==num){
								//System.out.println(""+one+" "+thre+" "+nine+" "+i+""+j);
								String res = "";
								if(j==1)
									//System.out.print(81);
									res+=81;
								if(j==-1)
									res+="-"+81;
								if(i==1)
									//System.out.println(27);
									res+="+"+27;
								if(i==-1)
									//System.out.println(-27);
									res+="-"+27;
								if(nine==1)
									//System.out.println("+"+9);
									res+="+"+9;
								if(nine==-1)
									//System.out.print("-"+9);
									res+="-"+9;
								if(thre==1)
									//System.out.println("+"+3);
									res+="+"+3;
								if(thre==-1)
									//System.out.println("-"+3);
									res+="-"+3;
								
								if(one==1)
									//System.out.println("+"+1);
									res+="+"+1;
								if(one==-1)
									//System.out.println("-"+1);
									res+="-"+1;
								//System.out.println(res);
								char ch = res.charAt(0);
								if(ch=='+'||ch=='-')
									res = res.substring(1,res.length());
								System.out.println(res);
							}
						}
					}
				}
			}
		}
	}

}
