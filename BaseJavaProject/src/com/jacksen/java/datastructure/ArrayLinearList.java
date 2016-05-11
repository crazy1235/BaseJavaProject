package com.jacksen.java.datastructure;

import java.util.Arrays;

/**
 * 顺序存储结构
 * 
 * @author jacksen
 * @date 2016-5-11 下午2:25:34
 * @param <E>
 */
public class ArrayLinearList<E> extends AbstractLinearList<E> implements LinearList<E> {

	private static final int DEFAULT_CAPACITY = 10;

	private static final Object[] EMPTY_ELEMENTDATA = {};

	private Object[] elementData;

	public ArrayLinearList() {
		super();
		this.elementData = EMPTY_ELEMENTDATA;
	}

	public ArrayLinearList(int initialCapacity) {
		super();
		if (initialCapacity < 0) {
			throw new IllegalArgumentException(
					"initialCapacity can not less than zero.");
		}
		this.elementData = new Object[initialCapacity];
	}

	/**
	 * 扩容
	 * 
	 * @param minCapacity
	 */
	private void ensureCapacityInternal(int minCapacity) {
		if (elementData == EMPTY_ELEMENTDATA) {
			minCapacity = Math.max(minCapacity, DEFAULT_CAPACITY);
		}
		if (minCapacity - elementData.length > 0) {
			elementData = Arrays.copyOf(elementData, minCapacity);
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(E e) {
		ensureCapacityInternal(size + 1);
		elementData[size++] = e;
	}

	@Override
	public void add(int index, E e) {
		checkIndex(index);
		ensureCapacityInternal(size + 1);
		System.arraycopy(elementData, index, elementData, index + 1, size
				- index);
		elementData[index] = e;
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		checkIndex(index);
		E e = (E) elementData[index];
		int temp = size - index - 1;
		if (temp > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, temp);
		}
		elementData[size - 1] = null;
		--size;
		return e;
	}

	@Override
	public boolean remove(E e) {
		if (e == null) {
			for (int i = 0; i < size; i++) {
				if (elementData[i] == null) {
					int temp = size - i - 1;
					if (temp > 0) {
						System.arraycopy(elementData, i + 1, elementData, i,
								temp);
					}
					elementData[size - 1] = null;
					return true;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (e.equals(elementData[i])) {
					int temp = size - i - 1;
					if (temp > 0) {
						System.arraycopy(elementData, i + 1, elementData, i,
								temp);
					}
					elementData[size - 1] = null;
					return true;
				}
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		checkIndex(index);
		return (E) elementData[index];
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E e) {
		checkIndex(index);
		E oldEle = (E) elementData[index];
		elementData[index] = e;
		return oldEle;
	}

	@Override
	public int getIndex(E e) {
		if (e == null) {
			for (int i = 0; i < size; i++) {
				if (null == elementData[i]) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (e.equals(elementData[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public boolean contains(E e) {
		return getIndex(e) >= 0;
	}

}
