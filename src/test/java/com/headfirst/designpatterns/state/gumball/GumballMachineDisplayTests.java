package com.headfirst.designpatterns.state.gumball;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GumballMachineDisplayTests {

  private static final int MUST_BE_ONE_GUMBALL = 1;

  ///////////////////////// Happy  Paths
  @Test
  public void createGumballMachine() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(65);

    assertThat(gumballMachine.machineStatus())
        .isEqualTo("\n" +
                       "Mighty Gumball, Inc.\n" +
                       "Java-enabled Standing Gumball Model #2004\n" +
                       "Inventory: 65 gumballs\n" +
                       "Machine is waiting for quarter\n");
  }

  @Test
  public void whenNoQuarterAndInsertQuarterMachineDisplaysInsertedQuarter() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(1);

    String display = gumballMachine.insertQuarter();

    assertThat(display)
        .isEqualTo("You inserted a quarter");
  }

  @Test
  public void whenHasQuarterAndEjectQuarterMachineDisplaysQuarterReturned() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(4);

    gumballMachine.insertQuarter();
    String display = gumballMachine.ejectQuarter();

    assertThat(display)
        .isEqualTo("Quarter returned");

  }

  @Test
  public void whenHasQuarterWithGumballsAndTurnCrankMachineDisplaysYouTurnedGumballRollsOut() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(4);

    gumballMachine.insertQuarter();
    String display = gumballMachine.turnCrank();

    assertThat(display)
        .isEqualTo("You turned...\n" +
                   "A gumball comes rolling out the slot...");

  }

  @Test
  public void whenHasQuarterWithOneGumballAndTurnCrankMachineDisplaysYouTurnedGumballRollsOutOopsOutOfGumballs() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(MUST_BE_ONE_GUMBALL);

    gumballMachine.insertQuarter();
    String display = gumballMachine.turnCrank();

    assertThat(display)
        .isEqualTo("You turned...\n" +
                   "A gumball comes rolling out the slot...\n" +
                   "Oops, out of gumballs!");

  }


  ///////////////////////// Failure Paths

  @Test
  public void whenNoQuarterAndEjectsQuarterMachineDisplaysYouDidntInsertAQuarter() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(3);

    String display = gumballMachine.ejectQuarter();

    assertThat(display)
        .isEqualTo("You haven't inserted a quarter");
  }

  @Test
  public void whenNoQuarterAndTurnsCrankMachineDisplaysNeedToPayFirst() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(7);

    String display = gumballMachine.turnCrank();

    assertThat(display)
        .isEqualTo("You turned, but there's no quarter\n" +
                       "You need to pay first");
  }

  @Test
  public void whenHasQuarterAndInsertQuarterMachineDisplaysYouCantInsertAnotherQuarter() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(7);

    gumballMachine.insertQuarter();
    String display = gumballMachine.insertQuarter();

    assertThat(display)
        .isEqualTo("You can't insert another quarter");
  }

  @Disabled("Test Disabled because trying to test an black-box unreachable state/code branch")
  @Test
  public void whenGumballSoldAndInsertQuarterMachineDisplaysYouCantInsertAnotherQuarter() throws Exception {
    GumballMachine gumballMachine = new GumballMachine(7);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    String display = gumballMachine.insertQuarter();

    assertThat(display)
        .isEqualTo("You can't insert another quarter");
  }

  @Test
  public void whenOutOfGumballsAndInsertQuarterMachineDisplaysSoldOut() throws Exception {
    GumballMachine gumballMachine = createGumballMachineWithOneGumball();

    String display = gumballMachine.insertQuarter();

    assertThat(display)
        .isEqualTo("You can't insert a quarter, the machine is sold out");

  }

  @Test
  public void whenOutOfGumballsAndEjectQuarterMachineDisplaysYouCantEject() throws Exception {
    GumballMachine gumballMachine = createGumballMachineWithOneGumball();

    String display = gumballMachine.ejectQuarter();

    assertThat(display)
        .isEqualTo("You can't eject, you haven't inserted a quarter yet");

  }

  @Test
  public void whenOutOfGumballsAndTurnCrankMachineDisplaysButThereAreNoGumballs() throws Exception {
    GumballMachine gumballMachine = createGumballMachineWithOneGumball();

    String display = gumballMachine.turnCrank();

    assertThat(display)
        .isEqualTo("You turned, but there are no gumballs\n" +
                   "No gumball dispensed");
  }

  private GumballMachine createGumballMachineWithOneGumball() {
    GumballMachine gumballMachine = new GumballMachine(MUST_BE_ONE_GUMBALL);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    return gumballMachine;
  }

}
