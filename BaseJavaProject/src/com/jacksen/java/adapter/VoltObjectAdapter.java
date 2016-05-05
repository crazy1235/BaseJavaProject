package com.jacksen.java.adapter;

/**
 * 面向对象的适配器
 * 
 * @author Admin
 * 
 */
public class VoltObjectAdapter implements Volt5Inter {

	private Volt220 volt220;

	public VoltObjectAdapter(Volt220 volt220) {
		super();
		this.volt220 = volt220;
	}
	
	@Override
	public int getVolt220() {
		return volt220.getVolt220();
	}

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
