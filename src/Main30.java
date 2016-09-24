import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main30 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String tt = scanner.nextLine();
			System.out.println(Integer.toOctalString(Integer.parseInt(tt)));
			System.out.println(Integer.toHexString(Integer.parseInt(tt)));
			System.out.println(Integer.toBinaryString(Integer.parseInt(tt)));
		}
		scanner.close();
		String tep = "AA";
		tep.toUpperCase();
		List l = new ArrayList<>();
		System.out.println(tep.replace("A", "B"));
		Random r = new Random();
//		r.nextInt()
		StringBuffer sb = new StringBuffer();
		sb.append(0);
				
	}

}
