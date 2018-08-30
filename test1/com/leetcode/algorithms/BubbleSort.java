package com.leetcode.algorithms;

public class BubbleSort implements Sorter {
	
	@Override
	public  void sort(int[] a) {
		boolean isSort = true;
		for(int i=a.length-1;i>1;i--) {
			for(int k=0;k<=i-1;k++) {
				if(a[k]>a[k+1]) {
					isSort = false;
					int temp1 = a[k+1];
					a[k+1]=a[k];
					a[k]=temp1;
					
				}
			}
			if(isSort) break;
		}
		//return a;
	}

	public static void main(String[] args) {
	 int[] a= {1,4,9,10,3,2,8};
	Sorter sorter = new BubbleSort();
	sorter.sort(a);
	 for (int i = 0; i < a.length; i++) {
		System.out.print(a[i]+",");
	}
	}

}
