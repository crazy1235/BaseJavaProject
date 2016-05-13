package com.jacksen.java.datastructure.stack;


/**
 * 链式存储结构栈
 * 
 * @author jacksen
 * @date 2016-5-13 下午4:21:19
 * @param <E>
 */
public class LinkedStack<E> extends AbstractStack<E> {

	/**
	 * 头指针
	 */
	private Node<E> head;

	public LinkedStack() {
		head = new Node<>();
	}

	@Override
	public E push(E item) {
		Node<E> newNode = new Node<>(item, head.next);
		head.next = newNode;
		size++;
		return item;
	}

	@Override
	public E pop() {
		checkSize(size);
		Node<E> temp = head.next;
		head.next = temp.next;

		E item = temp.item;
		
		temp.item = null;
		temp.next = null;

		size--;
		return item;
	}

	@Override
	public E peek() {
		checkSize(size);
		return head.next.item;
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public int search(E item) {
		if (null == item) {
			int i = 0;
			Node<E> temp = head.next;
			while (temp != null) {
				if (null == temp.item) {
					return i;
				}
				++i;
			}
		} else {
			int i = 0;
			Node<E> temp = head.next;
			while (temp != null) {
				if (item.equals(temp.item)) {
					return i;
				}
				++i;
			}
		}
		return -1;
	}

	@Override
	public void clear() {
		Node<E> temp = head.next;
		while (null != temp) {
			head = temp;
			temp = temp.next;

			head.item = null;
			head.next = null;
		}

		head.item = null;
		head.next = null;

		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	protected E get(int index) {
		return null;
	}

	/**
	 * 
	 * @author jacksen
	 * @date 2016-5-13 下午5:30:00
	 */
	private class Node<E> {
		E item;
		Node<E> next;

		public Node() {
		}

		public Node(E item) {
			this.item = item;
		}

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}

}
