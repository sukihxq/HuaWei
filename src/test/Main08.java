package test;
import java.util.Scanner;

public class Main08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main08().init();
	}
	public void init(){
//		String str = "w23r   at    1rt Af    w13r";
		//String str = "w23r   at    1rt Af    w13r";
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();			
			fun(str);
		}
	}
	public void fun(String str){
		String s[] = str.split("[ ]+", 0);
//		for(String s1:s)
//			System.out.print(s1+" ");
//		sort(s,2);
//		System.out.println();
//		for(String s1:s)
//			System.out.print(s1+" ");
//		sort(s,2);
//		System.out.println();
		sort(s,2);
		for(String s1:s)
			System.out.print(s1+" ");
	}
	public void sort(String [] strs,int tag){
		//tag=1 sort 字符
		if(tag == 1 ){
			for(int i=0;i<strs.length;i++){
				
				for(int j=1;j<strs.length-i;j++){
					if(strs[j-1].compareTo(strs[j])>0){
						String tep = strs[j-1];
						strs[j-1] = strs[j];
						strs[j] = tep;
					}
				}
			}
		}else if (tag==2) {
			//tag=2 sort the long of str
			for(int i=0;i<strs.length;i++){
				
				for(int j=1;j<strs.length-i;j++){
					if(strs[j-1].length()<strs[j].length()){
						String tep = strs[j-1];
						strs[j-1] = strs[j];
						strs[j] = tep;
					}else if(strs[j-1].length()==strs[j].length()){
						if(strs[j-1].compareTo(strs[j])<0){
							String tep = strs[j-1];
							strs[j-1] = strs[j];
							strs[j] = tep;
						}
					}
					
				}
			}
		}
	}
}
