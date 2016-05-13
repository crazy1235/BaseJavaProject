package com.jacksen.java.datastructure.queue;

import java.util.NoSuchElementException;

/**
 * 链表结构的【队列】
 * 
 * @author jacksen
 * 
 * @param <E>
 */
public class LinkedQueue<E> implements QueueInter<E> {

	/**
	 * 头节点<br />
	 * 注意：不是对头,头节点的下一个结点是对头
	 */
	private Node<E> frontNode;

	/**
	 * 指向队尾结点
	 */
	private Node<E> rearNode;

	private int size = 0;

	public LinkedQueue() {
		frontNode = new Node<>();
		rearNode = frontNode;// 队列为空时，队尾结点指向头节点
	}

	@Override
	public E poll() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Node<E> temp = frontNode.next;
		E e = temp.item;

		frontNode.next = temp.next;

		temp.item = null;
		temp.next = null;// for GC

		size--;
		return e;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return frontNode.next.item;
	}

	@Override
	public void add(E e) {
		Node<E> newNode = new Node<>(e);
		rearNode.next = newNode;
		rearNode = newNode;
		
		//
		size++;
	}

	@Override
	public void clear() {
		Node<E> temp = frontNode.next;
		while (temp != null) {
			// for GC
			frontNode.item = null;
			frontNode.next = null;

			frontNode = temp;
			temp = temp.next;
		}

		frontNode.item = null;
		frontNode.next = null;

		rearNode.item = null;
		rearNode.next = null;

		rearNode = frontNode;
	}

	/**
	 * 个人觉得判空的方法有多种： <br />
	 * 1. 判断头结点的next是否为null <br />
	 * 2. 判断队尾结点和头结点是否指向通过一个地址 <br />
	 * 3. 判断长度是否为0
	 */
	@Override
	public boolean isEmpty() {
		return frontNode.next == null;
	}

	@Override
	public int length() {
		return size;
	}

	private class Node<E> {
		E item;
		Node<E> next;

		public Node() {
		}

		public Node(E item) {
			this.item = item;
		}

		public Node(E item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

}
