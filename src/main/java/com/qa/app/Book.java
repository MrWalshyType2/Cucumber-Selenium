package com.qa.app;

public final class Book extends Item {
	
	private String author;

	public Book(String title, String link, String author) {
		this.title = title;
		this.link = link;
		this.author = author;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", link=" + link + "]";
	}

	public String toCSV() {
		return author + "," + title + "," + link;
	}
}
