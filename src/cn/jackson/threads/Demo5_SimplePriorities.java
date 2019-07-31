package cn.jackson.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程优先级
 * 通过getPriotity()可以获取当前线程的优先级；setPriority()可以设置当前线程的优先级
 * 可以移植的优先级：MIN_PRIORITY、NORM_PRIORITY、MAX_PRIORITY
 * 本测试案例显示不明显：预期结果应该是thread6，全部跑完后，剩下的5个线程才会跑
 * @author ziyunmuxu
 *
 */

public class Demo5_SimplePriorities implements Runnable {
	private int countDown = 5;
	//volatile申明该变量是可变的（可以让多个线程共享），避免编译器优化
	private volatile double d;
	private int priority;
	
	public Demo5_SimplePriorities(int priority) {
		this.priority = priority;
	}
	public String toString(){
		return Thread.currentThread() + ":" + countDown;
	}
		
	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		while(true){
			//浮点数运行，开销比较大，让线程调度器才会选择
			for(int i=1; i<10000; i++){
				d += (Math.PI + Math.E) /(double) i;
				if(i % 1000 == 0){
					Thread.yield();
				}
			}
			System.out.println(this);
			if(--countDown == 0) {
				return;
			}
		}	
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0; i<5; i++){
			exec.execute(new Demo5_SimplePriorities(Thread.MIN_PRIORITY));
		}
		exec.execute(new Demo5_SimplePriorities(Thread.MAX_PRIORITY));
		exec.shutdown();
	}
}
