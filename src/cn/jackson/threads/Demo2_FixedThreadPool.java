package cn.jackson.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool使用有限的线程集来执行所提交的任务
 * @author ziyunmuxu
 *
 */

public class Demo2_FixedThreadPool {
	public static void main(String[] args) {
		//参数为线程的个数
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0; i<5; i++){
			exec.execute(new Demo1_Liftoff());
		}
		exec.shutdown();
	}
}
