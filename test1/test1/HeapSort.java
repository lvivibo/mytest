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
//û���ӽڵ�Ĳ���Ҫ�������ѣ������һ���ĸ��ڵ㿪ʼ
int startIndex=(data.length-1)/2-1;
//��β�˿�ʼ�������ѣ�ÿ�ζ�����ȷ�Ķ�
for(int i=startIndex;i>=0;i--){
maxHeapify(data,data.length,i);
}
 }


private static void maxHeapify(int[] data,int heapSize,int index){
//��ǰ���������ӽڵ�Ƚ�
int left=index*2+1;
int right=index*2+2;

int largest=index;
if(left<data.length&&data[index]<data[left]){
largest=left;
}
if(right<data.length&&data[largest]<data[right]){
largest=right;
}
//�õ����ֵ�������Ҫ��������������ˣ����ӽڵ���ܾͲ��������ˣ���Ҫ���µ���
if(largest!=index){
int temp=data[index];
data[index]=data[largest];
data[largest]=temp;
maxHeapify(data,heapSize,largest);
}
}

/**
*�������ֵ����ĩβ��data��Ȼ�����ѣ��������ͳ��˵�����
*

*/
private static void heapSort(int[] data){
//ĩβ��ͷ�������������������
for(int i=data.length-1;i>0;i--){
int temp=data[0];
data[0]=data[i];
data[i]=temp;
maxHeapify(data,i,0);
}
}

/**
*���ڵ�λ��
*
*@paramcurrent
*@return
*/
private static int getParentIndex(int current){
return(current-1)>>1;
}

/**
*���ӽڵ�positionע�����ţ��ӷ����ȼ�����
*
*@paramcurrent
*@return
*/
private static int getChildLeftIndex(int current){
return(current<<1)+1;
}

/**
*���ӽڵ�position
*

*@return
*/
private static int getChildRightIndex(int current){
 return(current<<1)+2;
}
}