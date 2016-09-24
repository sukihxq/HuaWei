import java.lang.reflect.Array;

public class Print {
	public static void printObject(Object obj) {
		// TODO Auto-generated method stub
		if(obj==null){
			System.out.println(obj);
			return;
		}
		Class clazz = obj.getClass();
		if(clazz.isArray()){
			int len = Array.getLength(obj);
			for(int i=0;i<len;i++)
				System.out.print(Array.get(obj, i));
			System.out.println();
		}else {
			System.out.println(obj);
		}
	}
}
