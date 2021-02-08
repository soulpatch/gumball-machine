package com.headfirst.designpatterns.state.gumball;

//import java.util.Random;

public class HasQuarterState implements State {
	GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public String insertQuarter() {
		return "You can't insert another quarter";
	}

	public String ejectQuarter() {
		gumballMachine.transitionToNoQuarter();
		return "Quarter returned";
	}

	public String turnCrank() {
		gumballMachine.transtionToSold();
		return "You turned...";
	}

	public String dispense()	{
		return "No gumball dispensed";
	}

	public void refill() {
		return;
	}

	public String toString()	{
		return "waiting for turn of crank";
	}

	public String stateAsText() {
		return "HasQuarter";
	}
}
