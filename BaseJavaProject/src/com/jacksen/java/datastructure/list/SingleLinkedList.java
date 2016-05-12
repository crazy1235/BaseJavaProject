package com.jacksen.java.datastructure.list;

import java.util.NoSuchElementException;

/**
 * 单链表 <br/>
 * 查找的时间复杂度是o(n)
 * 
 * @author jacksen
 * @date 2016-5-11 下午3:13:05
 */
public class SingleLinkedList<E> extends AbstractLinearList<E> implements
		LinearList<E> {

	/**
	 * 头结点
	 */
	private Node<E> firstNode;

	public SingleLinkedList() {
		firstNode = new Node<E>(null);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		Node<E> temp = firstNode;
		while (temp != null) {
			temp.item = null;
			temp.next = null;
			temp = temp.next;
		}
		size = 0;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		int temp = 0;
		Node<E> tempNode = firstNode.next;
		while (tempNode != null) {
			if (temp == index) {
				return tempNode.item;
			}
			tempNode = tempNode.next;
			temp++;
		}
		return null;
	}

	@Override
	public E set(int index, E e) {
		checkIndex(index);
		Node<E> tempNode = firstNode;
		E oldE = null;
		while (tempNode != null) {
			tempNode = tempNode.next;
			if (index == 0) {
				oldE = tempNode.item;
				tempNode.item = e;
				break;
			}
			index--;
		}
		return oldE;
	}

	@Override
	public int getIndex(E e) {
		int index = 0;
		Node<E> tempNode = firstNode.next;
		if (e == null) {
			while (tempNode != null) {
				if (tempNode.item == null) {
					return index;
				}
				tempNode = tempNode.next;
				index++;
			}
		} else {
			while (tempNode != null) {
				if (e.equals(tempNode.item)) {
					return index;
				}
				tempNode = tempNode.next;
				index++;
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
		isPositionIndex(index);
		if (index == size) {
			addLast(e);
			return;
		}
		Node<E> newNode = new Node<E>(e);
		Node<E> tempNode = firstNode;
		while (tempNode != null) {
			if (index == 0) {
				newNode.next = tempNode.next;
				tempNode.next = newNode;
				size++;
				break;
			}
			tempNode = tempNode.next;
			index--;
		}
	}

	public void addFirst(E e) {
		Node<E> node = new Node<E>(e, firstNode.next);
		firstNode.next = node;
		size++;
	}

	/**
	 * add one node at the last position.
	 * 
	 * @param e
	 */
	public void addLast(E e) {
		Node<E> node = new Node<E>(e, null);
		if (firstNode == null) {
			firstNode = new Node<E>(null, node);
			size++;
			return;
		}
		Node<E> preTemp = firstNode;
		Node<E> tempNode = preTemp.next;
		while (tempNode != null) {
			preTemp = tempNode;
			tempNode = tempNode.next;
		}
		preTemp.next = node;
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

		Node<E> preTemp = firstNode;
		Node<E> tempNode = preTemp.next;
		while (tempNode != null) {
			if (index == 0) {
				preTemp.next = tempNode.next;
				break;
			}
			preTemp = tempNode;
			tempNode = tempNode.next;
			index--;
		}

		E oldEle = tempNode.item;
		preTemp.next = tempNode.next;
		tempNode.next = null;
		size--;
		return oldEle;

	}

	@Override
	public boolean remove(E e) {
		Node<E> preTemp = firstNode;
		Node<E> tempNode = preTemp.next;
		if (e == null) {
			while (tempNode != null) {
				if (tempNode.item == null) {
					preTemp.next = tempNode.next;
					tempNode.item = null;
					tempNode.next = null;
					
					size--;
					return true;
				}
				preTemp = tempNode;
				tempNode = tempNode.next;
			}
		} else {
			while (tempNode != null) {
				if (e.equals(tempNode.item)) {
					preTemp.next = tempNode.next;
					tempNode.item = null;
					tempNode.next = null;
					
					size--;
					return true;
				}
				preTemp = tempNode;
				tempNode = tempNode.next;
			}
		}
		return false;
	}

	/**
	 * remove the first node
	 * 
	 * @return
	 */
	public E removeFirst() {
		if (firstNode.next == null) {
			throw new NoSuchElementException();
		}
		Node<E> tempNode = firstNode.next;
		E oldEle = tempNode.item;
		tempNode.item = null;
		tempNode = tempNode.next;
		firstNode.next = tempNode;
		size--;
		return oldEle;
	}

	/**
	 * remove the last node
	 * 
	 * @return
	 */
	public E removeLast() {
		if (firstNode.next == null) {
			throw new NoSuchElementException();
		}
		E oldEle = null;
		Node<E> preTemp = firstNode.next;
		Node<E> tempNode = preTemp.next;
		if (tempNode == null) {
			oldEle = preTemp.item;

			preTemp.next = null;
			preTemp.item = null;
			firstNode.next = null;
		} else {
			while (tempNode.next != null) {
				preTemp = tempNode;
				tempNode = tempNode.next;
			}
			oldEle = tempNode.item;
			tempNode.item = null;
			tempNode.next = null;

			preTemp.next = null;
		}
		size--;
		return oldEle;
	}

	@Override
	public int size() {
		return size;
	}

	private static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item) {
			super();
			this.item = item;
		}

		public Node(E item, Node<E> next) {
			super();
			this.item = item;
			this.next = next;
		}
	}

}
