/**
 * @project HuaWei
 * @package study
 * @filename GenericDao.java
 */
package study;

import java.util.Set;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月30日 下午3:10:55
 */
public class GenericDao<X> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GenericDao().init();
	}
	public void init(){
		
	}
	public void add(X a){}
	public X findById(X a){return null;}
	public void delete(X a){}
	public void uodate(X a){}
	public Set<X> findByCondition(String where){return null;}

}
