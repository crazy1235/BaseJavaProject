package com.jacksen.java.datastructure.stack;

import java.util.NoSuchElementException;

public abstract class AbstractStack<E> implements StackInter<E> {

	/**
	 * 栈的长度
	 */
	protected int size = 0;

	protected abstract E get(int index);

	/**
	 * 检查栈的长度
	 * 
	 * @param size
	 */
	protected void checkSize(int size) {
		if (size <= 0) {
			throw new NoSuchElementException();
		}
	}
}
