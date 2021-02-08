package com.headfirst.designpatterns.state.gumball;

public class GumballMachine {

	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;

	State currentState;
	int gumballInventory = 0;

	public GumballMachine(int initialGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);

		gumballInventory = initialGumballs;

		if (haveGumballs()) {
			transitionToNoQuarter();
		} else {
			transtionToSoldOut();
		}
	}

	void transtionToSoldOut() {
		currentState = soldOutState;
	}

	void transitionToHasQuarter() {
		currentState = hasQuarterState;
	}

	void transtionToSold() {
		currentState = soldState;
	}

	void transitionToNoQuarter() {
		currentState = noQuarterState;
	}

	private boolean haveGumballs() {
		return gumballInventory > 0;
	}

	public String insertQuarter() {
		return currentState.insertQuarter();
	}

	public String ejectQuarter() {
		return currentState.ejectQuarter();
	}

	public String turnCrank() {
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append(currentState.turnCrank());
		stringBuffer.append("\n");
		stringBuffer.append(currentState.dispense());

		return stringBuffer.toString();
	}

	String releaseBall() {
		if (haveGumballs()) {
			--gumballInventory;
		}
		return "A gumball comes rolling out the slot...";
	}

	int numberGumballsInMachine() {
		return gumballInventory;
	}

	void refill(int count) {
		gumballInventory += count;
		System.out.println("The gumball machine was just refilled; its new count is: " + gumballInventory);
		currentState.refill();
	}

	public String currentState() {
		return currentState.stateAsText();
	}

	public String machineStatus() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("\nMighty Gumball, Inc.");
		stringBuffer.append("\nJava-enabled Standing Gumball Model #2004\n");

		stringBuffer.append("Inventory: " + gumballInventory + " gumball");
				if (gumballInventory != 1) {
			stringBuffer.append("s");
		}

		stringBuffer.append("\n");
		stringBuffer.append("Machine is " + currentState);
		stringBuffer.append("\n");

		return stringBuffer.toString();
	}
}
