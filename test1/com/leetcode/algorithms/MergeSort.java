package com.leetcode.algorithms;

public class MergeSort {

	private void splitArray(int begin, int end, int[] a) {
		int mid = (end + begin) / 2;
		if (end <= begin) {
			return;
		}
		if (mid == 0) {
			if (a[begin] > a[end]) {
				int temp = a[end];
				a[end] = a[begin];
				a[begin] = temp;
			}
			return;
		}
		splitArray(begin, mid, a);
		splitArray(mid + 1, end, a);
		mergerArray(begin, mid, end, a);
	}

	public void mergerArray(int begin, int mid, int end, int[] a) {
		int[] temp = new int[end - begin + 1];
		int a1 = begin;
		int b1 = mid + 1;
		int c1 = 0;
		while (c1 <= temp.length - 1) {
			if (a1 > mid && b1 <= end) {
				temp[c1] = a[b1];
				c1++;
				b1++;
				continue;
			}
			if (b1 > end && a1 <= mid) {
				temp[c1] = a[a1];
				c1++;
				a1++;
				continue;
			}
			if (b1 > end && a1 > mid) {
				c1++;
				continue;
			}

			if (a[a1] <= a[b1]) {
				temp[c1] = a[a1];
				a1++;
			} else {
				temp[c1] = a[b1];
				b1++;
			}
			c1++;

		}
		for (int i = 0; i < temp.length; i++) {
			a[begin] = temp[i];
			begin++;
		}

	}

	// @Override
	public void sort(int[] a) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		int[] a1 = { 1000, 12, 18, 17, 1, 2, 3, 7, 8, 10, 11, 11, 11, 11 };
		// int[] a1 = {3,2,1};
		int[] a2 = { 4, 6, 7 };

		// int[] a= {1,9,4,10,3,2,8};
		MergeSort sorter = new MergeSort();

		sorter.splitArray(0, a1.length - 1, a1);
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + ",");
		}

	}
}
//0,1,2,3,4,5