package com.headfirst.designpatterns.state.gumball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GumballMachineStateTransitionTests {

  private static final int MUST_BE_ONE_GUMBALL = 1;

  @Test
  public void newGumballMachineInNoQuarterState() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(6);

    assertThat(gumballMachine.currentState())
        .isEqualTo("NoQuarter");
  }

  @Test
  public void insertQuarterTransitionsToHasQuarter() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(3);

    gumballMachine.insertQuarter();

    assertThat(gumballMachine.currentState())
        .isEqualTo("HasQuarter");
  }

  @Test
  public void ejectQuarterTransitionsFromHasQuarterToNoQuarter() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(3);
    gumballMachine.insertQuarter();

    gumballMachine.ejectQuarter();

    assertThat(gumballMachine.currentState())
        .isEqualTo("NoQuarter");
  }

  @Test
  public void turnCrankWithSeveralGumballsTransitionsFromHasQuarterToNoQuarter() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(3);
    gumballMachine.insertQuarter();

    gumballMachine.turnCrank();

    assertThat(gumballMachine.currentState())
        .isEqualTo("NoQuarter");
  }

  @Test
  public void turnCrankWithOneGumballTransitionsToOutOfGumballs() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(MUST_BE_ONE_GUMBALL);
    gumballMachine.insertQuarter();

    gumballMachine.turnCrank();

    assertThat(gumballMachine.currentState())
        .isEqualTo("OutOfGumballs");
  }
}
