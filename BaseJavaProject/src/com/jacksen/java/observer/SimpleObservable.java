package com.jacksen.java.observer;

import java.util.Observable;

/**
 * 被观察者类 继承Observable类，表示这个类可以被观察。
 * 
 * @author Admin
 * 
 */
public class SimpleObservable extends Observable {
	private int data = 0;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		if (this.data != data) {
			this.data = data;
			// 标志状态改变
			setChanged();
			// 通知所有观察者
			notifyObservers("abc");
		}
	}

}
