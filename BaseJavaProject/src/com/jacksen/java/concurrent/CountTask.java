package com.jacksen.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3362723346820901185L;

	private static final int THRESHOLD = 2;
	private int start;
	private int end;

	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;

		boolean canCompute = (end - start) <= THRESHOLD;

		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;
			CountTask leftTask = new CountTask(start, middle);
			CountTask rightTask = new CountTask(middle + 1, end);
			// 执行子任务
			leftTask.fork();
			rightTask.fork();

			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			//
			sum = leftResult + rightResult;
		}
		return sum;
	}

	public static void main(String[] args) {

		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(1, 4000);

		long startTime = System.currentTimeMillis();
		long endTime;
		Future<Integer> result = forkJoinPool.submit(task);
		try {
			System.out.println(result.get());

			endTime = System.currentTimeMillis();

			System.out.println(endTime - startTime);

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		int sum = 0;
		startTime = System.currentTimeMillis();
		for (int i = 1; i <= 4000; i++) {
			sum += i;
		}
		endTime = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println(endTime - startTime);

	}

}
