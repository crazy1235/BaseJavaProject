package com.jacksen.java.datastructure.string;

/**
 * 
 * @author jacksen
 * 
 */
public class Test {

	public static void main(String[] args) {

		char[] value = new char[] { '1', '2', '3', '4' };
		JackString str = new JackString(value);

		value[2] = 'a';
		
		System.out.println(str.isEmpty());

		System.out.println(str.value);
		
		System.out.println("123");
		
		Integer in = new Integer(1230);
		in.toString();
	}

}
