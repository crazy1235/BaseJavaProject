package com.jacksen.java.datastructure.list;

/**
 * 双向链表
 * 
 * @author jacksen
 * @date 2016-5-11 下午2:27:12
 */
public class LinkedLinearList<E> extends AbstractLinearList<E> implements
		LinearList<E> {

	private Node<E> firstNode;

	private Node<E> lastNode;

	public LinkedLinearList() {

	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {

	}

	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public E set(int index, E e) {
		return null;
	}

	@Override
	public int getIndex(E e) {
		return 0;
	}

	@Override
	public boolean contains(E e) {
		return false;
	}

	@Override
	public void add(E e) {
		addLast(e);
	}

	@Override
	public void add(int index, E e) {

	}

	public void addFirst(E e) {
		Node<E> node = new Node<E>(e, null, null);
		node.next = firstNode;
	}

	public void addLast(E e) {

	}

	@Override
	public E remove(int index) {
		return null;
	}

	@Override
	public boolean remove(E e) {
		return false;
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
