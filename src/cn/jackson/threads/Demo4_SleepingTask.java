package cn.jackson.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 通过TimeUnit的sleep()方法让线程休眠，从而影响任务行为
 * 运行结果：每个线程进行countDown--后，会切换到另外的线程
 * @author ziyunmuxu
 *
 */

public class Demo4_SleepingTask extends Demo1_Liftoff{
	public void run(){
		try{
			while(countDown-- >0){
				System.out.println(status());
				//Old-style
				//Thread.sleep(100);
				//Java SE5/6-style
				TimeUnit.MILLISECONDS.sleep(100);
			}
		}catch(InterruptedException e){
			//异常不能跨线程传播回main，所以必须要在本地任务内部处理
			System.err.println("Interrupted");
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i=0; i<5; i++){
			exec.execute(new Demo4_SleepingTask());
		}
		
		exec.shutdown();
	}
}
