package cn.jackson.threads;

/**
 * 同时驱动多个线程进行调用
 * @author ziyunmuxu
 *
 */

public class Demo1_MoreBasicThreads {
	public static void main(String[] args) {
		for(int i=0; i<5; i++){
			new Thread(new Demo1_Liftoff()).start();
		}
		System.out.println("Waiting for Liftoff");
	}
}
