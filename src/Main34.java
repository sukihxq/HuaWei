import java.util.*; 
public class Main34{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            float n = sc.nextFloat();
            int m = fun(n);
           	System.out.println(m);
        }
        sc.close();
    }
    public static int fun(float data){
        int m = (int) Math.floor(data);
        float tep = data - m;
        if(tep>=0.5){
            m++;
        }
        return m;
    }
}