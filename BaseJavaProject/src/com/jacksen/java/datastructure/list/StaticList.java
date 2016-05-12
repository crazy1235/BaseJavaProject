package com.jacksen.java.datastructure.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.omg.CORBA.Current;

/**
 * 静态链表 <br />
 * 
 * @author jacksen
 * 
 * @param <E>
 */
public class StaticList<E> extends AbstractLinearList<E> implements
		LinearList<E> {

	/**
	 * max length of the array
	 */
	private static int MAX_SIZE = 500;

	/**
	 * 记录第一个空闲存储的下标
	 */
	private int freeIndex = 0;

	/**
	 * 记录当前链表头的下标
	 */
	private int headIndex = 0;

	/**
	 * 保存数据的数组
	 */
	private Node<E>[] elementDatas;

	public StaticList() {
		elementDatas = new Node[MAX_SIZE];
		for (int i = 0; i < MAX_SIZE; i++) {
			elementDatas[i] = new Node<>();
			elementDatas[i].next = i + 1;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public E get(int index) {
		checkIndex(index);
		int realIndex = getRealIndex(index);
		return elementDatas[realIndex].item;
	}

	@Override
	public E set(int index, E e) {
		checkIndex(index);
		int realIndex = getRealIndex(index);
		E oldEle = elementDatas[realIndex].item;
		elementDatas[realIndex].item = e;
		return oldEle;
	}

	@Override
	public int getIndex(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(E e) {
		addLast(e);
	}

	/**
	 * 添加新元素到头位置
	 * 
	 * @param e
	 */
	public void addFirst(E e) {
		ensureCapacity();

		int temp = freeIndex;// 新元素位置
		elementDatas[freeIndex].item = e;
		freeIndex = elementDatas[freeIndex].next;
		//
		elementDatas[temp].next = headIndex;
		headIndex = temp;

		size++;
	}

	/**
	 * 添加新元素到链表的结尾
	 * 
	 * @param e
	 */
	public void addLast(E e) {
		ensureCapacity();
		// 将空闲头指针指向下一个
		int temp = freeIndex;
		elementDatas[freeIndex].item = e;
		freeIndex = elementDatas[freeIndex].next;

		size++;
		
		// 将非空闲最后指针指向新结点。
		int lastDataIndex = headIndex;
		for (int i = 0; i < size; i++) {
			lastDataIndex = elementDatas[getRealIndex(i)].next;
		}
		elementDatas[lastDataIndex].next = temp;
	}

	@Override
	public void add(int index, E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 移除最后一个item
	 */
	public E removeLast() {
		if (size <= 0) {
			throw new NoSuchElementException();
		}
		int tempIndex = freeIndex;
		freeIndex = getRealIndex(size - 1);
		E oldEle = elementDatas[freeIndex].item;
		elementDatas[freeIndex].next = tempIndex;
		size--;
		return oldEle;
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * 扩容
	 */
	private void ensureCapacity() {
		if (size >= MAX_SIZE) {
			elementDatas = Arrays.copyOf(elementDatas, MAX_SIZE + MAX_SIZE / 2);
		}
	}

	/**
	 * 返回在数组里的真实下标
	 * 
	 * @param index
	 * @return
	 */
	private int getRealIndex(int index) {
		int realIndex = headIndex;
		//
		int i = 0;
		while (i < index) {
			realIndex = elementDatas[realIndex].next;
			i++;
		}
		return realIndex;
	}

	private static class Node<E> {
		E item;
		int next;

		public Node() {

		}

		public Node(E item) {
			super();
			this.item = item;
		}

		public Node(E item, int next) {
			super();
			this.item = item;
			this.next = next;
		}
	}

}
