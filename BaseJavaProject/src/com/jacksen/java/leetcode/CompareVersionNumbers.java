package com.jacksen.java.leetcode;

/**
 * 
 * @author jacksen
 * 
 */
public class CompareVersionNumbers {
	public static void main(String[] args) {
		System.out.println(compareVersion3("1.1.0", "1.1"));
	}

	/**
	 * split 该方法适用于只有一个 . 的version
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */
	public static int compareVersion(String version1, String version2) {
		if (version1.equals(version2)) {
			return 0;
		}
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");
		int ver1Fir = Integer.parseInt(ver1[0]);
		int ver2Fir = Integer.parseInt(ver2[0]);
		if (ver1Fir > ver2Fir) {
			return 1;
		} else if (ver1Fir < ver2Fir) {
			return -1;
		} else {
			if (ver1.length > 1) {
				if (ver2.length == 1) {
					return 1;
				} else {
					int ver1Sec = Integer.parseInt(ver1[1]);
					int ver2Sec = Integer.parseInt(ver2[1]);
					if (ver1Sec > ver2Sec) {
						return 1;
					} else if (ver1Sec < ver2Sec) {
						return -1;
					} else {
						return 0;
					}
				}
			} else {
				if (ver2.length == 1) {
					return 0;
				} else {
					return -1;
				}
			}
		}
	}

	/**
	 * 小数点隔开的数字依次比较
	 * 
	 * @author jacksen
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */
	public static int compareVersion2(String version1, String version2) {
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");

		int length1 = ver1.length;
		int length2 = ver2.length;
		int maxLen = Math.max(length1, length2);

		for (int i = 0; i < maxLen; i++) {
			int temp1 = 0, temp2 = 0;
			if (i < length1) {
				temp1 = Integer.parseInt(ver1[i]);
			}
			if (i < length2) {
				temp2 = Integer.parseInt(ver2[i]);
			}
			if (temp1 > temp2) {
				return 1;
			} else if (temp1 < temp2) {
				return -1;
			}
		}
		return 0;
	}

	/**
	 * 同样是小数点隔开的数字依次比较，不过不是使用interger.parseInt()进行转换。而是采用 -'0'的方法。
	 * 
	 * @author from Internet
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */
	public static int compareVersion3(String version1, String version2) {
		int temp1;
		int temp2;

		int i = 0;
		int j = 0;

		while (i < version1.length() || j < version2.length()) {
			temp1 = 0;
			temp2 = 0;
			//
			while (i < version1.length() && '.' != version1.charAt(i)) {
				temp1 = temp1 * 10 + (version1.charAt(i) - '0');
				i++;
			}
			i++;
			//
			while (j < version2.length() && '.' != version2.charAt(j)) {
				temp2 = temp2 * 10 + (version2.charAt(j) - '0');
				j++;
			}
			j++;
			//
			if (temp1 > temp2) {
				return 1;
			}
			if (temp1 < temp2) {
				return -1;
			}
		}
		return 0;
	}

}
