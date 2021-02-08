package com.headfirst.designpatterns.state.gumball;

import java.util.Objects;

public class GumballMachine {

	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;

	int state = SOLD_OUT;
	int count = 0;

	public GumballMachine(int count) {
		this.count = count;
		if (count > 0) {
			state = NO_QUARTER;
		}
	}

	public String insertQuarter() {
		if (state == HAS_QUARTER) {
			return "You can't insert another quarter";
		} else if (state == NO_QUARTER) {
			state = HAS_QUARTER;
			return "You inserted a quarter";
		} else if (state == SOLD_OUT) {
			return "You can't insert a quarter, the machine is sold out";
		} else if (state == SOLD) {
			return "Please wait, we're already giving you a gumball << UNREACHABLE CODE";
		}
		return "insertQuarter() << UNREACHABLE CODE";
	}

	public String ejectQuarter() {
		if (state == HAS_QUARTER) {
			state = NO_QUARTER;
			return "Quarter returned";
		} else if (state == NO_QUARTER) {
			return "You haven't inserted a quarter";
		} else if (state == SOLD) {
			return "Sorry, you already turned the crank << UNREACHABLE CODE";
		} else if (state == SOLD_OUT) {
			return "You can't eject, you haven't inserted a quarter yet";
		}
		return "ejectQuarter() << UNREACHABLE CODE";
	}

	public String turnCrank() {
		StringBuffer result = new StringBuffer();
		if (state == SOLD) {
			result.append("Turning twice doesn't get you another gumball!  << UNREACHABLE CODE");
		} else if (state == NO_QUARTER) {
			result.append("You turned, but there's no quarter");
		} else if (state == SOLD_OUT) {
			result.append("You turned, but there are no gumballs");
		} else if (state == HAS_QUARTER) {
			result.append("You turned...\n");
			state = SOLD;
		}
		result.append(dispense());
		return result.toString();
	}

	private String dispense() {
		if (state == SOLD) {
			StringBuffer result = new StringBuffer();
			result.append("A gumball comes rolling out the slot...");
			count = count - 1;
			if (count == 0) {
				result.append("\nOops, out of gumballs!");
				state = SOLD_OUT;
			} else {
				state = NO_QUARTER;
			}
			return result.toString();
		} else if (state == NO_QUARTER) {
			return "\nYou need to pay first";
		} else if (state == SOLD_OUT) {
			return "\nNo gumball dispensed";
		} else if (state == HAS_QUARTER) {
			return "No gumball dispensed  << UNREACHABLE CODE";
		}
		return "dispense() << UNREACHABLE CODE";
	}

	public void refill(int numGumBalls) {
		this.count = numGumBalls;
		state = NO_QUARTER;
	}

	public String machineStatus() {
		StringBuffer result = new StringBuffer();

		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004\n");
		result.append("Inventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}

		result.append("\nMachine is ");
		if (state == SOLD_OUT) {
			result.append("sold out");
		} else if (state == NO_QUARTER) {
			result.append("waiting for quarter");
		} else if (state == HAS_QUARTER) {
			result.append("waiting for turn of crank");
		} else if (state == SOLD) {
			result.append("delivering a gumball");
		}
		result.append("\n");

		return result.toString();
	}

	public String currentState() {
		if (state == HAS_QUARTER) {
			return "HasQuarter";
		} else if (state == NO_QUARTER) {
			return "NoQuarter";
		} else if (state == SOLD_OUT) {
			return "OutOfGumballs";
		} else if (state == SOLD) {
			return "GumballSold";
		}
		return "";
	}
}
