package com.jacksen.java.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPool {
	public static void main(String[] args) {
		scheduledThreadPool();
	}

	private static void scheduledThreadPool() {
		// 创建定时执行的线程池
		ScheduledExecutorService executorService = Executors
				.newScheduledThreadPool(3);
		executorService.schedule(new Runnable() {

			@Override
			public void run() {
				System.out.println("当前线程: " + Thread.currentThread().getName()
						+ "--运算结果--" + fibc(20));
			}
		}, 10, TimeUnit.SECONDS);

		executorService.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				System.out.println("当前线程: " + Thread.currentThread().getName()
						+ "--运算结果" + fibc(30));
			}
		}, 5, 1, TimeUnit.SECONDS);
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
