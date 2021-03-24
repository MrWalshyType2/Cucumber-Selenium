package com.qa.app;

public class Item {

	protected String title;
	
	protected String link;
	
	public Item() {
		super();
	}

	public Item(String title, String link) {
		super();
		this.title = title;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
