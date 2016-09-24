import java.util.Scanner;
public class Main26 {
	public static void main(String[] args) {
		new Main26().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			double count = fun(n,m);
			System.out.println(String.format("%.2f", count));
		}
		scanner.close();
	}
	
	public double fun(int n,int m){
		if(m<1){
			return 0;
		}
		double tep = n;
		double count = n;
		for(int i=1;i<m;i++){
			tep = Math.sqrt(tep);
			count+=tep;
		}
		return count;
	}
	
}
