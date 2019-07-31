package cn.jackson.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用Executor执行器管理Thread对象，从而避免Demo1_MoreBasicThreads中显式的创建Thread对象；
 * @author ziyunmuxu
 *
 */

public class Demo2_CachedThreadPool {
	public static void main(String[] args) {
		//调用的是Executors的静态方法
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0; i<5; i++){
			exec.execute(new Demo1_Liftoff());
		}
		//防止新的任务被提交给这个Executor
		exec.shutdown();
	}
}
