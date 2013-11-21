package com.botree.dp.observer;

import java.util.ArrayList;
import java.util.List;

public class Blog implements Subject {

	List<Observer> observersList;
	private boolean stateChange;

	public Blog() {
		System.out.println(getClass().getName() + " Constructor Called");
		this.observersList = new ArrayList<Observer>();
		stateChange = false;
	}

	public void registerObserver(Observer observer) {
		System.out.println(getClass().getName() + ".registerObserver() Called");
		observersList.add(observer);
	}

	public void unRegisterObserver(Observer observer) {
		System.out.println(getClass().getName() + ".unRegisterObserver() Called");
		observersList.remove(observer);
	}

	public void notifyObserver() {
		System.out.println(getClass().getName() + ".notifyObserver() Called");

		if (stateChange) {
			for (Observer observer : observersList) {
				observer.update();
			}
		}
	}

	public Object getUpdate() {
		System.out.println(getClass().getName() + ".getUpdate() Called");
		Object changedState = null;
		// should have logic to send the
		// state change to querying observer
		if (stateChange) {
			changedState = "Observer Design Pattern";
		}
		return changedState;
	}

	public void postNewArticle() {
		System.out.println(getClass().getName() + ".postNewArticle() Called");
		stateChange = true;
		notifyObserver();
	}

}