package cn.jackson.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadPool就像是线程数量为1的FixedThreadPool
 * 运行的结果：就像一个顺序执行的队列，由于只有一个线程
 * @author ziyunmuxu
 *
 */

public class Demo2_SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i=0; i<5; i++){
			exec.execute(new Demo1_Liftoff());
		}
		exec.shutdown();
	}
}
