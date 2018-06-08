package com.java.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.sun.glass.ui.TouchInputSupport;

public class DynamicProxy implements InvocationHandler {

	private Object tar;

	public Object bind(Object tar) {
		this.tar = tar;
		// 绑定该类实现的所有接口，取得代理类
		return Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(tar, args);
		return result;

		// return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub ProxyHandler proxy = new ProxyHandler();
		int[] a = { 1, 4, 9, 10, 3, 2, 8 };
//绑定该类实现的所有接口
		DynamicProxy proxy = new DynamicProxy();
		Sorter sub = (Sorter) proxy.bind(new BubbleSort());
		sub.sort(a);
		sub.show(a);
	}

}
