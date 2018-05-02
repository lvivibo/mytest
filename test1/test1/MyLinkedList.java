package test1;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {
	
	Node head;
	Node current;
	
	public void  add(int data){
		if(null==head){
			head = new Node(data);
			current = head;
		}else{
			current.next = new Node(data);
			current = current.next;
		}
	}
	
	public void  print(){
		current = head;
		while(current!=null){
			//System.out.println("head"+head.val+",");
			System.out.print(current.val+",");
			current = current.next;
			
			//System.out.print(current.val+",");
		}
	
		
	
	}
	///1,2
	public Node reverseNode(Node head){
		if(head ==null||head.next==null){
			return head;
		}
		current = head;
		Node reversehead =null;
		while(current!=null){			
			Node next = current.next;
			current.next = current;
			reversehead = current;
			current = next;
			//System.out.println("test"+current.val);
		}
		return reversehead;
		
		
	}
	
	public class Node{
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
		}
		
		
	}
	///LinkedNode head =new LinkedNode();
	/*public MyLinkedList() {
		head.next = null;
	}*/

	
   
	/*void add(LinkedNode node){
		head.next = node;
	}			
	void list(){
		
	}	*/

	public static void main(String[] args) {
		//List list1 = new LinkedList();
		//list1.subList(fromIndex, toIndex);
		MyLinkedList list = new MyLinkedList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.reverseNode(list.head);
		list.print();
		
	}

}
