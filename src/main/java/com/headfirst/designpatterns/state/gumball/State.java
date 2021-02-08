package com.headfirst.designpatterns.state.gumball;

public interface State {
 
	public String insertQuarter();
	public String ejectQuarter();
	public String turnCrank();
	public String dispense();

	public void refill();

	public String stateAsText();
}
