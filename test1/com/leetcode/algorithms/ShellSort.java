package com.leetcode.algorithms;

public class ShellSort {
	
	
	void sort(int[] a) {
		int j = (a.length)/2;
		//System.out.println(d);
		for(int d=j;d>=1;d/=2) {
		
			for (int i = 0; i <= a.length-1&&i<=d-1; i++) {
				for(int k=i;k<=a.length-d-1;k+=d) {
					if(a[k]>a[k+d]) {
						swap(a,k,k+d);
					}
				}
				
			}
		}
		
		
		
		
	}
	private void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	public static void main(String[] args) {
		int[] a1 = { 99,11, 1, 18, 28,12,7,89,13,16};
		ShellSort sort = new ShellSort();
		sort.sort(a1);
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + ",");
		}
		
		
	}

}
