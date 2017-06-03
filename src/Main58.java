import java.util.Scanner;

public class Main58 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main58().init();
	}
	public void init(){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			String str = s.nextLine();
			GetValueByIP(str);
		}
		s.close();
	}
	public void  GetValueByIP(String input){
		String [] strs = input.split("\\.");
		if(strs.length!=4){
			System.out.println("ERROR");
			return;
		}
		StringBuffer sb = new StringBuffer();
		for(String str:strs){
			int number = Integer.parseInt(str);
			if(number<0||number>255){
				System.out.println("ERROR");
				return;
			}
			String bin = toBinary(number);
			sb.append(bin);
		}
		String v = sb.toString();
//		String v = "1010";
		System.out.println(Long.parseLong(v,2));
	}
	public String toBinary(int n){
		String bin = Integer.toBinaryString(n);
		StringBuffer sb  = new StringBuffer();
		for(int i = bin.length();i<8;i++)
			sb.append(0);
		sb.append(bin);
		return sb.toString();
	}

}
