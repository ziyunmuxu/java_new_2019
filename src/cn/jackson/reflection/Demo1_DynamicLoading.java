package cn.jackson.reflection;

/**
 * 学习java中ClassLoader的加载机制
 * @author 81266
 *1、运行此类，需要在虚拟机的参数中加入-verbose:class（详细的类信息）
 *2、通过此案例的学习，可以看到类是运行时候进行加载的
 *3、对于静态方法（C类中的方法），加载的时候只会运行一次；但是D中的语句块（dynamic语句块），有点类似于构造方法，每次使用的时候都会被调用
 */


public class Demo1_DynamicLoading {

	public static void main(String[] args) {
		new A();
		System.out.println("--------------------------");
		new B();
		
		new C();
		new C();
		
		new D();
		new D();
		
	}
}

class A{
	
}

class B{
	
}

class C{
	static{
		System.out.println("CCCCCCCCCCCCCCCCCCCCC");
	}
}

class D{
	{
		System.out.println("DDDDDDDDDDDDDDDDDDDDDD");
	}
}




