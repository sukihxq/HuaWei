import java.util.Scanner;
public class Main11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			new Main11().fun(str);
		}
	}
	public void fun(String str){
		if(str==null||str.length()<0)
			return;
		char [] chs = str.toCharArray();
		int i=0,j=0;
		int count = 1;
		while(i<chs.length&&!checked(chs[i])){
			i++;
		}
		if(i>=chs.length){
			return ;
		}
		j = i++;
		String res = ""+chs[j];
		while(i<chs.length){
			if(checked(chs[i])){
				if(chs[j]==chs[i]){
					count++;
				}else {
					res+=count;
					res+=chs[i];
					count=1;
				}
				j++;
			}
			i++;
		}
		res+=count;
		System.out.println(res);
	}
	public boolean checked(char c){
		if(c>='a'&&c<='z'||c>='A'&&c<='Z'){
			return true;
		}else
			return false;
	}
}
 