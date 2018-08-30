package com.java.designpattern;
import com.java.designpattern.Observer;

public class User implements Observer {

	private String name;
	private String message;

	public User(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		this.message = message;
		System.out.println(name + " 收到推送消息： " + message);
	}

	/*public void read() {
		
	}*/

}
