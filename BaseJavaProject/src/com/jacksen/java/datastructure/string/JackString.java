package com.jacksen.java.datastructure.string;

/**
 * 字符串
 * 
 * @author jacksen
 * 
 */
public class JackString {

	public char[] value;

	public JackString() {
		value = new char[0];
	}

	public JackString(JackString original) {
		this.value = original.value;
	}

	public JackString(char[] value) {
		this.value = new char[value.length];
		System.arraycopy(value, 0, this.value, 0, value.length);
	}

	public JackString(char[] value, int offset, int length) {
		if (offset < 0) {
			throw new StringIndexOutOfBoundsException(offset);
		}
		if (length < 0) {
			throw new StringIndexOutOfBoundsException(length);
		}
		if (value.length - offset < length) {
			throw new StringIndexOutOfBoundsException();
		}
		System.arraycopy(value, offset, this.value, 0, length);
	}

	/**
	 * return length of the string
	 */
	public int length() {
		return this.value.length;
	}

	/**
	 * check the string is empty or not.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.value.length == 0;
	}

	public void checkIndex(int index) {
		if (index < 0 || index >= value.length) {
			throw new StringIndexOutOfBoundsException();
		}
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public char charAt(int index) {
		checkIndex(index);
		return value[index];
	}

	/**
	 * 
	 * @param beginIndex
	 * @return
	 */
	public JackString subString(int beginIndex) {
		if (beginIndex < 0) {
			throw new StringIndexOutOfBoundsException(beginIndex);
		}
		if (value.length < beginIndex) {
			throw new StringIndexOutOfBoundsException(beginIndex);
		}
		return new JackString(value, beginIndex, value.length - beginIndex);
	}

	/**
	 * 
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public JackString subString(int beginIndex, int endIndex) {
		if (beginIndex < 0) {
			throw new StringIndexOutOfBoundsException(beginIndex);
		}
		if (endIndex < 0) {
			throw new StringIndexOutOfBoundsException(endIndex);
		}
		if (beginIndex > endIndex) {
			throw new StringIndexOutOfBoundsException("beginIndex > endIndex");
		}
		if (beginIndex == 0 && endIndex == value.length) {
			return this;
		}
		return new JackString(value, beginIndex, endIndex - beginIndex);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public JackString concat(JackString str) {
		int strLength = str.length();
		if (strLength <= 0) {
			return this;
		}
		char newChar[] = new char[this.length() + strLength];
		System.arraycopy(this.value, 0, newChar, 0, this.length());
		System.arraycopy(str.value, 0, newChar, this.length(), strLength);
		return new JackString(newChar);
	}

	/**
	 * 
	 * @param oldChar
	 * @param newChar
	 */
	public JackString replace(char oldChar, char newChar) {
		// TODO

		return new JackString();
	}

	/**
	 * 在第index个字符之前插入串
	 * 
	 * @param index
	 * @param str
	 * @return
	 */
	public JackString insert(int index, JackString str) {
		// TODO
		return new JackString();
	}

	/**
	 * 删除从index位置起length个长度的子串
	 * 
	 * @param index
	 * @param length
	 * @return
	 */
	public JackString remove(int index, int length) {
		// TODO
		return new JackString();
	}

}
