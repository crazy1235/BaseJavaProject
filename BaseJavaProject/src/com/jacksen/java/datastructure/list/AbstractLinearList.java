package com.jacksen.java.datastructure.list;

public abstract class AbstractLinearList<E> implements LinearList<E> {

	protected int size = 0;

	/**
	 * check for index
	 * 
	 * @param index
	 */
	protected void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * 
	 * @param index
	 */
	protected void isPositionIndex(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
	}

}
