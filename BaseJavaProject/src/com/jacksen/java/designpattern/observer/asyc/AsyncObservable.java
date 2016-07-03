package com.jacksen.java.designpattern.observer.asyc;

import java.util.Iterator;
import java.util.Vector;

/**
 * 异步观察者模式的被观察者对象
 * 
 * @author Admin
 * 
 */
public class AsyncObservable {

	private boolean changed = false;
	private Vector<Wrapper> obs;

	public AsyncObservable() {
		obs = new Vector<>();
	}

	/**
	 * 
	 * @param wrapper
	 */
	public synchronized void addObserver(AsyncObserver o) {
		if (o == null)
			throw new NullPointerException();
		Wrapper wrapper = new Wrapper(o);
		if (!obs.contains(wrapper)) {
			obs.addElement(wrapper);
		}
	}

	/**
     * 
     */
	public synchronized void deleteObserver(AsyncObserver o) {
		Iterator<Wrapper> iterator = obs.iterator();
		while (iterator.hasNext()) {
			Wrapper wrapper = iterator.next();
			if (wrapper.getAsyncObserver() == o) {
				obs.remove(wrapper);
				break;
			}
		}
	}

	/**
     * 
     */
	public void notifyObservers() {
		notifyObservers(null);
	}

	/**
     * 
     */
	public void notifyObservers(Object arg) {

		Object[] arrLocal;

		synchronized (this) {

			if (!changed)
				return;
			arrLocal = obs.toArray();
			clearChanged();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--)
			((Wrapper) arrLocal[i]).update(this, arg);
	}

	/**
     * 
     */
	public synchronized void deleteObservers() {
		obs.removeAllElements();
	}

	/**
     * 
     */
	protected synchronized void setChanged() {
		changed = true;
	}

	/**
     * 
     */
	protected synchronized void clearChanged() {
		changed = false;
	}

	/**
     * 
     */
	public synchronized boolean hasChanged() {
		return changed;
	}

	/**
     * 
     */
	public synchronized int countObservers() {
		return obs.size();
	}

}
