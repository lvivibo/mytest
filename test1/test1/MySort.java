package test1;

import com.sun.xml.internal.org.jvnet.fastinfoset.sax.helpers.FastInfosetDefaultHandler;

public class MySort {
	////8,2,7,1,4,3,1
//	8
//	2,7
	
	///bubblesort O(n2),stable
	static void bubbleSort(int[] a){
		boolean flag = false;
		for(int k=a.length-1;k>=0;k--){
			for (int i = 0; i < k; i++) {
				if(a[i]>a[i+1]){
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					flag = true;
				}
			}
			if(flag==false){
				System.out.println("sort is done");
				return ;
			}
		}
		
	}
	////selectSort O(n2)
	static void selectSort(int[] a){
		for (int k = a.length-1; k >=0; k--){
			int max = a[0];
			int index = 0;
			for (int i = 0; i <= k; i++) {			
				if(a[i]>max){			
					max=a[i];		
					index = i;
				}
			}
			a[index] = a[k];
			a[k] = max;
		}

	}
	////nlogn 1
	static void heapSort(int[] a){
		int startIndex=(a.length-1)/2-1;
		int heapSize = a.length-1;
		for(int i=startIndex;i>=0;i--){
			createHeap(a,heapSize,i);
		}
		print(a);
//		System.out.println("sss");
		int temp1 = a[0];
		a[0]=a[heapSize];
		a[heapSize] = temp1;
		print(a);
		for(int k=heapSize-1;k>=0;k--){
			createHeap(a,k,0);
			int temp2 = a[0];
			a[0]=a[k];
			a[k] = temp2;
		}
		
		
	}
	//4
	//1,2,5,7,4
	//int[] a ={3,4,1,1,2,7,8};
	static void insertSort(int[] a){
		for(int k=1;k<a.length;k++){
			int get = a[k];
			int i=k;
			while(i>0&&get<a[i-1]){
				int temp = a[i-1];
				a[i-1] = a[i];
				a[i] = temp;
				i--;				
			}
			a[i] = get;
		}
	}
	static void selectionSort(int[] a){
		for(int k=a.length-1;k>=1;k--) {
			int max = a[0];
			int count =0;
			for (int i = 1; i <= k; i++) {
				if(a[i]>max) {
					count = i;
					max = a[count];
					
				}
			}
			int temp = a[k];
			a[k] = a[count];
			a[count] =temp;
		}
		
	}
	public int[] mergeSort(int[] a) {
		if(a.length==1) return a;
		int[] c = new int[a.length];
		helpSort(0,a.length-1,a,c);
		
		return c;
	}
	//{0,1,2,3,4,5,6,7,8,9}
	public void  helpSort(int begin,int end,int[] a,int[] c) {
		int mid = (end+begin)/2;
		if(begin>=end) {
			//System.out.println("begin"+begin+"end"+end+a[begin]);
			return;
		}
		
		/*if(mid<=0) {
			return ;
		}*/
		//System.out.pri
			helpSort(begin,mid,a,c);
			helpSort(mid+1,end,a,c);
			mergeArray(begin,end,a,c);
			//this.print(c);
		
	}	
	public void mergeArray(int begin,int end,int[]a,int[] c) {
		int mid = (begin+end)/2;
		int a_count =begin;
		int b_count = mid+1;
		int c_count = 0;
		if(a_count>mid&&b_count>end) {
			return ;
		}
		while(a_count<=mid&&b_count<=end) {
			if(a[a_count]<=a[b_count]) {
				
				
				c[c_count]=a[a_count];
				
				c_count++;
				a_count++;
				//continue;
				
			}
			if(a[a_count]>a[b_count]) {
				c[c_count]=a[b_count];
				c_count++;
				b_count++;
				
			}
		}
		while (a_count > mid &&b_count<=end) {
			c[c_count] = a[b_count];

			b_count++;

			c_count++;

			
		}
		while (b_count > end &&a_count<=mid) {

			c[c_count] = a[a_count];

			a_count++;

			c_count++;

			
		}
		for (int i = 0; i < c_count; i++) {
			a[begin+i] = c[i];
			
		}	
			
		
		
		
	}
	
	
	public void mergeArray1(int begin,int mid,int end,int[]a,int[] c) {
		int a_count = begin;
		int b_count = mid+1;
		int c_count = 0;
		
		while(c_count<c.length) {
			
			
			/*if ((a_count <= mid && b_count <= end) && a[a_count] == a[b_count]) {

				c[c_count++] = a[b_count++];
				c[c_count++] = a[a_count++];
				continue;
			}*/
			/*if ((a_count <= mid && b_count <= end) && a[a_count] >= a[b_count]) {

				c[c_count++] = a[b_count++];

				continue;
			}*/
			
			if (a[a_count] >= a[b_count]) {

			c[c_count++] = a[b_count++];

			continue;
		}
			if (a[a_count] < a[b_count]) {
				c[c_count++] = a[a_count++];

				continue;
			}

			if(b_count<=end) {
				//System.out.println(b_count);
				c[c_count++] = a[b_count++];
				continue;
				
			}
			if(a_count<=mid) {
				c[c_count++] = a[a_count++];
	
				continue;
				
			}
			c_count++;
			
		}
		
		
	}
	public  void fastSort(int[] a,int begin,int end) {
		
		if(begin < end) {
			int mid =findFlag(a,begin,end);
			//System.out.println("mid"+mid);
			fastSort(a,begin,mid-1);
			fastSort(a,mid+1,end);
		}
		
	}
	
	//int[]  a ={105,104,1,103,101,99,21};
	public int  findFlag(int[] a,int begin,int end) {
		int flag = a[begin];
		int left=begin;
		int right = end;
		int mid =begin;
		while(left<right) {
			
			while(right>left&&a[right]>=flag) {
				right--;
			}
			int temp2 = a[right];
			a[right]= a[left];
			a[left]= temp2;
		
			while(right>left&&a[left]<=flag) {
				
				left++;
			}
			int temp1 = a[left];
			a[left] = a[right];
			a[right]=temp1;
			
		}
		return left;
		
	}
	/*static void MergeSort(int[] a){
		for(int k=a.length-1;k>=1;k--) {
			int max = a[0];
			int count =0;
			for (int i = 1; i <= k; i++) {
				if(a[i]>max) {
					count = i;
					max = a[count];
					
				}
			}
			int temp = a[k];
			a[k] = a[count];
			a[count] =temp;
		}
		
	}*/
	/// a ={100,3,5,4,9,14,15,13};
	static  void insertSortB(int[] a) {
		for (int i = 1; i <= a.length-1; i++) {
			int insert = a[i];
			int k = i;
			if(insert>=a[k-1]) {
				continue;
			}
			while(k>=1&&insert<a[k-1] ) {
				a[k] = a[k-1];
				k--;
			}
			a[k] = insert;
		}
		
	}
	static  void shellSortB(int[] a) {
		
		int d = a.length/2;
		while(d>0) {
			for (int i = d; i <= a.length-1; i++) {
				int insert = a[d];
				int k = d;
				if(insert>=a[k-d]) {
					continue;
				}
				while(k>=d&&insert<a[k-d] ) {
					a[k] = a[k-d];
					k=k-d;
				}
				a[k] = insert;
			}
			d = d/2;
		}
		
		
	}
		static void insertBSort(int[] a){
			for(int k=1;k<a.length;k++){
				int get = a[k];
				
				int start=0;
				int end = k-1;
				while(start<=end){
					//if(start==0&&end==0) break;
					int mid = (start+end)/2;
					if(get>=a[mid]){
						start = mid+1;
					}else{
						end = mid-1;
					}
						
				}
				int i=k-1;
				while(i>0&&i>=start){
					int temp = a[i-1];
					a[i-1] = a[i];
					a[i] = temp;
					i--;				
				}
				a[i] = get;
			}
		}
		static void shellSort(int[] a){
		/*	for(int gap=a.length/2;gap>0;gap/=2){
			}*/
			int gap = a.length/2;
			while(gap>0){
				for(int k=gap;k<a.length;k++){
					int insert = a[k];
					int i=k;
					while(i>=gap&&insert<a[i-gap]){
						int temp = a[i-gap];
						a[i-gap] = a[i];
						a[i] = temp;
						i-=gap;				
					}
					a[i] = insert;
				}
				gap =gap/2;
			}
				
				
			
		
		//System.out.println(i);
		
		
		
	}
		
		
	static void createHeap(int[] a,int heapSize,int i){
		int left = 2*i+1;
		int right = 2*i+2;
		int max = i;
		if(left<=heapSize&&a[left]>a[max]){
			max = left;
		}
		if(right<=heapSize&&a[right]>a[max]){
			max = right;
		}
		if(max !=i){
			int temp = a[max];
			a[max] = a[i];
			a[i] = temp;
			createHeap(a,heapSize,max);
		}
	}
	static void print(int[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+",");
		}
		System.out.println();
	}
	static int bSearch(int[] a,int i){
		int low = 0;
		int high = a.length-1;
		//int mid = a.length/2;
		while(low<=high){
			int mid=(low+high)/2;
			if(i==a[mid]) return mid;
			if(i>a[mid]){
				low = mid+1;
			}else{
				high = mid-1; 
			}
				
		}
		return -1;
	}
	static int bSearch1(int[] a,int begin,int end,int i){
		
		int mid = (begin+end)/2;
		if(i == a[mid]) return mid;
		if(i<a[mid]){
			return bSearch1(a,begin,mid-1,i);
			
		}else{
			return bSearch1(a,mid+1,end,i);
		}
			
		//if(i<a[mid]) 
		//return -1;
	}
	
	public static void main(String[] args) {
		///// 
		////3
		///4,1
		//1,1,2,7
		//8
		//int[] a = {1,8,4,7,6,9};
		//int test =6;
		int[]  a ={100,98,1,103,101,99,21};
		//int[] a = {1,3,2,5};
		//int[]  a ={1000,6};
		int[] x= new int[a.length];
		//int[] b = {1,5,6,7};
		//int[] c = {2,8,10};
		//int[] a={1,3,5};
		//MySort.selectionSort(a);
		MySort testSort = new MySort();
	    System.out.println(testSort.findFlag(a,0,a.length-1));
		//testSort.findFlag(a,0,a.length-1);
		MySort.print(a);
		//System.out.println("mid"+(0+11)/2);
		//testSort.mergeArray(0,a.length-1, a, x);
		//MySort.print(x);
	   //System.out.println("xxxxxxxxxxxxxxxx");
	  // System.out.println(MySort.bSearch1(a,0,a.length-1,4));
	}

}
