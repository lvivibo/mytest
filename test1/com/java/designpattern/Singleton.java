package com.java.designpattern;

public class Singleton {
	/*private Singleton(){
		System.out.println("xxxx");
	}*/
	private static Singleton instance = null;
	private Singleton(){}
	public static  Singleton  Instance() {
		if(null==instance) {
			instance =  new Singleton();
			System.out.println(instance.hashCode());
			return instance;
			
		}
		System.out.println(instance.hashCode());
		return instance;
	}


}
