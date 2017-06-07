package com.yz.jvm.designPattern.Observer;

import java.util.Iterator;
import java.util.Vector;

public abstract class SubjectObject {
	private Vector<Observer> obsVector = new Vector<Observer>();

	public void addObserver(Observer obs) {
		this.obsVector.add(obs);
	}

	public void delObserver(Observer obs) {
		this.obsVector.remove(obs);
	}

	public void notifyObservers() {
		for (Iterator iterator = obsVector.iterator(); iterator.hasNext();) {
			Observer type = (Observer) iterator.next();
			type.update();
		}
	}

}
