package com.simple.parallelism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService
 * 
 * @author Namal Dinesh
 *
 *         With the MultiTask App use seperate threads.but there is a critical
 *         point to consider here, Thread creation is a costly activity as it
 *         includes creating a separate execution context, stack etc.. Hence we
 *         should refrain from creating too many threads. And also creating a
 *         thread for each task is not a good idea, instead we can create a pool
 *         of threads and effectively utilise them in executing all the task.
 *         This could be achieved using ExecutorService in Java. Use the execute
 *         method of the ExecutorService to submit a Runnable task, if a thread
 *         is available in the pool then it assigns this task to the thread
 *         otherwise the task is added to the blocking queue and is kept till a
 *         thread is available.
 * 
 *         Creating a ThreadPool Below statement creates a thread pool of size
 *         5.
 * 
 *         ExecutorService executor = Executors.newFixedThreadPool(5);
 * 
 *         Submitting a Runnable task - We can submit a task for execution using
 *         the execute method.
 * 
 *         executor.execute( runnableTaskInstance );
 * 
 *         e.g.
 * 
 *         executor.execute(new Task1());
 * 
 * 
 */

public class MultiTaskAppWithExecutorService {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.execute(new Task1());
		executor.execute(new Task2());
		executor.execute(new Task3());
	}
}
