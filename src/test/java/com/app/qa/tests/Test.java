package com.app.qa.tests;

public class Test {

	public static void main(String[] args) {
		System.out.println("main method 1");
		
		main("anu");
		main(3);
		main(3,5);

	}
	
	public static void main(String args) {
		System.out.println("main method 2");

	}
	
	public static void main(int a) {
		System.out.println("main method 3");

	}
	
	public static void main(int a,int b) {
		System.out.println("main method 4");

	}

}
