package com.jacksen.java.concurrent;

import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * CyclicBarrier应用实例
 * 
 * @author Admin
 * 
 */
public class BankWaterService implements Runnable {

	private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);

	private Executor executor = Executors.newFixedThreadPool(4);

	private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

	private void count() {
		for (int i = 0; i < 4; i++) {
			executor.execute(new Runnable() {

				@Override
				public void run() {
					sheetBankWaterCount
							.put(Thread.currentThread().getName(), 1);
					try {
						cyclicBarrier.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	@Override
	public void run() {
		int result = 0;
		for (Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
			result += sheet.getValue();
		}

		System.out.println("result: " + result);
	}

	public static void main(String[] args) {
		BankWaterService service = new BankWaterService();
		service.count();
	}

}
