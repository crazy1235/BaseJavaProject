package com.jacksen.java.datastructure.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 顺序存储结构【队列】
 * 
 * @author jacksen
 */
public class ArrayQueue<E> implements QueueInter<E> {

	/**
	 * 指向对头元素
	 */
	private int front = 0;

	/**
	 * 指向队尾后一个位置
	 */
	private int rear = 0;

	/**
	 * 数组默认长度
	 */
	private static int DEFAULT_SIZE = 50;

	private Object[] elementData;

	public ArrayQueue() {
		elementData = new Object[DEFAULT_SIZE];
	}

	/**
	 * 简单的扩容方法
	 */
	private void expandCapacity() {
		if (rear - front >= DEFAULT_SIZE) {
			elementData = Arrays.copyOf(elementData, DEFAULT_SIZE
					+ DEFAULT_SIZE >> 1);
		}
	}

	/**
	 * 检查队列的长度
	 * 
	 * @param size
	 */
	protected void checkLength() {
		if (rear - front <= 0) {
			throw new NoSuchElementException();
		}
	}

	@Override
	public E poll() {
		checkLength();
		E e = get(front);
		elementData[front++] = null;
		return e;
	}

	@Override
	public E peek() {
		checkLength();
		return get(front);
	}

	@SuppressWarnings("unchecked")
	protected E get(int index) {
		return (E) elementData[index];
	}

	@Override
	public void add(E e) {
		expandCapacity();
		elementData[rear++] = e;
	}

	@Override
	public void clear() {
		for (int i = front; i <= rear; i++) {
			elementData[i] = null;
		}
		front = rear = 0;
	}

	@Override
	public boolean isEmpty() {
		return rear - front == 0;
	}

	@Override
	public int length() {
		return rear >= front ? rear - front : 0;
	}

}
