package test;
import java.util.Scanner;
import java.util.Stack;
public class Main29 {
	Stack<Point> stack = new Stack<>();
	int [][]maze;
	boolean [][]p;
	/**
4 4 10
1 0 0 1
1 1 0 1
0 1 1 1
0 0 1 1
	 */
	public static void main(String[] args) {
		new Main29().init();
	}
	
	public void init(){
		int row = 0;
		int col = 0;
		int power = 0;
		int [][]maze;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String []numStr = scanner.nextLine().split(" ");
			row = Integer.parseInt(numStr[0]);
			col = Integer.parseInt(numStr[1]);
			power = Integer.parseInt(numStr[2]);
			maze = new int[row][];
			for(int i=0;i<row;i++){
				maze[i] = toInt(scanner.nextLine()," ");
			}
			int []starts = {0,0};
			if(row>=3&&row>=3&&row<=10&&row<=10&&power<=100&&power>=1)
				fun(maze,toPoint(starts),power);
		}
		scanner.close();
	}
	
	public void fun(int [][]nums,Point point,int power){
		int row = nums.length;
		int col = nums[0].length;
		int [][]data = new int[row+2][col+2];
		p = new boolean [row+2][col+2];
		for(int i=0;i<row+2;i++){
			for(int j=0;j<col+2;j++){
				data[0][j] = 0;
				data[row+1][j] = 0;
				data[i][0] = 0;
				data[i][col+1] = 0;
				p[i][j] = false;
			}
		}
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				data[i+1][j+1] = nums[i][j];
			}
		}
		int i = point.row+1;
		int j = point.col+1;
		p[i][j] = true;
		stack.push(new Point(i, j));
		while(!stack.isEmpty()&&!((i==1)&&(j==col))){
			if(data[i][j+1]==1&&!p[i][j+1]){
				stack.push(new Point(i, j+1));
				p[i][j+1] = true;
				j++;
				power--;
				if(!check(power))
					return ;
			}else if(data[i+1][j]==1&&!p[i+1][j]){
				p[i+1][j] = true;
				stack.push(new Point(i+1, j));
				i++;
				
			}else if(data[i][j-1]==1&&!p[i][j-1]){
				p[i][j-1] = true;
				stack.push(new Point(i, j-1));
				j--;
				power--;
				if(!check(power))
					return ;
			}else if(data[i-1][j]==1&&!p[i-1][j]){
				p[i-1][j] = true;
				stack.push(new Point(i-1, j));
				i--;
				power-=3;
				if(!check(power))
					return ;
			}else {
				stack.pop();
				if(stack.isEmpty())
					break;
				i = stack.peek().row;
				j = stack.peek().col;
			}
		}
		
		Stack<Point> path = new Stack<>();
		while(!stack.isEmpty()){
			Point point1 = new Point();
			point1 = stack.pop();
			path.push(point1);
		}
		
		if(path.isEmpty()){
			System.out.println("Can not escape!");
			return ;
		}
		StringBuffer sb = new StringBuffer();
		while(!path.isEmpty()){
			sb.append("["+(path.peek().row-1)+","+(path.peek().col-1)+"],");
			path.pop();
		}
		
		
		String result = sb.toString();
		System.out.println(result.substring(0,result.length()-1));
	}
	public int[] toInt(String strNums,String split){
		String []numStr = strNums.split(split);
		//System.out.println(numStr.length);
		int []nums = new int [numStr.length];
		for(int i=0;i<nums.length;i++){
			nums[i] = Integer.parseInt(numStr[i]);
		}
		return nums;
	}
	public Point toPoint(int [] nums){
		return new Point(nums[0], nums[1]);
	}
	public boolean check(int power){
		if(power>=0)
			return true;
		else{
			System.out.println("Can not escape!");
			return false;
		}
	}
}
class Point{
	int col = 0;
	int row = 0;
	public Point(){}
	public Point(int row,int col){
		this.row = row;
		this.col = col;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
}