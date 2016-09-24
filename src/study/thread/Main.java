/**
 * @project HuaWei
 * @package study.thread
 * @filename Main20.java
 */
package study.thread;


/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月25日 下午1:43:03
 */
class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println((Integer)null);
//		Integer a = null;
//		System.out.println(a instanceof Integer);
//		System.out.println(1==a);
//		System.out.println(new Integer(1)==a);
		new Main().init();
		
	}
	
	public void init(){
		HasStatic hs1= new HasStatic();
		//hs1.x++;
	}
	public void fun(int m,int n){
		if(m<0||n<0)
			return ;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
//				c[i][j] = 0;
			}
		}
		int besti = 0,bestj=0; 
	}

}

