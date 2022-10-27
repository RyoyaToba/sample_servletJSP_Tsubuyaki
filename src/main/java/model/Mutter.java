package model;

import java.io.Serializable;

public class Mutter implements Serializable{
	private String userName;
	private String text;
	
	public Mutter() {}
	public Mutter(String userName, String text) {
		super();
		this.userName = userName;
		this.text = text;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
