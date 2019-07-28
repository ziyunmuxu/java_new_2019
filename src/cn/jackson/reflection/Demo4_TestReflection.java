package cn.jackson.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射的简单示例
 * 如果只知道类的名字，怎么去将类加载到虚拟机中；同时去调用这个类的方法和属性；这个过程就叫反射
 * 1、调用Class.forName方法，可以将通过String将类加载到虚拟机中
 * 		其中一定需要注意：类的前面需要加上包名 
 * 2、调用c.newInstance()可以生成类的对象
 * 3、Method类是可以用来获取所有的方法的
 * 4、Method对象通过调用invoke方法，来实现方法的调用
 * 
 * @author 81266
 *
 */

public class Demo4_TestReflection{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//此处注意
		String str = "cn.jackson.reflection.T";
		//通过类名，将类加载到虚拟机中
		Class c = Class.forName(str);
		//获取对象
		Object o = c.newInstance();
		//获取方法
		Method[] methods = c.getMethods();
		for(Method m : methods){
			if(m.getName().equals("mm")){
				//Method方法通过invoke进行调用，此方法为可变参数方法
				m.invoke(o,1);
			}
			if(m.getName().equals("m1")){
				//Method方法通过invoke进行调用，此方法为可变参数方法
				m.invoke(o);
			}
		}
	}
	
	
}

class T {
	static {
		System.out.println("T is loaded");
	}
	
	int i;
	String s;
	
	public void mm(int i){
		this.i = i;
		System.out.println("mm 方法被调用了");
	}
	public void m1(){
		System.out.println("m1 方法被调用了");
	}
	
	public String getS(){
		return s;
	}
}


