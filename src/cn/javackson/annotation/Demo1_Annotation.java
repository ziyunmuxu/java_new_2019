package cn.javackson.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 注解的基本用法：@Target（ElementType.TYPE、METHOD、FIELD)三个作用域的示例
 * 1、注解的定义，“int age() default 18;”，其中可以认为age是里面的一个成员变量，相当于注释
 * 2、元注解分为4类，TYPE：针对类；METHOD针对方法；FIELD针对属性
 * 
 * 
 * @author ziyunmuxu
 *
 */

@ClassAnnotation(age=25)
public class Demo1_Annotation {
	
	/**
	 * Class 注解测试
	 * 获取类的注解，然后调用注解终端中的方法，返回的是age的值
	 * @param c
	 */
	public static void test1(Class<?> c){
		ClassAnnotation ca = (ClassAnnotation)c.getAnnotation(ClassAnnotation.class);
		if(ca == null){
			System.out.println("Unknown");
		}else{
			System.out.println("age:" + ca.age());
		}
	}
	
	/**
	 * Method注解测试
	 * 获取Demo1_test中使用注解的方法，返回返回注解的值
	 * @param c
	 */
	public static void test2(Class<?> c){
		Method[] method = c.getDeclaredMethods();
		for(Method me:method){
			MethodAnnotation mothod = me.getAnnotation(MethodAnnotation.class);
			if(method == null){
				System.out.println("Unknown");
			}else{
				System.out.println(mothod.name());
				System.out.println(mothod.value());
			}
		}
		
	}
	
	public static void test3(Class<?> c){
		Field[] field = c.getDeclaredFields();
		System.out.println("备注FieldAnnotation注解的属性");
		for(Field f :field){
			System.out.println("-----------------");
			System.out.println("属性名称：" + f.getName());
			desFieldInfo(f);
		}
	}
	
	private static void desFieldInfo(Field field){
		FieldAnnotation fa = field.getAnnotation(FieldAnnotation.class);
		if(fa == null){
			System.out.println("Unknown!!");
		}else{
			System.out.println(fa.name());
			System.out.println(fa.description());
		}
	}
	
	public static void main(String[] args) {
		Demo1_Annotation.test1(Demo1_Annotation.class);
		System.out.println("=========================================");
		Demo1_Annotation.test2(Demo1_test.class);
		System.out.println("=========================================");
		Demo1_Annotation.test3(Demo1_test.class);
	}
}
