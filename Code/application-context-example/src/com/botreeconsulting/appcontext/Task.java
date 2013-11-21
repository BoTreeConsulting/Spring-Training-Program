package com.botreeconsulting.appcontext;

public class Task {
	
	String taskName;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	@Override
	public String toString() {
		return "Task Name : " + taskName;
	}
	
	public void init() {
		System.out.println("Init method called");
	}
	
	public void destroy() {
		System.out.println("destroy method called");
	}

}
