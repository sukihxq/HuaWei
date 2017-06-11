package test;
import java.sql.Date;
public class Main16 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main16().init();
	}
	public void init(){
		int x = 1;
		int y = 0;
		System.out.println("x="+x+"\ty="+y);
		if(x==2&&++y>0)
			System.out.println("x==2&&++y>0\nx="+x+"\ty="+y);
		System.out.println("x="+x+"\ty="+y);
		if(x==2&++y>0)
			System.out.println("x==2&&++y>0\nx="+x+"\ty="+y);
		System.out.println("x="+x+"\ty="+y);
		String ca = "123";
		switch(ca){
		case "12":
			System.out.println("12");
			break;
		case "123":
			System.out.println("123");
			break;
		}
		
		
		final StringBuffer sb = new StringBuffer("abc");
		//sb = new StringBuffer();
		sb.append("123");
		
		String a = "a";
		String b = "a";
		String c = new String("a");
		if(a.equals(b)){
			System.out.println("a.equals(b)");
		}
		if(a==b){
			System.out.println("a==b");
		}
		if(a.equals(c)){
			System.out.println("a.equals(c)");
		}
		if(a!=c){
			System.out.println("a!=c");
		}
		
		System.out.println(Math.round(11.4));
		System.out.println(Math.round(-11.6));
		
	}
	public void fun1(int a,int b,long c){}
	public void fun1(int a,long b,int c){}

}

abstract class T1{
	
}


class T2 extends Date{

	/**
	 * @param year
	 * @param month
	 * @param day
	 */
	@SuppressWarnings("deprecation")
	public T2(int year, int month, int day) {
		super(year, month, day);
		// TODO Auto-generated constructor stub
	}
	
}

//>>>>>>> branch 'develop' of https://github.com/xshqhua/HuaWei.git
