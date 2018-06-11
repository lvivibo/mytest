package com.leetcode.algorithms;


public class InsertSort {

	public void sort(int[] a) {

		 int insert=0;
		int index = 0;
		for (int i = 1; i < a.length; i++) {
			insert =a[i];
		    index = 0;
			while (a[index] < insert) {
				index++;
			}
			int m = i-1;
			int temp1 = a[i];
			while (m >= index) {			
				a[m+1] =a[m];
				m--;
			}
			a[index] = temp1;

		}
	}

	public static void main(String[] args) {
	     // int[] a= {1,2,3,8,9,4};
		int[] a = { 2, 1, 9, 4, 6, 8, 5, 10 };
		//int i = 6;
		InsertSort insertSort = new InsertSort();
		insertSort.sort(a);
		
		
		
		for (int k = 0; k <= a.length - 1; k++) {
			System.out.print(a[k] + ",");
		}

	}

}
