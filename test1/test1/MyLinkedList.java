package test1;

public class MyLinkedList {
	LinkedNode head =new LinkedNode();
	public MyLinkedList() {
		head.next = null;
	}

	
   
	void add(LinkedNode node){
		head.next = node;
	}
	void list(){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
