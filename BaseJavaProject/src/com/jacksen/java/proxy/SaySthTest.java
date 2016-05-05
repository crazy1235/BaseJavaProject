package com.jacksen.java.proxy;

import java.lang.reflect.Proxy;

public class SaySthTest {
	
	public static void main(String[] args) {
		MyInter inter = new Child();
		SaySthHandler handler = new SaySthHandler(inter);
		MyInter in = (MyInter) Proxy.newProxyInstance(inter.getClass().getClassLoader(), inter.getClass().getInterfaces(), handler);
		in.saySth();
	}

}
