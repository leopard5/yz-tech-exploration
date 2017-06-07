package com.yz.jvm.designPattern.Composite;

import java.util.ArrayList;

public class Composite extends Component {
	private ArrayList<Component> componentArrayList = new ArrayList<Component>();

	public void add(Component _component) {
		this.componentArrayList.add(_component);
	}

	public void remove(Component _component) {
		this.componentArrayList.remove(_component);
	}

	public ArrayList<Component> getChildren() {
		return this.componentArrayList;
	}
}
