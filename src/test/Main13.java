package test;
import java.util.Scanner;

public class Main13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main13().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String [] strs = scanner.nextLine().split(" ");
			System.out.println(fun(strs));
		}
		//System.out.println();
	}
	public String fun(String [] strs){
		if(strs.length!=2){
			return null;
		}
		
		long start = toLong(strs[0]);
		long end = toLong(strs[1]);
		//System.out.println("start="+start);
		//System.out.println("end="+end);
		
		//System.out.println("end+start="+(end+start));
		long sum = end+start;
		
		String res = toTime(sum);
		
		return res;
	}
	public long toLong(String time){
		long t1 = 0;
		String []t2 = time.split(":");
		int factor=1;
		for(int i=t2.length-1;i>=0;i--){
			int tep = Integer.parseInt(t2[i])*factor;
			t1+=tep;
			factor*=60;
		}
		return t1;
	}
	public String toTime(long time){
		StringBuffer res = new StringBuffer();
		int [] tis = new int[3];
		tis[0] = (int) (time/3600%24);
		tis[1] = (int) (time/60%60);
		tis[2] = (int) (time%60);
		
		for(int i=0;i<3;i++){
			if(tis[i]<10){
				res.append(":0"+tis[i]);
			}
			else {
				res.append(":"+tis[i]);
			}
		}
		return res.toString().substring(1);
	}
}
