package com.jacksen.java.datastructure.stack;

import java.util.Arrays;

/**
 * 线性存储结构栈
 * 
 * @author jacksen
 * @date 2016-5-13 下午4:20:04
 * @param <E>
 */
public class ArrayStack<E> extends AbstractStack<E> {

	/**
	 * 栈的长度<br/>
	 * 又可以作为指向第一个空位置的索引
	 */
	private int size = 0;

	/**
	 * 数组默认长度
	 */
	private static int DEFAULT_SIZE = 50;

	private Object[] elementData;

	public ArrayStack() {
		elementData = new Object[DEFAULT_SIZE];
	}

	private void expandCapacity() {
		if (size >= DEFAULT_SIZE) {
			elementData = Arrays.copyOf(elementData, DEFAULT_SIZE
					+ DEFAULT_SIZE >> 1);
		}
	}

	@Override
	public E push(E item) {
		expandCapacity();
		elementData[size] = item;
		size++;
		return item;
	}

	@Override
	public E pop() {
		checkSize(size);
		E e = get(size - 1);
		elementData[size - 1] = null;
		size--;
		return e;
	}

	@Override
	public E peek() {
		checkSize(size);
		return get(size - 1);
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public int search(E item) {
		if (null == item) {
			for (int i = size - 1; i >= 0; i--) {
				if (null == elementData[i]) {
					return i;
				}
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (item.equals(elementData[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		elementData = new Object[DEFAULT_SIZE];
		size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected E get(int index) {
		return (E) elementData[index];
	}

	@Override
	public int size() {
		return size;
	}
}
