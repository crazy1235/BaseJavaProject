package com.jacksen.java.adapter;

public class TestAdapter {

	public static void main(String[] args) {
		VoltClassAdapter voltClassAdapter = new VoltClassAdapter();
		int volt220 = voltClassAdapter.getVolt220();
		int volt5 = voltClassAdapter.getVolt5();
		System.out.println("ÀàÊÊÅäÆ÷: " + volt220 + "--" + volt5);

		VoltObjectAdapter voltObjectAdapter = new VoltObjectAdapter(
				new Volt220());
		volt5 = voltObjectAdapter.getVolt5();
		volt220 = voltObjectAdapter.getVolt220();
		System.out.println("¶ÔÏóÊÊÅäÆ÷: " + volt220 + "--" + volt5);
		
		VoltAdapter voltAdapter = new VoltAdapter();
		int volt110 = voltAdapter.getVolt110();
		System.out.println("Ä¬ÈÏÊÊÅäÆ÷: " + volt110);
	}

}
