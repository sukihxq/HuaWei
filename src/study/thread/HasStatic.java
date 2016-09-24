/**
 * @project HuaWei
 * @package study.thread
 * @filename Main20.java
 */
package study.thread;

class HasStatic{
	private static int x = 100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println((Integer)null);
//		Integer a = null;
//		System.out.println(a instanceof Integer);
//		System.out.println(1==a);
//		System.out.println(new Integer(1)==a);
		HasStatic hs1 = new HasStatic();
		hs1.x++;
		HasStatic hs2 = new HasStatic();
		hs2.x++;
		HasStatic.x--;
		System.out.println(x); 
		
		
	}
}