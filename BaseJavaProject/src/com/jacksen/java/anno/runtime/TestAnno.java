package com.jacksen.java.anno.runtime;

import java.lang.reflect.Method;

public class TestAnno {

	public static void main(String[] args) {
//		Person person = new Person();
		Class<?> clazz = Person.class;
//		System.out.println(clazz.getDeclaredMethods().length);
		try {
			Method method = clazz.getDeclaredMethod("getName");
			if (method.isAnnotationPresent(MyAnno.class)) {
//				String methodName = method.getName();
//				System.out.println(methodName);
				
				
				boolean isAnnotated = method.isAnnotationPresent(MyAnno.class);//判断是否被某个Annotation修饰
				method.getAnnotations();//得到所有的Annotation
				MyAnno myAnno = method.getAnnotation(MyAnno.class);
				System.out.println(myAnno.setName());
				
			}else{
				System.out.println("the method has not been annotated.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Person {
	private String name;

	@MyAnno(setName = "haha")
	public String getName() {
		return name;
	}
}
