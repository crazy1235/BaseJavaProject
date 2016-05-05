package com.jacksen.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SaySthHandler implements InvocationHandler{

	private Object object;
	
	public SaySthHandler(Object object){
		this.object = object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		
		doSthBefore();
		
		result = method.invoke(object, args);
		
		doSthAfter();
		
		return result;
	}
	
	
	/**
	 * 
	 */
	private void doSthBefore(){
		System.out.println("doSthBefore");
	}
	
	/**
	 * 
	 */
	private void doSthAfter(){
		System.out.println("doSthAfter");
	}

}
