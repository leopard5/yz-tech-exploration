package com.yz.jvm.designPattern.Mdeiator;

public class Colleague {
	protected Mediator mediator;

	public Colleague(Mediator _mediator) {
		this.mediator = _mediator;
	}
}
