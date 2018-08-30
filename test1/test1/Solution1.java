package test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



/////Input: 1->2->3->4->5->NULL, m = 2, n = 4
/////Output: 1->4->3->2->5->NULL
public class Solution1 {
	ListNode head;

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	public void add(int x) {
		if(null==head) {
			head = new ListNode(x);
			return ;
		}
		ListNode cur = head;
		while(cur.next!=null) {
			cur = cur.next;
			
		}
		cur.next = new ListNode(x);
		//head = node;
	}
	public int get(int x) {
		ListNode cur = head;
		for (int i = 0; i <= x; i++) {
			cur = cur.next;
		}
		return cur.val;
	}
	public void display() {
		ListNode cur = head;
		while(cur.next!=null) {
			System.out.print(cur.val+",");
			cur = cur.next;
			
		}
		System.out.print(cur.val+",");
	}
	
/////Input: 1->2->3->4->5->NULL, m = 2, n = 4
/////Output: 1->4->3->2->5->NULL
	public void reverseBetween( int m, int n) {
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		ListNode n_node = null;
		int m_count = 1;
		int n_count =1;
		while (m_count<m-1&&cur!=null) {			
			cur  = cur.next;
			//cur = cur;
			m_count++;
			n_count++;
		}
		ListNode  m_prev = cur;
		ListNode m_node = cur.next;
		cur = m_node;
		n_count++;
		while(n_count<=n&&cur!=null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			if(n_count==n) {
				n_node = cur; 
				
			}
			cur = next;
			n_count++;
		}
		ListNode n_next = cur;
		m_node.next=n_next;
		m_prev.next=n_node;
		
		
		
	}
	//head-2-3
	public void reverse() {
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		while(cur!=null) {
			if(cur.next==null) {
				head =cur;
			}
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		
	}
	public void reverse1() {
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		while(cur!=null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next ;
		}
		
	}
	public void  remove(int i) throws Exception {
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		int n = 0;
		if(0==i) {
			//head = null;
			head = head.next;
			return ;
		}
		while(cur!=null) {
			if(n==i) {
				prev.next = cur.next;
				break;
			}
			n++;
			prev = cur;
		
			cur = cur.next;
			
		
		}
		
	}
	public static void main(String[] args) throws Exception {
		//List<String> list = new ArrayList<String>();
		//list.add("1");
		//list.remove(0);
		//System.out.println();
		/*for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string+"doo");
			
		}*/
		Solution1 lists = new Solution1();
		
		
		lists.add(1);
		lists.add(2);
		lists.add(3);
		lists.add(4);
		lists.add(6);
		lists.add(7);
		lists.add(8);
		lists.display();
		System.out.println();
		//lists.reverseBetween(2,6);
		lists.display();
		//t2-t1-t3
	
		

	}

}
