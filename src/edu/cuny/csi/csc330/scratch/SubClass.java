package edu.cuny.csi.csc330.scratch;

public class SubClass extends BaseClass {
	
	/*
	public static void someMethod() {
		System.out.println("in SubClass.someMethod()");
	}
	*/


	public SubClass() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BaseClass.someMethod();
		SubClass subClass = new SubClass();
		subClass.someMethod();

	}

}
