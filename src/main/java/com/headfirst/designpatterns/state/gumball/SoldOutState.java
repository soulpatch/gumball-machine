package com.headfirst.designpatterns.state.gumball;

public class SoldOutState implements State {
	GumballMachine gumballMachine;

	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public String insertQuarter() {
		return "You can't insert a quarter, the machine is sold out";
	}

	public String ejectQuarter() {
		return "You can't eject, you haven't inserted a quarter yet";
	}

	public String turnCrank() {
		return "You turned, but there are no gumballs";
	}

	public String dispense() {
		return "No gumball dispensed";
	}

	public void refill() {
		gumballMachine.transitionToNoQuarter();
	}

	public String toString() {
		return "sold out";
	}

	public String stateAsText() {
		return "OutOfGumballs";
	}
}
