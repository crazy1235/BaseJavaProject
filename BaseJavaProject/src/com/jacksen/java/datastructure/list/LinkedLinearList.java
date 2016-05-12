package com.jacksen.java.datastructure.list;

import java.util.NoSuchElementException;

/**
 * 双向链表
 * 
 * @author jacksen
 * @date 2016-5-11 下午2:27:12
 */
public class LinkedLinearList<E> extends AbstractLinearList<E> implements
		LinearList<E> {

	/**
	 * 指向第一个结点
	 */
	private Node<E> firstNode;

	/**
	 * 指向最后一个结点
	 */
	private Node<E> lastNode;

	public LinkedLinearList() {

	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		Node<E> tempNode = firstNode;
		Node<E> tempNext;
		while (tempNode != null) {
			tempNext = tempNode.next;

			tempNode.pre = null;
			tempNode.next = null;
			tempNode.item = null;

			tempNode = tempNext;
		}
		firstNode = null;
		lastNode = null;
		size = 0;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return getNode(index).item;
	}

	/**
	 * 返回第一个结点
	 * 
	 * @return
	 */
	public E getFirst() {
		if (firstNode == null) {
			throw new NoSuchElementException();
		}
		return firstNode.item;
	}

	/**
	 * 返回最后一个结点
	 * 
	 * @return
	 */
	public E getLast() {
		if (lastNode == null) {
			throw new NoSuchElementException();
		}
		return lastNode.item;
	}

	@Override
	public E set(int index, E e) {
		checkIndex(index);
		Node<E> tempNode = getNode(index);
		E oldEle = tempNode.item;
		tempNode.item = e;
		return oldEle;
	}

	@Override
	public int getIndex(E e) {
		if (e == null) {
			int i = 0;
			Node<E> tempNode = firstNode;
			while (tempNode != null) {
				if (tempNode.item == null) {
					return i;
				}
				tempNode = tempNode.next;
				i++;
			}
		} else {
			int i = 0;
			Node<E> tempNode = firstNode;
			while (tempNode != null) {
				if (e.equals(tempNode.item)) {
					return i;
				}
				tempNode = tempNode.next;
				i++;
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

	@Override
	public void add(int index, E e) {
		checkPositionIndex(index);
		if (index == 0) {
			addFirst(e);
			return;
		}
		if (index == size) {
			addLast(e);
			return;
		}

		Node<E> tempNode = getNode(index);
		Node<E> newNode = new Node<E>(e, tempNode.pre, tempNode);

		tempNode.pre.next = newNode;
		tempNode.pre = newNode;

		size++;
	}

	/**
	 * 根据index返回结点
	 * 
	 * @param index
	 */
	private Node<E> getNode(int index) {
		if (index < (size >> 1)) {
			Node<E> temp = firstNode;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		} else {
			Node<E> temp = lastNode;
			for (int i = size - 1; i > index; i--) {
				temp = temp.pre;
			}
			return temp;
		}
	}

	/**
	 * 在链表头部添加一个结点
	 * 
	 * @param e
	 */
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e, null, firstNode);
		Node<E> temp = firstNode;
		firstNode = newNode;
		if (temp == null) {
			lastNode = newNode;
		} else {
			temp.pre = newNode;
		}
		size++;
	}

	/**
	 * 往链表最后添加一个结点
	 * 
	 * @param e
	 */
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e, lastNode, null);
		Node<E> temp = lastNode;
		lastNode = newNode;
		if (temp == null) {
			firstNode = newNode;
		} else {
			temp.next = newNode;
		}
		size++;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);

		if (index == 0) {
			return removeFirst();
		}
		if (index == size - 1) {
			return removeLast();
		}
		Node<E> tempNode = getNode(index);
		E ele = tempNode.item;

		//
		tempNode.pre.next = tempNode.next;
		tempNode.next.pre = tempNode.pre;

		// 将删除的结点置空 for GC
		tempNode.item = null;
		tempNode.pre = null;
		tempNode.next = null;
		
		//
		size--;

		return ele;
	}

	@Override
	public boolean remove(E e) {
		return false;
	}

	/**
	 * 删除第一个结点
	 * 
	 * @return
	 */
	public E removeFirst() {
		if (firstNode == null) {
			throw new NoSuchElementException();
		}

		Node<E> temp = firstNode;
		E ele = temp.item;
		Node<E> tempNext = temp.next;
		if (tempNext == null) {
			lastNode = null;
		} else {
			tempNext.pre = null;
		}
		firstNode = tempNext;// 首结点指针指向后一个

		temp.pre = null;
		temp.next = null;
		temp.item = null;

		size--;//

		return ele;
	}

	/**
	 * 删除最后一个结点
	 * 
	 * @return
	 */
	public E removeLast() {
		if (lastNode == null) {
			throw new NoSuchElementException();
		}

		Node<E> temp = lastNode;
		E ele = temp.item;
		Node<E> tempPre = temp.pre;
		if (tempPre == null) {
			firstNode = null;
		} else {
			tempPre.next = null;
		}
		lastNode = tempPre;// 最后结点指针指向前一个

		temp.pre = null;
		temp.next = null;
		temp.item = null;

		size--;//

		return ele;
	}

	@Override
	public int size() {
		return size;
	}

	private static class Node<E> {

		E item;
		Node<E> pre;
		Node<E> next;

		public Node(E item, Node<E> pre, Node<E> next) {
			super();
			this.item = item;
			this.pre = pre;
			this.next = next;
		}

	}
}
