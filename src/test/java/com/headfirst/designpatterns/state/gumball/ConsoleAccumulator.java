package com.headfirst.designpatterns.state.gumball;

public class ConsoleAccumulator {
  StringBuffer stringBuffer = new StringBuffer();

  public ConsoleAccumulator() {
  }

  void add(String string) {
    stringBuffer.append(string).append("\n");
  }

  void print() {
    System.out.println(stringBuffer.toString());
  }

  @Override
  public String toString() {
    return stringBuffer.toString();
  }
}
