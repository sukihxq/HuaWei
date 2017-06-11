package test;
/**
 * @project HuaWei
 * @package study
 * @filename ClassLoader.java
 */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author xsh
 * @Email xshqhua@foxmail.com
 * @date 2016年8月30日 下午4:23:40
 */


public class MyClassLoader {
	public static void main(String [] args){
		new MyClassLoader().init(args);
	}
	public void init(String [] args){
		try{
			String srcPath = args[0];
			String tarPath = args[0];
			FileInputStream fis = new FileInputStream(srcPath);
			FileOutputStream fos = new FileOutputStream(tarPath);
			cpyher(fis, fos);
			fis.close();
			fos.close();
		}catch(Exception e){}finally{
			
		}
		
		
		
	}
	public void cpyher(InputStream ips,OutputStream ops) throws Exception{
		int b = -1;
		while((b=ips.read())!=-1){
			ops.write(b^0xff);
		}
	}
}

