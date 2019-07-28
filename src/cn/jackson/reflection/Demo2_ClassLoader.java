package cn.jackson.reflection;

/**
 * 学习JDK中ClassLoader的分类
 * 1、bootstrap class loader
 * 		机器语言实现，load jdk的核心类
 * 2、extension class loader
 * 		从jre/lib/ext中loader
 * 3、application class loader
 * 		load user-define classes
 * 4、other class loaders
 * 		SecureClassLoader/URLClassLoader
 * 
 * 整个流程：系统先将bootstrap ClassLoader进来，然后bootstrap再Loader其余的ClassLoader，其余的ClassLoader loader所有的类
 * @author 81266
 *
 */

public class Demo2_ClassLoader {
	public static void main(String[] args) {
		//属于bootstrap，只能打印出null
		System.out.println(String.class.getClassLoader());
		
		//ExtClassLoader,属于jre中的类
		System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
	
		//AppClassLoader,加载自身应用的类
		System.out.println(Demo2_ClassLoader.class.getClassLoader().getClass().getName());
		//AppClassLoader也可以通过系统的ClassLoader获取
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
	}
	
	
	
}
