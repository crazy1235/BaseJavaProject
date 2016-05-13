package com.jacksen.java.datastructure.queue;

/**
 * 队列接口
 * 
 * @author jacksen
 * @date 2016-5-13 下午6:44:48
 */
public interface QueueInter<E> {

	/**
	 * 移除并返回队列头部元素
	 * 
	 * @return
	 */
	E poll();

	/**
	 * 返回队列头部元素
	 * 
	 * @return
	 */
	E peek();

	/**
	 * 在队尾添加一个元素
	 * 
	 * @param e
	 */
	void add(E e);

	/**
	 * 清空队列
	 */
	void clear();

	/**
	 * 判断队列是否为空
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 返回队列长度
	 * 
	 * @return
	 */
	int length();

}
