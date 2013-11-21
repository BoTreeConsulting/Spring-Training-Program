package com.botree.dp.observer;

public class User implements Observer {

	private String article;
	private Subject blog;

	public void setSubject(Subject blog) {
		System.out.println(getClass().getName() + ".setSubject() method called");
		this.blog = blog;
		article = "No New Article!";
	}

	@Override
	public void update() {
		System.out.println(getClass().getName() + ".update() method called");
		System.out.println("State change reported by Subject.");
		article = (String) blog.getUpdate();
	}

	public String getArticle() {
		return article;
	}
}