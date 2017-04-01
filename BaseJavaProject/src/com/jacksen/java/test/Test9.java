package com.jacksen.java.test;


public class Test9 {

	public static void main(String[] args) {
		boolean result = "411422199201013632"
				.matches("^[1-9]\\\\d{7}((0\\\\d)|(1[0-2]))(([0|1|2]\\\\d)|3[0-1])\\\\d{3}$|^[1-9]\\\\d{5}[1-9]\\\\d{3}((0\\\\d)|(1[0-2]))(([0|1|2]\\\\d)|3[0-1])\\\\d{3}([0-9]|[xX])$");
		System.out.println(result);

		String idCardString = "411422199201013632";
		result = idCardString
				.matches("^\\d{6}(?:1|2){1}\\d{3}(0[1-9]|1[0-2])[0-3][0-9](\\d{4}|\\d{3}X)$");

		System.out.println(result);
	}

}
