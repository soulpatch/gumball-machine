package com.headfirst.designpatterns.state.gumball;

public class SoldState implements State {
 
    GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
       
	public String insertQuarter() {
		return "Please wait, we're already giving you a gumball";
	}
 
	public String ejectQuarter() {
		return "Sorry, you already turned the crank";
	}
 
	public String turnCrank() {
		return "Turning twice doesn't get you another gumball!";
	}
 
	public String dispense() {
		StringBuffer result = new StringBuffer();

		result.append(gumballMachine.releaseBall());
		if (gumballMachine.numberGumballsInMachine() > 0) {
			gumballMachine.transitionToNoQuarter();
		} else {
			result.append("\nOops, out of gumballs!");
			gumballMachine.transtionToSoldOut();
		}
		return result.toString();
	}

	public void refill() {
	}
 
	public String toString() {
		return "dispensing a gumball";
	}

	public String stateAsText() {
		return "GumballSold";
	}

}


