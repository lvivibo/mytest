package com.leetcode.algorithms;

import java.util.Stack;

public class Fact {
	///n!;
	public int  doFact(int n) {
		if(n==1||n==0) {
			return 1;
		}
		int result = n*doFact(n-1);
		return result;
	}
	public int doFact1(int n) {
		
		return 0;
	}
	public static void main(String[] args) {
		
		String[] a = {"a1","a2","a3","b3","c","b","33","33"};

		Fact fact = new Fact();
		System.out.println(fact.doFact(4));
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		for(int i:stack) {
			System.out.print(i+",");
		}

	}

}
