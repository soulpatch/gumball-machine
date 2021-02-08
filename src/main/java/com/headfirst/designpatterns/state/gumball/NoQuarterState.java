package com.headfirst.designpatterns.state.gumball;

public class NoQuarterState implements State {
	GumballMachine gumballMachine;

	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public String insertQuarter() {
		gumballMachine.transitionToHasQuarter();
		return "You inserted a quarter";
	}

	public String ejectQuarter() {
		return "You haven't inserted a quarter";
	}

	public String turnCrank() {
		return "You turned, but there's no quarter";
	}

	public String dispense() {
		return "You need to pay first";
	}

	public void refill() {
	}

	public String toString() {
		return "waiting for quarter";
	}

	public String stateAsText() {
		return "NoQuarter";
	}

}
