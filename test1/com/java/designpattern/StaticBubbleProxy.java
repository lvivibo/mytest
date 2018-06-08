package com.java.designpattern;

public class StaticBubbleProxy implements Sorter{
	
	private Sorter tartget = null;
	
	StaticBubbleProxy(Sorter tartget) {
		this.tartget = tartget;
	}
	

	

	@Override
	public void sort(int[] a) {
		System.out.println("do something before sort method");
		tartget.sort(a);
		System.out.println("do something after sort method");
		
	}
	
	@Override
	public void show(int[] a) {
		System.out.println("beging....");
		tartget.show(a);
		System.out.println();
		System.out.println("end......");
			
	}




	public static void main(String[] args) {
		//Singleton teSingleton1 =Singleton.Instance();
		///Singleton teSingleton2 =Singleton.Instance();
		Sorter bubbleSortProxy = new StaticBubbleProxy(new BubbleSort());
		 int[] a= {1,4,9,10,3,2,8};
		 bubbleSortProxy.sort(a);
		 bubbleSortProxy.show(a);
		

	}


}
