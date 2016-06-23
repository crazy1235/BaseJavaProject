package com.jacksen.java.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {

	private static final int MAX = 10;

	public static void main(String[] args) {
		System.out.println("start");
		try {
			fixedThreadPool(3);
			
//			newCachedThreadPool();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("end");
	}

	private static void fixedThreadPool(int size) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(size);
		for (int i = 0; i < MAX; i++) {
			Future<Integer> future = executorService.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					System.out.println("当前执行线程: "
							+ Thread.currentThread().getName());
					return fibc(40);
				}
			});
			System.out.println("第" + i + "次计算的结果: " + future.get());
		}
	}
	
	private static void newCachedThreadPool() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < MAX; i++) {
			executorService.submit(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("当前执行线程: " + Thread.currentThread().getName() + "--结果 ：" + fibc(10));
				}
			});
		}
	}

	private static int fibc(int num) {
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		return fibc(num - 1) + fibc(num - 2);
	}
}
