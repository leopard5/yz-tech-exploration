package com.yz.jvm.designPattern.Memento;

public class Caretaker {
	private Memento memento;

	/**
	 * @return the memento
	 */
	public Memento getMemento() {
		return memento;
	}

	/**
	 * @param memento
	 *            the memento to set
	 */
	public void setMemento(Memento memento) {
		this.memento = memento;
	}

}
