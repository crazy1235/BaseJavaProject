package com.jacksen.java.observer;

import java.util.Observable;

/**
 * ���۲����� �̳�Observable�࣬��ʾ�������Ա��۲졣
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
			// ��־״̬�ı�
			setChanged();
			// ֪ͨ���й۲���
			notifyObservers("abc");
		}
	}

}
