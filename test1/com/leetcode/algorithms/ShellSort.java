package com.leetcode.algorithms;

import java.util.Arrays;

public class ShellSort {
	
	
	void sort(int arr[]) {
		int d=arr.length/2;
	      int x,j,k=1;
	      while(d>=1) {
	         for(int i=d;i<arr.length;i++) {
	            x=arr[i];
	            j=i-d;
	            //直接插入排序，会向前找所适合的位置
	            while(j>=0 && arr[j]>x) {
	                //交换位置
	                arr[j+d]=arr[j];
	                j=j-d;
	              //  System.out.println(j);
	            }
	            arr[j+d]=x;
	         }
	         System.out.println("第"+ k++ +"趟："+d+Arrays.toString(arr));
	         d=d/2;
	         
	      }
	   }
		
	
		
		
	
	private void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	public static void main(String[] args) {
		ShellSort shellSort = new ShellSort();
		int arr[]={32,32,95,45,75,22,95,49,3,76,56,11,37,58,44,19,81};
		//int arr[] = {1,3,5,7,8};
		//int test =6;
		//int i=0;
		
		
	      System.out.println("排序前："+Arrays.toString(arr));
	      shellSort.sort(arr);
	      System.out.println("排序后："+Arrays.toString(arr));
		
		/*for (int j = 0; j < arr.length; j++) {
			while(arr[j]>test) {
				System.out.println(j);
				break;
				
			}
		}*/
	}

}
