package test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sun.glass.ui.TouchInputSupport;



/////Input: 1->2->3->4->5->NULL, m = 2, n = 4
/////Output: 1->4->3->2->5->NULL
public class Solution1 {
	ListNode head;

	class ListNode {
		ListNodeData data = new ListNodeData();

		ListNode(int x) {
			data.val = x;
		}
	}
	public void add(int x) {
		if(null==head) {
			head = new ListNode(x);
			return ;
		}
		ListNode cur = head;
		while(cur.data.next!=null) {
			cur = cur.data.next;
			
		}
		cur.data.next = new ListNode(x);
		//head = node;
	}
	public int get(int x) {
		ListNode cur = head;
		for (int i = 0; i <= x; i++) {
			cur = cur.data.next;
		}
		return cur.data.val;
	}
	public void display() {
		ListNode cur = head;
		while(cur.data.next!=null) {
			System.out.print(cur.data.val+",");
			cur = cur.data.next;
			
		}
		System.out.print(cur.data.val+",");
	}
	
/////Input: 1->2->3->4->5->NULL, m = 2, n = 4
/////Output: 1->4->3->2->5->NULL
	public ListNode reverseBetween(ListNode this_head, int m, int n) {
		ListNode prev = null;
		ListNode cur = this_head;
		ListNode next = null;
		ListNode n_node = null;
		int m_count = 1;
		int n_count =1;
		while (m_count<m-1&&cur!=null) {			
			cur  = cur.data.next;
			//cur = cur;
			m_count++;
			n_count++;
		}
		ListNode  m_prev = cur;
		ListNode m_node = cur.data.next;
		cur = m_node;
		n_count++;
		while(n_count<=n&&cur!=null) {
			next = cur.data.next;
			cur.data.next = prev;
			prev = cur;
			if(n_count==n) {
				n_node = cur; 
				
			}
			cur = next;
			n_count++;
		}
		ListNode n_next = cur;
		m_node.data.next=n_next;
		m_prev.data.next=n_node;
		return this_head;
		
		
	}
	//head-2-3
	public void reverse() {
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		while(cur!=null) {
			if(cur.data.next==null) {
				head =cur;
			}
			next = cur.data.next;
			cur.data.next = prev;
			prev = cur;
			cur = next;
		}
		
	}
	public void reverse1() {
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		while(cur!=null) {
			next = cur.data.next;
			cur.data.next = prev;
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
			head = head.data.next;
			return ;
		}
		while(cur!=null) {
			if(n==i) {
				prev.data.next = cur.data.next;
				break;
			}
			n++;
			prev = cur;
		
			cur = cur.data.next;
			
		
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
		ListNode head = new ListNode();
		lists.reverseBetween(head,2,6);
		lists.display();
		//t2-t1-t3
	
		

	}

}
