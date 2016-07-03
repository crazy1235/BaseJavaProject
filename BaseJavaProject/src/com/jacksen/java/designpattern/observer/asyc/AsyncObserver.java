package com.jacksen.java.designpattern.observer.asyc;

/**
 * 异步观察模式的观察者接口
 * 
 * @author Admin
 * 
 */
public interface AsyncObserver {

	/**
	 * 
	 * @param o
	 * @param arg
	 */
	void update(AsyncObservable o, Object arg);

}
