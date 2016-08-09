package com.jacksen.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 测试 mark  reset 函数
 * @author jacksen
 * @date 2016-7-21 下午6:05:19
 */
public class TestReset {
	
	public static void main(String[] args) {
		
		/*String filePath = "";
		File file = new File(filePath);
		
		
		InputStream inputStream = new FileInputStream(file)*/
		
		System.out.println(func("cantv"));
		
		
	}
	
	public static String func(String s){
		return s.length() > 0? func(s.substring(1)) + s.charAt(0) :"";
	}

}
