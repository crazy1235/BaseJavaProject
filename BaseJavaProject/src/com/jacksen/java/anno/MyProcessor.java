package com.jacksen.java.anno;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

/**
 * ע�⴦����
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
	 * ������Ҫ�����ע������getCanonicalName����
	 */
	@Override
	public Set<String> getSupportedAnnotationTypes() {
		// TODO Auto-generated method stub
		return super.getSupportedAnnotationTypes();
	}

	/**
	 * ����SourceVersion.latestSupported()
	 */
	@Override
	public SourceVersion getSupportedSourceVersion() {
		// TODO Auto-generated method stub
		return super.getSupportedSourceVersion();
	}
}
