package com.leetcode.algorithms;

import com.java.designpattern.Sorter;

public class SelectionSort {
	
	
	public void sort(int[] a) {
		
		for (int k = a.length-1; k>=1; k--) {
			int temp = a[k];
			int temp1 = a[0];
			int icount =0 ;
			for (int i = 1; i <= k; i++) {			
				if(temp1<a[i]) {
					temp1 = a[i];
					icount=i;
				}
			}
			a[k]=temp1;
			a[icount] =temp;
			
		}
		
		
		
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 9, 4, 6, 8, 5, 10 };
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort(a);
		for (int k = 0; k <= a.length - 1; k++) {
			System.out.print(a[k] + ",");
		}


	}

}
