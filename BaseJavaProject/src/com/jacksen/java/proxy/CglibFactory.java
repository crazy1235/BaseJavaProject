package com.jacksen.java.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibFactory implements MethodInterceptor {

	private Object object;

	public CglibFactory(Object object) {
		this.object = object;
	}

	/**
	 * 创建代理对象
	 * 
	 * @return
	 */
	public Object getProxyInstance() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(object.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {

		System.out.println("before.....");

		Object result = arg3.invoke(arg0, arg2);

		System.out.println("end......");

		return result;
	}

}
