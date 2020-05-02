package com.simple.parallelism;

import java.io.IOException;
import com.simple.io.utils.IOUtils;

/**
 * Transforming serial code to parallel code using Threads.
 * 
 * @author Namal Dinesh
 * @see com.simple.io.utils.CopyTask
 *
 *         The two copy operations are initiated through two different threads,
 *         which enables us to perform the operation in parallel. For this we
 *         defined a CopyTask which is a Runnable task, you should pass the
 *         source and the destination to the constructor which are then used to
 *         perform the copy operation once the task execution begins.
 * 
 *         Although the main thread is completed after starting the two other
 *         threads, application won't be terminated until both the threads are
 *         done with the copy.
 *
 */
class CopyTask implements Runnable {
	String sourceFile;
	String destinationFile;

	public CopyTask(String sourceFile, String destinationFile) {
		super();
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
	}

	@Override
	public void run() {
		try {
			IOUtils.copy(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

public class IOStreamCopy {

	public static void main(String[] args) throws IOException {
		String srcFile1 = "a.txt";
		String srcFile2 = "b.txt";
		String destFile1 = "c.txt";
		String destFile2 = "d.txt";

		CopyTask task1 = new CopyTask(srcFile1, destFile1);
		CopyTask task2 = new CopyTask(srcFile2, destFile2);
		Thread threadTask1 = new Thread(task1);
		Thread threadTask2 = new Thread(task2);
		threadTask1.start();
		threadTask2.start();

	}

}
