package com.jacksen.java.adapter;

/**
 * 面向的类适配器
 * 
 * @author Admin
 * 
 */
public class VoltClassAdapter extends Volt220 implements Volt5Inter{

	@Override
	public int getVolt5() {
		return 5;
	}

	@Override
	public int getVolt250() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVolt110() {
		// TODO Auto-generated method stub
		return 0;
	}

}
