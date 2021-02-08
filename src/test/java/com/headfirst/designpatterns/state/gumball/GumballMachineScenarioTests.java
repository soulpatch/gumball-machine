package com.headfirst.designpatterns.state.gumball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class GumballMachineScenarioTests {

  @Test
  public void headFirstBookOriginalScenarioTest() throws Exception {
    ConsoleAccumulator console = new ConsoleAccumulator();
    GumballMachine gumballMachine = new GumballMachine(5);

    // 5 gumballs ------------------------------------------------------------
    console.add(gumballMachine.machineStatus());

    console.add(gumballMachine.insertQuarter());
    console.add(gumballMachine.turnCrank());

    // 4 gumballs ------------------------------------------------------------
    console.add(gumballMachine.machineStatus());

    console.add(gumballMachine.insertQuarter());
    console.add(gumballMachine.ejectQuarter());
    console.add(gumballMachine.turnCrank());

    // 4 gumballs ------------------------------------------------------------
    console.add(gumballMachine.machineStatus());

    console.add(gumballMachine.insertQuarter());
    console.add(gumballMachine.turnCrank());
    console.add(gumballMachine.insertQuarter());
    console.add(gumballMachine.turnCrank());
    console.add(gumballMachine.ejectQuarter());

    // 2 gumballs ------------------------------------------------------------
    console.add(gumballMachine.machineStatus());

    console.add(gumballMachine.insertQuarter());
    console.add(gumballMachine.insertQuarter());
    console.add(gumballMachine.turnCrank());
    console.add(gumballMachine.insertQuarter());
    console.add(gumballMachine.turnCrank());
    console.add(gumballMachine.insertQuarter());
    console.add(gumballMachine.turnCrank());

    // 0 gumballs ------------------------------------------------------------
    console.add(gumballMachine.machineStatus());

    assertThat(console.toString())
        .isEqualTo("\n" +
                       "Mighty Gumball, Inc.\n" +
                       "Java-enabled Standing Gumball Model #2004\n" +
                       "Inventory: 5 gumballs\n" +
                       "Machine is waiting for quarter\n" +
                       "\n" +
                       "You inserted a quarter\n" +
                       "You turned...\n" +
                       "A gumball comes rolling out the slot...\n" +
                       "\n" +
                       "Mighty Gumball, Inc.\n" +
                       "Java-enabled Standing Gumball Model #2004\n" +
                       "Inventory: 4 gumballs\n" +
                       "Machine is waiting for quarter\n" +
                       "\n" +
                       "You inserted a quarter\n" +
                       "Quarter returned\n" +
                       "You turned, but there's no quarter\n" +
                       "You need to pay first\n" +
                       "\n" +
                       "Mighty Gumball, Inc.\n" +
                       "Java-enabled Standing Gumball Model #2004\n" +
                       "Inventory: 4 gumballs\n" +
                       "Machine is waiting for quarter\n" +
                       "\n" +
                       "You inserted a quarter\n" +
                       "You turned...\n" +
                       "A gumball comes rolling out the slot...\n" +
                       "You inserted a quarter\n" +
                       "You turned...\n" +
                       "A gumball comes rolling out the slot...\n" +
                       "You haven't inserted a quarter\n" +
                       "\n" +
                       "Mighty Gumball, Inc.\n" +
                       "Java-enabled Standing Gumball Model #2004\n" +
                       "Inventory: 2 gumballs\n" +
                       "Machine is waiting for quarter\n" +
                       "\n" +
                       "You inserted a quarter\n" +
                       "You can't insert another quarter\n" +
                       "You turned...\n" +
                       "A gumball comes rolling out the slot...\n" +
                       "You inserted a quarter\n" +
                       "You turned...\n" +
                       "A gumball comes rolling out the slot...\n" +
                       "Oops, out of gumballs!\n" +
                       "You can't insert a quarter, the machine is sold out\n" +
                       "You turned, but there are no gumballs\n" +
                       "No gumball dispensed\n" +
                       "\n" +
                       "Mighty Gumball, Inc.\n" +
                       "Java-enabled Standing Gumball Model #2004\n" +
                       "Inventory: 0 gumballs\n" +
                       "Machine is sold out\n" +
                       "\n");
  }
}
