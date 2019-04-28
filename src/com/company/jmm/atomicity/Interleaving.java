package com.company.jmm.atomicity;

/**
 * Последовательность работы потоков не гарантируется!
 */
public class Interleaving {

	/**
	 * Этот метод будут дергать потоки
	 */
	public void show() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - Number: " + i);
		}
	}

	public static void main(String[] args) {
		final Interleaving main = new Interleaving();
		
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				main.show();
			}
		};
		
		new Thread(runner, "Thread 1").start();
		new Thread(runner, "Thread 2").start();
	}
}
