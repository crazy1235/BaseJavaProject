package com.jacksen.java.datastructure.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 循环队列
 * 
 * @author jacksen
 * 
 * @param <E>
 * 
 */
public class CirularQueue<E> implements QueueInter<E> {

	/**
	 * 指向对头元素
	 */
	private int front = 0;

	/**
	 * 指向队尾往后一个位置
	 */
	private int rear = 0;

	/**
	 * 数组默认长度
	 */
	private static int DEFAULT_SIZE = 4;

	/**
	 * 分配的数组的总长度
	 */
	private int totalSize = DEFAULT_SIZE;

	private Object[] elementData;

	public CirularQueue() {
		elementData = new Object[DEFAULT_SIZE];
	}

	/**
	 * 简单的扩容方法
	 */
	private void expandCapacity() {
		if ((rear + 1) % totalSize == front) {// 队列满
			int oldTotalSize = totalSize;
			totalSize = (totalSize + (totalSize >> 1));
			elementData = Arrays.copyOf(elementData, totalSize);
			if (front > rear) {// 发生了“循环”
				System.arraycopy(elementData, 0, elementData, oldTotalSize,
						rear);// 将【0,rear)区间的元素拷贝到原数组长度的后面开始的位置
				System.arraycopy(elementData, front, elementData, 0, length());// 将真是数据元素前移到0位置
				front = 0;
				rear = oldTotalSize - 1;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E poll() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E e = (E) elementData[front];
		elementData[front] = null;// for GC
		if (front == totalSize - 1) {
			front = 0;
		} else {
			front++;
		}
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return (E) elementData[front];
	}

	@Override
	public void add(E e) {
		expandCapacity();
		if (rear < totalSize - 1) {
			elementData[rear++] = e;
		} else if (front > 0) {
			elementData[rear] = e;
			rear = 0;
		}
	}

	/**
	 * 甚至可以简单粗暴一些，将整个数组置空
	 */
	@Override
	public void clear() {
		if (rear < front) {
			for (int i = 0; i < rear; i++) {
				elementData[i] = null;
			}
			for (int i = front; i < totalSize; i++) {
				elementData[i] = null;
			}
		} else {
			for (int i = front; i < rear; i++) {
				elementData[i] = null;
			}
		}
		front = rear = 0;
	}

	@Override
	public boolean isEmpty() {
		return length() == 0;
	}

	@Override
	public int length() {
		return (rear - front + totalSize) % totalSize;
	}

}
