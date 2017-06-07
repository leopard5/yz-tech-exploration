package com.yz.jvm.designPattern.Memento;

public class Memento {
	private String state = "";

	public Memento(String _state) {
		this.state = _state;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
