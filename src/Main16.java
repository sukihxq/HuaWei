import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main16().init();
	}

	public void init(){
		Scanner scanner = new Scanner(System.in);
		List<String> books = new ArrayList<>();
		while(scanner.hasNext()){
			int num = Integer.parseInt(scanner.nextLine());
			for(int i=0;i<num;i++){
				books.add(scanner.nextLine());
			}
			String search = scanner.nextLine();
			
			fun(books,search);
			books.clear();
		}
	}
	public void fun(List<String> books,String search){
		List<String> res = new ArrayList<>();
		String [] sears = search.split(" ");
		for(String name:books){
			if(checked(name, sears)){
				if(!res.contains(name))
					res.add(name);
			}
		}
		Collections.sort(res);
		if(res.size()<1){
			System.out.println(0);
			return ;
		}
		System.out.println(res.size());
		for(String s:res){
			System.out.println(s);
		}
	}
	
	public boolean checked(String name,String []check){
		for(String ch:check){
			if(name.contains(ch))
				return true;
		}
		return false;
	}
	public void sort(List<String> line) {
		
	}
	
}
