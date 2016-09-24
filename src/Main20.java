import java.util.Scanner;
public class Main20 {
	public static void main(String[] args) {
		new Main20().init();
	}
	public void init(){
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			
			String[] values=scanner.nextLine().split(",| ");
			//System.out.println(values[0]+"\t"+values[1]);
			fun(values[0],values[1]);
			
		}
		scanner.close();	
		
	}
	public void fun(String str1,String str2){
		if(!check(str1)||!check(str2)){
			System.out.println("error");
			return ;
		}
		int carry = 0;
		char [] res;
		char [] ch1 = str1.toCharArray(); 
		char [] ch2 = str2.toCharArray();
		if(ch1.length>ch2.length){
			res = new char[ch1.length+1];
		}else
			res = new char[ch2.length+1];
		
		int i = ch1.length-1;
		int j = ch2.length-1;
		int size = res.length-1;
		while(i>=0&&j>=0){
			int tep = carry + (ch1[i--]-'0'+ch2[j--]-'0');
			carry = tep/10;
			tep = tep%10;
			res[size--] = (char) (tep+'0');
		}
		
		while(i>=0){
			int tep = carry + (ch1[i--]-'0');
			carry = tep/10;
			tep = tep%10;
			res[size--] = (char) (tep+'0');
		}
		
		while(j>=0){
			int tep = carry + (ch2[j--]-'0');
			carry = tep/10;
			tep = tep%10;
			res[size--] = (char) (tep+'0');
		}
		
		res[0] =  (char) (carry+'0');
		
		String result = new String(res);
		if(res[0]=='0'){

			result = result.substring(1);
		}
		System.out.println(result);
	}

	public boolean check(String value){
		try{
			Integer.parseInt(value);	
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
		
	}
}
