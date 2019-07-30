package cn.jackson.threads;

/**
 * 线程调用方式：使用Thread进行调用，初始化的时候，需要使用Runnable对象
 * @author ziyunmuxu
 *
 */

public class Demo1_BasicThreads {
	public static void main(String[] args) {
		Thread t = new Thread(new Demo1_Liftoff());
		//Thread调用线程的方式：start方法，其中可以得到main的进程和Thread t是同时执行（"Waiting for Liftoff"先打印）
		t.start();
		System.out.println("Waiting for Liftoff");
	}
}
