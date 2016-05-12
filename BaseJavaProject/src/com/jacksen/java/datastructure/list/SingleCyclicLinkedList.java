package com.jacksen.java.datastructure.list;

import java.util.NoSuchElementException;

/**
 * 循环单链表 <br/>
 * 
 * @author jacksen
 * 
 * @param <E>
 */
public class SingleCyclicLinkedList<E> extends AbstractLinearList<E> implements
		LinearList<E> {

	/**
	 * 头结点
	 */
	private Node<E> firstNode;

	public SingleCyclicLinkedList() {
		firstNode = new Node<E>();
		firstNode.next = firstNode;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		Node<E> temp = firstNode.next;
		firstNode.item = null;

		while (temp != null) {
			firstNode = temp;
			temp = temp.next;
			firstNode.item = null;
			firstNode.next = null;
		}
		firstNode.next = firstNode;
		size = 0;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		int temp = 0;
		Node<E> tempNode = firstNode.next;
		while (tempNode != firstNode) {
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
		Node<E> tempNode = getNode(index);
		E oldE = tempNode.item;
		tempNode.item = e;

		return oldE;
	}

	/**
	 * 返回index对应的结点
	 * 
	 * @param index
	 * @return
	 */
	private Node<E> getNode(int index) {
		Node<E> tempNode = firstNode.next;
		while (tempNode != firstNode) {
			if (index == 0) {
				return tempNode;
			}
			tempNode = tempNode.next;
			index--;
		}
		return null;
	}

	@Override
	public int getIndex(E e) {
		int index = 0;
		Node<E> tempNode = firstNode.next;
		if (e == null) {
			while (tempNode != firstNode) {
				if (tempNode.item == null) {
					return index;
				}
				tempNode = tempNode.next;
				index++;
			}
		} else {
			while (tempNode != firstNode) {
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
		checkPositionIndex(index);

		if (index == 0) {
			addFirst(e);
			return;
		}
		if (index == size) {
			addLast(e);
			return;
		}
		Node<E> newNode = new Node<E>(e, null);
		Node<E> tempNode = firstNode;
		while (tempNode.next != firstNode) {
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

	/**
	 * add one node to the first position
	 * 
	 * @param e
	 */
	public void addFirst(E e) {
		Node<E> node = new Node<E>(e, firstNode.next);
		firstNode.next = node;

		Node<E> temp = firstNode;
		while (temp.next != firstNode) {// 查找最后一个结点
			temp = temp.next;
		}
		temp.next = firstNode;

		size++;
	}

	/**
	 * add one node to the last position.
	 * 
	 * @param e
	 */
	public void addLast(E e) {
		Node<E> node = new Node<E>(e, firstNode);
		if (firstNode == null) {
			firstNode = new Node<E>(null, node);
			size++;
			return;
		}
		Node<E> preTemp = firstNode;
		Node<E> tempNode = preTemp.next;
		while (tempNode != firstNode) {
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
		while (tempNode != firstNode) {
			if (index == 0) {
				preTemp.next = tempNode.next;
				break;
			}
			preTemp = tempNode;
			tempNode = tempNode.next;
			index--;
		}

		E oldEle = tempNode.item;
	
		size--;
		return oldEle;

	}

	@Override
	public boolean remove(E e) {
		Node<E> preTemp = firstNode;
		Node<E> tempNode = preTemp.next;
		if (e == null) {
			while (tempNode != firstNode) {
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
			while (tempNode != firstNode) {
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
		if (firstNode.next == firstNode) {
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
		if (firstNode.next == firstNode) {
			throw new NoSuchElementException();
		}
		E oldEle = null;
		Node<E> preTemp = firstNode.next;
		Node<E> tempNode = preTemp.next;
		if (tempNode == firstNode) {
			oldEle = preTemp.item;

			preTemp.next = null;
			preTemp.item = null;
			firstNode.next = firstNode;
		} else {
			while (tempNode.next != firstNode) {
				preTemp = tempNode;
				tempNode = tempNode.next;
			}
			oldEle = tempNode.item;
			tempNode.item = null;
			tempNode.next = null;

			preTemp.next = firstNode;
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

		public Node() {
		}

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
