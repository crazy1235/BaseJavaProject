package com.jacksen.java.datastructure.list;

import java.util.Arrays;
import java.util.NoSuchElementException;


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
		freeIndex = 0;
		headIndex = 0;
		size = 0;
		for (int i = 0; i < MAX_SIZE; i++) {
			elementDatas[i] = new Node<>();
			elementDatas[i].next = i + 1;
		}
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
		if (e == null) {
			for (int i = 0; i < size; i++) {
				if (null == elementDatas[getRealIndex(i)].item) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (e.equals(elementDatas[getRealIndex(i)].item)) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public boolean contains(E e) {
		return getIndex(e) != -1;
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

		// 将非空闲最后指针指向新结点。
		if (headIndex != 0) {
			int lastDataIndex = headIndex;
			for (int i = 0; i < size - 1; i++) {
				lastDataIndex = elementDatas[getRealIndex(i)].next;
			}
			elementDatas[lastDataIndex].next = temp;
		}
		size++;
	}

	@Override
	public void add(int index, E e) {
		isPositionIndex(index);

		if (0 == index) {
			addFirst(e);
			return;
		}
		if (size == index) {
			addLast(e);
			return;
		}

		int temp = freeIndex;
		elementDatas[freeIndex].item = e;
		freeIndex = elementDatas[freeIndex].next;

		int realIndex = getRealIndex(--index);

		elementDatas[temp].next = elementDatas[realIndex].next;
		elementDatas[realIndex].next = temp;

		size++;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		if (0 == index) {
			return removeFirst();
		}
		if (size - 1 == index) {
			return removeLast();
		}

		int preRealIndex = getRealIndex(--index);
		int realIndex = elementDatas[preRealIndex].next;
		E oldEle = elementDatas[realIndex].item;
		elementDatas[preRealIndex].next = elementDatas[realIndex].next;

		size--;
		return oldEle;
	}

	@Override
	public boolean remove(E e) {
		if (null == e) {
			for (int i = 0; i < size; i++) {
				if (null == elementDatas[getRealIndex(i)].item) {
					if (i == 0) {
						removeFirst();
						return true;
					}
					int temp = getRealIndex(i);
					elementDatas[getRealIndex(i - 1)].next = elementDatas[getRealIndex(i)].next;
					elementDatas[temp].next = freeIndex;
					freeIndex = temp;
					
					size--;
					return true;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (e.equals(elementDatas[getRealIndex(i)].item)) {
					if (i == 0) {
						removeFirst();
						return true;
					}
					int temp = getRealIndex(i);
					elementDatas[getRealIndex(i - 1)].next = elementDatas[getRealIndex(i)].next;
					elementDatas[temp].next = freeIndex;
					freeIndex = temp;
					
					size--;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 移除第一个item
	 * 
	 * @return
	 */
	public E removeFirst() {
		E oldEle = elementDatas[headIndex].item;
		int temp = headIndex;
		headIndex = elementDatas[headIndex].next;
		//
		elementDatas[temp].next = freeIndex;
		freeIndex = temp;
		size--;
		return oldEle;
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
