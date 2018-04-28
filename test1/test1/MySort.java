package test1;

import java.util.concurrent.ForkJoinPool;

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
	/// a ={3,5,7,9,11,13};
	
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
				for(int k=1;k<a.length;k++){
					int get = a[k];
					int i=k;
					while(i>=gap&&get<a[i-gap]){
						int temp = a[i-gap];
						a[i-gap] = a[i];
						a[i] = temp;
						i=i-gap;				
					}
					a[i] = get;
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
	static void fastSort(int[] a,int begin,int end){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		////3
		///4,1
		//1,1,2,7
		//8
		//int[] a = {1,8,4,7,6,9};
		int test =6;
		int[] a ={3,5,7,9,11,13};
		//int[] a={1,3,5};
		MySort.insertBSort(a);
		MySort.print(a);
	   //System.out.println("xxxxxxxxxxxxxxxx");
	  // System.out.println(MySort.bSearch1(a,0,a.length-1,4));
	}

}
