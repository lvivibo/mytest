package test1;

public class HeapSort{
private static int[] sort=new int[]{1,0,10,20,3,5,6,4,9,8,12,
17,34,11};

public static void main(String[] args){

 buildMaxHeapify(sort);
//heapSort(sort);
//print(sort);
for (int x=0; x<sort.length; x++){
	System.out.print(sort[x]+",");
	//System.out.println("test");
}
}

private static void buildMaxHeapify(int[] data){
//没有子节点的才需要创建最大堆，从最后一个的父节点开始
int startIndex=(data.length-1)/2-1;
//从尾端开始创建最大堆，每次都是正确的堆
for(int i=startIndex;i>=0;i--){
maxHeapify(data,data.length,i);
}
 }


private static void maxHeapify(int[] data,int heapSize,int index){
//当前点与左右子节点比较
int left=index*2+1;
int right=index*2+2;

int largest=index;
if(left<data.length&&data[index]<data[left]){
largest=left;
}
if(right<data.length&&data[largest]<data[right]){
largest=right;
}
//得到最大值后可能需要交换，如果交换了，其子节点可能就不是最大堆了，需要重新调整
if(largest!=index){
int temp=data[index];
data[index]=data[largest];
data[largest]=temp;
maxHeapify(data,heapSize,largest);
}
}

/**
*排序，最大值放在末尾，data虽然是最大堆，在排序后就成了递增的
*

*/
private static void heapSort(int[] data){
//末尾与头交换，交换后调整最大堆
for(int i=data.length-1;i>0;i--){
int temp=data[0];
data[0]=data[i];
data[i]=temp;
maxHeapify(data,i,0);
}
}

/**
*父节点位置
*
*@paramcurrent
*@return
*/
private static int getParentIndex(int current){
return(current-1)>>1;
}

/**
*左子节点position注意括号，加法优先级更高
*
*@paramcurrent
*@return
*/
private static int getChildLeftIndex(int current){
return(current<<1)+1;
}

/**
*右子节点position
*

*@return
*/
private static int getChildRightIndex(int current){
 return(current<<1)+2;
}
}