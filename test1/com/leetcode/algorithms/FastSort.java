package com.leetcode.algorithms;



public class FastSort {
	
	
	public void sort(int[] a,int begin,int end) {
		
		
		if (begin>= end) {
			return ;
		}
		int x = swapSort(a, begin, end);
		sort(a,begin,x-1);
		sort(a,x+1,end);
	}

	public int swapSort(int[] a,int begin,int end) {

		/////// int[] a1 = { 1, 11, 18, 28, 4,11,89,12 };
		int base = a[begin];
		int left = begin;
		int right = end;
		int base_postion = begin;
		while (left<right) {
			while (a[right] >= base) {
				if (right == 1) {
					return base_postion;
				}
				right--;

			}
			
			if (left > right) {
				return base_postion;
			}
			swap(a, left, right);
			base_postion = right;
			////////////////////
			while (a[left] <= base) {
				if (left == a.length - 1) {
					return base_postion; 
				}

				left++;

			}
			if (left >= right) {

				return base_postion;
			}
			swap(a, left, right);
			base_postion = left;
		}
		
		//sort(a,left,base_postion-1);
		//System.out.println("test");
		return base_postion;
		//sort(a,base_postion+1,right);

	}

	private void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	public static void main(String[] args) {
		int[] a1 = { 99,11, 1, 18, 28,12,7,89,12};
		FastSort sort = new FastSort();
		sort.sort(a1,0,a1.length-1);
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + ",");
		}
		//System.out.print("result:" + x);

	}

}
