package com.jacksen.java.designpattern.builder;

public class Test {

	public static void main(String[] args) {
		ManBuilder manBuilder = new ManBuilder();
		Nuwa nuwa = new Nuwa(manBuilder);
		nuwa.setParts("head", "leftArm", "body", "rightLeg");
		nuwa.createPerson();
	
		System.out.println("-----------");
		
		WomanBuilder womanBuilder = new WomanBuilder();
		nuwa = new Nuwa(womanBuilder);
		nuwa.setParts("head", "leftArm", "body", "rightLeg", "leftLeg", "rightArm");
		nuwa.createPerson();
	}

}
