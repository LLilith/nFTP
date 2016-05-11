package com.newer.nftp;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 生成文件的数字摘要（MD5、SHA1、CRC）
 * 
 * @author lyping
 *
 */

public class MDUtil {
	
	public static String getMD5(File file){
		return get(file,"MD5");
	}
	
	public static String getSHA(File file){
		return get(file,"SHA-1");
	}
	
	
	/**
	 * 获得文件的 MD5 值
	 * 
	 * @param file
	 * @return
	 */
	private static String get(File file,String alg){
		
		//TODO file 转化成byte[]
		
		
		// 函数包
		try {
			MessageDigest md = MessageDigest.getInstance(alg);
			
			byte[] data = "hello".getBytes();
			byte[] result = md.digest(data);
			
//			System.out.println(result.length);
//			System.out.println(Arrays.toString(result));
			
			//字节数组转化为十六进制数
			BigInteger b = new BigInteger(1,result);
			System.out.println(b.toString());
			
			//整数转化成字符串：数制系统
			String m = b.toString(16);
			System.out.println(m.length());
			System.out.println(m);
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		MDUtil d = new MDUtil();
		d.getMD5(null);
	}
}
