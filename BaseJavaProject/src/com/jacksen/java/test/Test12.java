package com.jacksen.java.test;

import java.util.concurrent.atomic.AtomicInteger;

public class Test12 {

	public static void main(String[] args) {
		/*AddCountThread countThread = new AddCountThread();
		Thread t1 = new Thread(countThread);
		t1.start();
		Thread t2 = new Thread(countThread);
		t2.start();
		Thread t3 = new Thread(countThread);
		t3.start();
		Thread t4 = new Thread(countThread);
		t4.start();*/
		
		
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread);
		t1.start();
		Thread t2 = new Thread(myThread);
		t2.start();
		Thread t3 = new Thread(myThread);
		t3.start();
		Thread t4 = new Thread(myThread);
		t4.start();
	}

}

class AddCountThread extends Thread {
	private AtomicInteger count = new AtomicInteger(0);

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " ## "
					+ count.incrementAndGet());
		}
	}
}


class MyThread extends Thread{
	volatile int count;
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			count ++;
			System.out.println(Thread.currentThread().getName() + " ## "
					+ count);
		}
	}
}