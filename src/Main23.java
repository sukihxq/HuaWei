import java.util.Scanner;

public class Main23 {
	public static void main(String [] args){
		new Main23().init();
	} 
	public void init(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int tep = fun(n);
			System.out.println(tep);
		}
		scanner.close();
	}
	
	public  int fun(int L){
		int k=0;
		int x=1;
		int r;
		while(x*x<=L){
			++x;
		}
		r=x;
		for (x = 1; x < r; x++) {
			double y=L-x*x;					
			y=Math.sqrt(y);
			int t=(int)y;
			if(t==y)
				++k;
		}		
		return k*4+4;
	}

}
