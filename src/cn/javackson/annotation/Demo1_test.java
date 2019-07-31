package cn.javackson.annotation;

public class Demo1_test {
	
	@FieldAnnotation
	private String name;
	
	@FieldAnnotation(description="hahahahaha")
	private String description;

	@MethodAnnotation(value="testtest")
	public String getString(){
		return "okokok";
	}
}
