package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @project HuaWei
 * @package 
 * @filename Main15.java
 */
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月21日 下午8:00:08
 */
public class Main15 {
	Stack<Point> stack = new Stack<>();
	int [][]maze;
	boolean [][]p;
	/**
	 * 样例输入
9 8
0	0	1	0	0	0	1	0
0	0	1	0	0	0	1	0
0	0	1	0	1	1	0	1
0	1	1	1	0	0	1	0
0	0	0	1	0	0	0	0
0	1	0	0	0	1	0	1
0	1	1	1	1	0	0	1
1	1	0	0	0	1	0	1
1	1	0	0	0	0	0	0
1 1

	 */
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main15().init();
	}
	
	public void init(){
		int row = 0;
		int col = 0;
		int [][]maze;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String []numStr = scanner.nextLine().split(" ");
			row = Integer.parseInt(numStr[0]);
			col = Integer.parseInt(numStr[1]);
			maze = new int[row][col];
			for(int i=0;i<row;i++){
				maze[i] = toInt(scanner.nextLine(),"\t");
			}
			int []starts = toInt(scanner.nextLine(), " ");
			fun(maze,toPoint(starts));
			/*System.out.println("migong");
			print(maze);*/
		}
	}
	
	public void fun(int [][]nums,Point point){
		int row = nums.length;
		int col = nums[0].length;
		int [][]data = new int[row+2][col+2];
		p = new boolean [row+2][col+2];
		for(int i=0;i<row+2;i++){
			for(int j=0;j<col+2;j++){
				data[0][j] = 1;
				data[row+1][j] = 1;
				data[i][0] = 1;
				data[i][col+1] = 1;
				p[i][j] = false;
			}
		}
		System.out.println("=================");
		print(data);
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				data[i+1][j+1] = nums[i][j];
			}
		}
		System.out.println("===================");
		print(data);
		System.out.println("===================");
		
		int i = point.row+1;
		int j = point.col+1;
		p[i][j] = true;
		stack.push(new Point(i, j));
		while(!stack.isEmpty()&&!((i==row)&&(j==col))){
			if(data[i][j+1]==0&&!p[i][j+1]){
				stack.push(new Point(i, j+1));
				p[i][j+1] = true;
				j++;
			}else if(data[i+1][j]==0&&!p[i+1][j]){
				p[i+1][j] = true;
				stack.push(new Point(i+1, j));
				i++;
			}else if(data[i][j-1]==0&&!p[i][j-1]){
				p[i][j-1] = true;
				stack.push(new Point(i, j-1));
				j--;
			}else if(data[i-1][j]==0&&!p[i-1][j]){
				p[i-1][j] = true;
				stack.push(new Point(i-1, j));
				i--;
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
			System.out.println("no path");
			return ;
		}
		
		String [][] res = new String[row+1][col+1];
		
		for(int i1=0;i1<row;i1++){
			for(int j1=0;j1<col;j1++){
				res[i1][j1] = nums[i1][j1]+"";
			}
		}
		while(!path.isEmpty()){
			res[path.peek().row-1][path.peek().col-1] = "*";
			path.pop();
		}
		
		System.out.println("========ok=========");
		for(int i1=0;i1<row;i1++){
			for(int j1=0;j1<col;j1++){
				System.out.print(res[i1][j1]+" ");
			}
			System.out.println();
		}
		
		
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
	public void print(int [][]nums){
		for(int i=0;i<nums.length;i++){
			for(int j=0;j<nums[i].length;j++){
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
	}
	public Point toPoint(int [] nums){
		return new Point(nums[0], nums[1]);
	}
}
/*
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
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}

}*/
//>>>>>>> branch 'develop' of https://github.com/xshqhua/HuaWei.git
