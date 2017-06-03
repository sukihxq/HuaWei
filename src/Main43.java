/**
 * @project HuaWei
 * @package 
 * @filename Main.java
 */
/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年10月19日 下午7:27:46
 */
public class Main43 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = { { 1, 9, 3, 4 }, { 4, 1, 6 }, { 4 } };
		fun(input);
	}

	public static int [] fun(int[][] input) {
		
		int size = 0;
		for (int i = 0; i < input.length; i++) {
			if (size < input.length)
				size = input.length;
		}
		int[] res = new int[size];
		
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < input.length; i++) {
				if (input.length > j) {
					res[j] = input[i][j];
					break;
				}
			}
		}
//		for(int i:res)
//			System.out.print(i+" ");
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < input.length; i++) {
				if (input[i].length > j) {
					if (res[j] > input[i][j])
						res[j] = input[i][j];
				}
			}
		}
		System.out.println();
		for(int i:res)
			System.out.print(i+" ");
		return res;
		
	}

}
