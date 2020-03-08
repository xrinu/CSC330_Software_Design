package edu.cuny.csi.csc330.scratch;

public class Overridder {

	public Overridder() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BaseClass.someMethod();
		SubClass subClass = new SubClass();
		subClass.someMethod();
	}

}
