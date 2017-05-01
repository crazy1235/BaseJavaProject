package com.jacksen.java.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test13 {
	
	public static void main(String[] args) {
		MyService myService = new MyService();
		ThreadA threadA = new ThreadA(myService);
		threadA.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		myService.signal();
	
	}
	
	
	
}

class ThreadA extends Thread{
	
	private MyService myService;
	
	public ThreadA(MyService myService){
		this.myService = myService;
	}
	
	@Override
	public void run() {
		myService.await();
	}
}


class MyService{
	private Lock lock= new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void await(){
		try{
			lock.lock();
			System.out.println("await time is: " + System.currentTimeMillis());
			condition.await();
			System.out.println("await end time is: " + System.currentTimeMillis());
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{
			System.out.println("await -- finally");
			lock.unlock();
		}
	}
	
	public void signal(){
		try{
			lock.lock();
			System.out.println("signal time is: " + System.currentTimeMillis());
			condition.signal();
		}finally{
			System.out.println("signal -- finally");
			lock.unlock();
		}
	}
}
