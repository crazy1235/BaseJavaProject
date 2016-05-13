package com.jacksen.java.datastructure.stack;

/**
 * 
 * @author jacksen
 * @date 2016-5-13 下午5:26:44
 * @param <E>
 */
public interface StackInter<E> {

	E push(E item);

	E pop();

	E peek();

	boolean empty();

	int search(E item);

	void clear();

	int size();
}
