package test1;

import com.leetcode.algorithms.Sorter;

public class FastSort {
	
	
	private static void maxHeapify(int[] data,int heapSize,int index){
		//��ǰ���������ӽڵ�Ƚ�
		int left = (index << 1) + 1;
		int right = (index << 1) + 2;
		int largest = index;
		if (left <= heapSize && data[largest] < data[left]) {
			largest = left;
		}
		if (right <= heapSize && data[largest] < data[right]) {
			largest = right;
		}
		if (largest != index) {
			int temp = data[index];
			data[index] = data[largest];
			data[largest] = temp;
			maxHeapify(data, heapSize, largest);
		}

	}
	///7
	///8,3
	///3,15,6,7
	///4,13,11
	////a = { 7,8, 3, 3, 15, 6, 7, 4, 13, 11};
	//1
	//4,6
	//2,5,7,8
	//int[] b = { 1,4,6, 2,5,7,8};
	static void heapSort(int[] a){
		printA(a);
		int startIndex = (a.length-1)/ 2;
		int heapSize = a.length-1;
		for (int i = startIndex; i >= 0; i--){
			maxHeapify(a,heapSize,0);
			printA(a);
		}
			
		int temp = a[0];
		a[0] = a[heapSize];
		a[heapSize] = temp;
		System.out.println("xxxxxxxxxxxx");
		printA(a);
		for (int k = heapSize - 1; k >= 0; k--) {		
			maxHeapify(a,k,0);
			int temp1 = a[0];
			a[0] = a[k];
			a[k] = temp1;
		}
		printA(a);
		
	}

	
	
	static void selectSort(int[] a){
		/*int min = a[0];
		for(int i=1;i<a.length;i++){
			if(a[i]<=min) {
				min = a[i];
			}
		}
		System.out.println(min);*/
		for(int j=0;j<a.length;j++){ 
			int min = a[j];
			int minIndex = j;
			for(int i=j+1;i<a.length;i++){
				if(a[i]<=min) {
					minIndex = i;
				}
			}
			int temp1 = a[minIndex];
			a[minIndex]=a[j];
			a[j] = temp1;
			
				
		}
			
	}
	static void shellSort(int[] a){
		
			
	}
	static void insertSort(int[] a){
		for(int j=1;j<a.length;j++){ 
			int x=a[j];
			int i = 0;
			while(i<j&&a[i]<=x) i++;
			for(int m=j;m>=1&&m>=i;m--){
				a[m] = a[m-1];
			}
			a[i]=x;
				
		}
			
	}

	static void MergeSort(int[] a,int left,int right){
		
		if (left == right) return ;
		int mid = (left+right)/2;
		MergeSort(a,left,mid);
		MergeSort(a,mid+1,right);
		merge(a,left,mid,right);
		//merge(a,)
	}
	////a{1,4,6} ;      b{2,5,8}
////a = { 1,4,6, 2,5,8};
	///A[left...mid]��A[mid+1...right]

	   static void merge(int a[], int left, int mid, int right){
		   int len = right - left + 1;
		int[] temp = new int[a.length];
		int j=0;
	////a = { 1,4,6, 2,5,7,8};
		int i = left;
		int k = mid+1;
		while(i<=mid&&k<=right){
			if(a[i]<=a[k]){
				temp[j]=a[i];
				i++;
				j++;
			}else{
				temp[j]=a[k];
				k++;
				j++;
			}
			/*System.out.println("k:"+k+"---i:"+i+",j:"+j);
			j++;*/
			
		}
		while(i<=mid){
			temp[j]=a[i];
			i++;
			j++;
		}
		while(k<=right){
			temp[j]=a[k];
			k++;
			j++;
		}
		for(int m=0;m<len;m++){
			a[left] = temp[m];
			left++;
		}
		
		
		
	}
	static void bubbleSort(int[] a){
		int x=0;
		for(int i=a.length-1;i>=0;i--){
			for(int j=0;j<i;j++){ 
				x++;
				if(a[j]>a[j+1]){
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
					
			}
		}
		
			
			
			System.out.println(x);

		
	}
	static void tower(int n,char from,char temp,char to){
		if(n==1){
			System.out.println("moving from "+from+to );
		}
		
	}
	static void fastSort1(int[] a,int begin,int end){
		if(begin>=a.length-1) return ;
		if(end<1) return ;
		if(begin>=end) return;
		int ruler = a[begin];
		int e = end;
		int b = begin;
		////// {  7, 8, 3, 15, 6, 9, 4, 13, 11 };
		//printA(a);
		//if(end<=2) return;
		//if(begin>=a.length-2) return;
		while(true){	
			if(begin>=end) break;
			while(end>=1&&a[end]>=ruler)end--;
			if(begin>=end) break;
			int temp1 = a[begin];
			a[begin] = a[end];
			a[end] = temp1;
			
			while(begin<=a.length-2&&a[begin]<=ruler) begin++;
		    if(begin>=end) break;			
			int temp2 = a[end];
			a[end] = a[begin];
			a[begin] = temp2;
		}
		//printA(a);
		fastSort1(a,b,begin-1);
		fastSort1(a,begin+1,e);
		//printA(a);
	}
	 static void  printA(int[] a){
		
		for (int x=0; x<a.length; x++){
			System.out.print(a[x]+",");
			
		}
		System.out.println();
	}
	public void swap(int a,int b){
		int temp = a;
		a = b;
		b = temp;
	}
	//public void swap()
	 void  insertSort1(int[] a) {
		if(a.length==1) {
			return ;
		}
		for(int i=1;i<=a.length-1;i++) {
			int insert = a[i];			
			int k = 0;
			while(insert>=a[k]&&k<=i-1) {
				k++;
			}
			int temp2 = i;
			//System.out.println("k"+k);
			while(temp2>=1&&temp2>k) {
				//swap(a[temp2-1],a[temp2]);	
				int temp3 = a[temp2-1];
				a[temp2-1] = a[temp2];
				a[temp2] = temp3;
				temp2--;
			}
			
		}
		printA(a);
		
		
				
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		
		///18,15,7,13,11,6,3,4,8,7,
		///18
		///15,7
		///13,11,6,3
		//3,4,8,7
		
		
		
		
		///{ 8, 1, 3, 15, 6, 7, 4, 13, 11 };
				
				//String s ="this,ddd,ss,sss";
				//String[] k = "this,ddd,ss,sss".split("\\,");
				///System.out.println("test");
		//int[] b = { 1,4,6, 2,5,7,8};
		
		//1
		//4,6
		//2,5,7,8
		//int[] b = { 7,8, 3, 19, 15, 6, 7, 4, 13, 11};
		int[] b = { 8,7};
		//FastSort.fastSort1(a, 0,a.length-1);
		//FastSort.heapSort(b);
		FastSort testSort = new FastSort();
		testSort.insertSort1(b);
		
		
	
		
	}
	
}
