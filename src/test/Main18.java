package test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main18 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main18().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		List<Point> list = new ArrayList<>();
		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			for(int i=0;i<m;i++){
				Point p = new Point(scanner.nextInt(),scanner.nextInt());
				list.add(p);
			}
			System.out.println(fun(n, list));
			new ArrayList<>();
		}
		/*for(String s:res){
			System.out.println(s);
		}*/
	}
	public String fun(int n,List<Point> list){
		int [] data = new int[n+2];
		for(int i=0;i<data.length;i++){
			data[i] = -1;
		}
		for(Point p :list){
			data[p.d] = p.h;
		}
		
		int tag = -1;
		int max = 0;
		
		int start = 0;
		int end = 0;
		for(int i=0;i<data.length;i++){
			if(data[i] != -1){
				start = end;
				end = i;
				System.out.println("start = "+start);
				System.out.println("end = "+end);
				Point p1 = new Point(start,data[start]);
				Point p2 = new Point(end,data[end]);
				
				tag = distance(p1,p2);
//				System.out.println("tag"+tag);
				if(tag!=-1&&tag>max){
					max = tag;
				}
			}
			
		}
		
		
		if(tag==-1)
			return "IMPOSSIBLE";
		else{
			return max+"";
		}
	}
	
	public int distance(Point p1,Point p2){
		
		int dis = (p2.d-p1.d+Math.abs(p1.h-p2.h))/2;
		int dis2 = Math.abs(p1.h-p2.h);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("dis = "+dis);
		System.out.println("dis2 = "+dis2);
		if(dis>dis2)
			return -1;
			return dis;
	}
	static class Point{
		public int d = 0;
		public int h = 0;
		public Point(){};
		public Point(int d,int h){
			this.d = d;
			this.h = h;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return d+","+h;
		}
	}
	
}
