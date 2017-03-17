package com.jacksen.java.test;

public class Test8 {

	private static final int MODE_SHIFT = 30;

	private static final int MODE_MASK = 0x3 << MODE_SHIFT; // 11

	public static final int UNSPECIFIED = 0 << MODE_SHIFT; // 00

	public static final int EXACTLY = 1 << MODE_SHIFT; // 01

	public static final int AT_MOST = 2 << MODE_SHIFT; // 10

	public static void main(String[] args) {
		System.out.println(MODE_MASK);

		//
		byte[] bytes = intToByte32(MODE_MASK);

		for (int i = 0; i < bytes.length; i++) {
			System.out.print(bytes[i]);
		}

		System.out.println();

		//

		bytes = intToByte32(EXACTLY);

		for (int i = 0; i < bytes.length; i++) {
			System.out.print(bytes[i]);
		}

		System.out.println();

		//

		bytes = intToByte32(AT_MOST);

		for (int i = 0; i < bytes.length; i++) {
			System.out.print(bytes[i]);
		}
	}

	/**
	 * 
	 * <pre>
	 * 将int转换为32位byte.
	 * 实际上每个8位byte只存储了一个0或1的数字
	 * 比较浪费.
	 * </pre>
	 * 
	 * @param num
	 * @return
	 */
	public static byte[] intToByte32(int num) {
		byte[] arr = new byte[32];
		for (int i = 31; i >= 0; i--) {
			// &1 也可以改为num&0x01,表示取最地位数字.
			arr[i] = (byte) (num & 1);
			// 右移一位.
			num >>= 1;
		}
		return arr;
	}
}
