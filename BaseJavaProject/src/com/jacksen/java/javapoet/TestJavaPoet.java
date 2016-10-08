package com.jacksen.java.javapoet;

import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

public class TestJavaPoet {

	public static void main(String[] args) {

		MethodSpec mainMethod = MethodSpec
				.methodBuilder("main")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.addParameter(String[].class, "args")
				.addStatement("$T.out.println($S)", System.class,
						"Hello, World!")
				.returns(TypeName.VOID).build();

		TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
				.addModifiers(Modifier.PUBLIC)
				.addMethod(mainMethod)
				.build();

		File file = new File("E:\\JAVA\\BaseJavaProject\\BaseJavaProject\\src");
		
		JavaFile javaFile = JavaFile.builder("com.jacksen.java.javapoet", helloWorld)
				.addFileComment("This is a auto generate java file.").build();
		try {
//			javaFile.writeTo(file);
			javaFile.writeTo(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
