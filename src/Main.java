import java.util.*; 
public class Main{
    public static void main(String []args){
        new Main().init();
    }
	public void init() {
		
		int m = 0;
		fun(m);
		
	}
    public int fun(float data){
        int m = (int) Math.floor(data);
        float tep = data - m;
        if(tep>=0.5){
            m++;
        }
        return m;
    }
}