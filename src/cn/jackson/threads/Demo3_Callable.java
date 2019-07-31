package cn.jackson.threads;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Runnable是执行工作的独立任务，不返回任何值；如果你希望任务在完成时能够返回一个值；需要实现Callable接口
 * Callable接口使用ExecutorService.submit()方法调用；调用会返回Future对象（可以认为是异步处理对象）
 * Future对象可以使用isDone方法来检查任务是否完成；get()方法将阻塞知道结果准备就绪
 * @author ziyunmuxu
 *
 */

class TaskWithResult implements Callable<String>{
	private int id;
	
	public TaskWithResult(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	
	@Override
	public String call() {
		// TODO Auto-generated method stub
		return "result of TaskWithResult " + id;
	}
	
}


public class Demo3_Callable {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for(int i=0; i<10; i++){
			//submit方法可以产生Future对象
			results.add(exec.submit(new TaskWithResult(i)));
		}
		for(Future<String> fs : results){
			try{
				//get()可以
				System.out.println(fs.get());
			}catch(InterruptedException e){
				System.out.println(e);
				return;
			}catch (ExecutionException e) {
				System.out.println(e);
			}finally {
				exec.shutdown();
			}
		}
	}
}
