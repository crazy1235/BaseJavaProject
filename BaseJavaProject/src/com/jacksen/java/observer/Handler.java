package com.jacksen.java.observer;

import java.util.Observer;

class Invoker {

	private Observer o;
	private Handler handler;

	public Invoker(Observer o) {
		this.o = o;

	}

	public class Handler extends Thread {

		public Handler() {
			handler = this;
		}

		@Override
		public void run() {
		}

	}

}
