package test1;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {
	
	Node head;
	
	public void  add(int data){
		if(null==head){
			head = new Node(data);
		}else{
			head.next = new Node(data);
			head = head.next;
		}
	}
	
	public void  print(){
		Node current = head;
		while(current!=null){
			//System.out.println("head"+head.val+",");
			System.out.print(current.val+",");
			current = current.next;
			//Node currentN = current;
			//System.out.print(current.val+",");
		}
	
		
	
	}
	///1,2
	public void reverseNode(){
		if(head ==null||head.next==null){
			return ;
		}
		Node current = head;
		Node reversehead =null;
		Node next = null;
		while(current!=null){			
			next = current.next;
			current.next = reversehead;
			reversehead = current;
			current = next;
			//System.out.println("test"+current.val);
		}
		head = reversehead;
		//return reversehead;
		
		
	}
	/*Input: 1->2->3->4->5->NULL, m = 2, n = 4
			Output: 1->4->3->2->5->NULL*/
	public void reverseBetween(Node head, int m, int n) {
		if(head ==null||head.next==null){
			return ;
		}	
		Node last_current =null;
		Node next = null;
		int m_count=1;
		int n_count=1;
		Node pre_m = null;
		Node m_node = null;		
////////////n
	/*Input: 1->2->3->4->5->NULL, m = 2, n = 4
	 * 
	Output: 1->4->3->2->5->NULL*/
		Node current = head;
		while(current!=null){
			next = current.next;
			if(m-1==m_count){ 
				pre_m=current;
			}
			if(m==m_count){
				m_node = current;
				last_current = m_node;
			}
			if(m_count>m&&n_count<n){
				current.next = last_current;
			}
			if(n_count==n){
				pre_m.next = current;
				m_node.next = current.next;			
				current.next = last_current;
				
			}
			last_current = current;
			current = next;
			m_count++;
			n_count++;
			
		}
		
		//return reversehead;
	    
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
		list.add(5);
		list.add(6);
		//list.reverseNode();
		list.reverseBetween(list.head,2,5);
		list.print();
		
	}

}
