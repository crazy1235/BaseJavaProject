package com.jacksen.java.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
	
	public static void main(String[] args) {
		/*ISubject inter = new TargetSubject();
		DynamicProxyHandler handler = new DynamicProxyHandler(inter);
		ISubject in = (ISubject) Proxy.newProxyInstance(inter.getClass().getClassLoader(), inter.getClass().getInterfaces(), handler);
		in.saySth();*/
		
		ISubject subject = new TargetSubject();
		ISubject proxySubject =  (ISubject) new CglibFactory(subject).getProxyInstance();
		proxySubject.saySth();
		
	}

}
