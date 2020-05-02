package com.simple.parallelism;
/**
 * 
 * @author Namal
 *
 */

/**
 * True Parallelism vs Logical Parallelism 
 * =======================================
 * True parallelism is achieved by
 * assigning tasks to individual CPUs or Processors. This is possible through
 * multicore processors or executing the tasks using multiple CPUs.
 * 
 * If there is one CPU and you want to perform multiple tasks in parallel, then
 * CPU will be shared across those tasks for some stipulated time interval,
 * which stands for interleaved execution, and this way of executing the tasks
 * is known as logical parallelism or psuedo parallelism.
 * 
 * In case of logical parallelism, lets assume there are two tasks T1 and T2,
 * when executed in parallel and using one CPU, CPU is switched between T1 and
 * T2 i.e. CPU executed T1 for some stipulated time interval and then switched
 * to T2. Once T2's time slice is completed then it is switched back to T1 and
 * starts from where it stops.
 * 
 * 
 * 
 * In the below example Task is a Thread(explained later), and run is the entry
 * point of the thread execution where it starts printing 1500 T's. main() runs
 * in Thread i.e. the Main thread which is started by the JVM.
 * 
 * Note In the main method we are not calling doTask directly, instead we are
 * using the start() method of the Thread class, which runs the Task using a
 * separate Thread.
 * 
 * Thread - A thread is a light weight process, it is given its own context and
 * stack etc. for preserving the state. Thread state enables the CPU to switch
 * back and continue from where it stopped.
 * 
 * Creating Threads in Java - When you launch Java application, JVM internally
 * creates few threads, e.g. Main thread for getting started with main() and
 * GarbageCollector for performing garbage collection and few other threads
 * which are need for execution of a Java application.
 * 
 * You can create a thread and execute the tasks with in the application, this
 * enables you to perform parallel activities with in the application.
 * 
 * There are two approaches,
 * 
 * 1) Extending the Thread class and performing the task. This is not a
 * preferred approach because you are not extending the Thread functionality,
 * instead you are using the Thread to execute a task, hence you should prefer
 * the second approach.
 * 
 * 2) Implementing the Runnable interface and then submitting this task for
 * execution. Similarly there is a Callable interface(explained later) as well.
 * 
 * 
 * 
 * run() method -
 * 
 * Once you choose your approach, you can consider the run() method as the entry
 * point for thread execution. To simplify just think like main() for a program,
 * run() for a thread.
 * 
 * start() method -
 * 
 * Execution of the thread should be initiated using the start() method of the
 * Thread class. This submits the thread for execution. This takes the
 * associated thread to ready state, this doesn't mean it is started
 * immediately. i.e. in simple terms, when you call the start() method, it marks
 * the thread as ready for execution and waits for the CPU turn.
 */
public class MultiTaskApp {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Task1());
		Thread t2 = new Thread(new Task2());
		Thread t3 = new Thread(new Task3());

		t1.start();
		t2.start();
		t3.start();
	}

}

interface Task {
	public void doTask();
}

class Task1 extends Thread implements Task {
	public void run() {
		doTask();

	}

	@Override
	public void doTask() {
		for (int i = 1; i <= 1500; i++) {
			System.out.println("TASK 1 TASK 1 TASK 1 TASK 1 ");
		}
	}
}

class Task2 extends Thread implements Task {

	@Override
	public void doTask() {
		for (int i = 1; i <= 1500; i++) {
			System.out.println("TASK 2 TASK 2 TASK 2 TASK 2 ");
		}
	}

	public void run() {
		doTask();

	}

}

class Task3 implements Runnable, Task {
	@Override
	public void doTask() {
		for (int i = 1; i <= 1500; i++) {
			System.out.println("TASK 3 TASK 3 TASK 3 TASK 3 ");
		}
	}

	public void run() {
		doTask();

	}
}
