package cn.jackson.threads;

/**
 * 多线程并发案例一：发射倒计时
 * @author ziyunmuxu
 *
 */


public class Demo1_Liftoff implements Runnable {

	protected int countDown = 10;
	private static int taskCount = 0;
	//使用final 标志id，可以作为每个线程的id
	private final int id = taskCount++;
	
	public Demo1_Liftoff(){}
	public Demo1_Liftoff(int countDown){
		this.countDown = countDown;
	}
	public String status(){
		return "#" + id + "(" + (countDown>0 ? countDown : "Liftoff!")+")";
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(countDown-- > 0){
			System.out.println(status());
			
			//对线程调度的一种建议（JAVA线程机制的一部分，可以将CPU从一个线程转移给另外一个线程），yield(让步)
			Thread.yield();
		}
	}
	
}
