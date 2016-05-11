package com.jacksen.java.datastructure;



/**
 * 线性表
 * 
 * @author jacksen
 * @date 2016-5-11 上午11:13:02
 */
public interface LinearList<E> {
	
	boolean isEmpty();
	
	void clear();
	
	E get(int index);
	
	E set(int index, E e);

	int getIndex(E e);
	
	boolean contains(E e);
	
	void add(E e);
	
	void add(int index, E e);
	
	E remove(int index);
	
	boolean remove(E e);
	
	int size();
	
}
