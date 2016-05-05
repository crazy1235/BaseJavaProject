package com.jacksen.java.anno;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

/**
 * 注解处理器
 * @author Admin
 *
 */
public class MyProcessor extends AbstractProcessor {

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		// TODO Auto-generated method stub
		super.init(processingEnv);
	}
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		
		return false;
	}
	
	/**
	 * 返回需要处理的注解的类的getCanonicalName集合
	 */
	@Override
	public Set<String> getSupportedAnnotationTypes() {
		// TODO Auto-generated method stub
		return super.getSupportedAnnotationTypes();
	}

	/**
	 * 返回SourceVersion.latestSupported()
	 */
	@Override
	public SourceVersion getSupportedSourceVersion() {
		// TODO Auto-generated method stub
		return super.getSupportedSourceVersion();
	}
}
