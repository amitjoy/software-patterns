package com.amitinside.practice;

public class Practice {
	
	public static void main(String... args) {
		A a = new A();
		A b = new B();
		System.out.println(a.i + "" + b.i);
		System.out.println(a.getNo() + "" + b.getNo());
		System.out.println(a.print() + "" + b.print());
	}
	

}
class A {
	public static int i = 5;
	
	public static int getNo() {
		return i;
	}
	
	public String print() {
		return ("Hello");
	}
}

class B extends A {
	public static int i = 10;
	
	public static int getNo() {
		return i;
	}
	
	public String print() {
		return ("Danke");
	}
}
