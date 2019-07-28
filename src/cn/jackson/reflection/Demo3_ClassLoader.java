package cn.jackson.reflection;

/**
 * JDK中ClassLoader的层次关系（注意不是继承关系）
 * bootstrap class loader <---- ext class loader <--- app class loader
 * 		其中app class loader的对象中有一个parent指针指向 ext；照样ext有指针指向bootstrap
 * class loader在load class的时候首先找上一层loader是不是loader过了，如果已经loader，就不会再次loader
 * 		这样可以保证安全性，自己写的Stringclass永远没有机会执行
 * @author 81266
 *
 */

public class Demo3_ClassLoader {
	
	public static void main(String[] args) {
		ClassLoader c = Demo3_ClassLoader.class.getClassLoader();
		
		while(c != null){
			System.out.println(c.getClass().getName());
			c = c.getParent();
		}
	}
	
}
