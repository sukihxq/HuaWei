import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @project LeetCode
 * @package 
 * @filename Main9.java
 */
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月16日 下午3:15:36
 */
public class Main09 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main09().init();
	}
	public void init(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			String [] strs = str.split(",");
			int [] data = new int [strs.length];
			for(int i=0;i<data.length;i++){
				data[i] = Integer.parseInt(strs[i]);
				//System.out.print(data[i]+" ");
			}
			fun(data);
		}
	}
	public void fun(int []data){
		if(data==null||data.length<2){
			System.err.println("输入的数据有问题！");
		}
		List<Integer> line = new ArrayList<>();
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data.length;j++){
				if(j!=i){
					if(data[i]%data[j]==0){
						if(!line.contains(data[i]))
							line.add(data[i]);
						continue;
						//System.out.println(data[i]);
					}
				}
			}
		}
		//System.out.println();
		for(int tep:line)
			System.out.print(tep+" ");
	}
}
