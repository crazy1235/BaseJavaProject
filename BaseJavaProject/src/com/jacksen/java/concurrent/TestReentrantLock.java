package com.jacksen.java.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

	public static void main(String[] args) {
		TestReentrantLock testReentrantLock = new TestReentrantLock();
		MyService myService = testReentrantLock.new MyService();

		for (int i = 0; i < 4; i++) {
			testReentrantLock.new MyThread(myService).start();
		}
	}

	public class MyService {

		private Lock lock = new ReentrantLock();

		public void testMethod() {
			lock.lock();
			for (int i = 0; i < 5; i++) {
				System.out.println("ThreadName: "
						+ Thread.currentThread().getName() + " " + i);
			}
			lock.unlock();
		}
	}

	public class MyThread extends Thread {
		private MyService myService;

		public MyThread(MyService service) {
			this.myService = service;
		}

		@Override
		public void run() {
			myService.testMethod();
		}
	}
}
