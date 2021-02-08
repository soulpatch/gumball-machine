package com.headfirst.designpatterns.state.gumball;

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);

		System.out.println(gumballMachine.machineStatus());

		System.out.println(gumballMachine.insertQuarter());
		System.out.println(gumballMachine.turnCrank());

		System.out.println(gumballMachine.machineStatus());

		System.out.println(gumballMachine.insertQuarter());
		System.out.println(gumballMachine.ejectQuarter());
		System.out.println(gumballMachine.turnCrank());

		System.out.println(gumballMachine.machineStatus());

		System.out.println(gumballMachine.insertQuarter());
		System.out.println(gumballMachine.turnCrank());
		System.out.println(gumballMachine.insertQuarter());
		System.out.println(gumballMachine.turnCrank());
		System.out.println(gumballMachine.ejectQuarter());

		System.out.println(gumballMachine.machineStatus());

		System.out.println(gumballMachine.insertQuarter());
		System.out.println(gumballMachine.insertQuarter());
		System.out.println(gumballMachine.turnCrank());
		System.out.println(gumballMachine.insertQuarter());
		System.out.println(gumballMachine.turnCrank());
		System.out.println(gumballMachine.insertQuarter());
		System.out.println(gumballMachine.turnCrank());

		System.out.println(gumballMachine.machineStatus());

	}

}
