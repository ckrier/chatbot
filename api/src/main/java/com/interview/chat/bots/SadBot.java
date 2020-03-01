package com.interview.chat.bots;

public class SadBot extends Bot {

  @Override
  public String getResponse() {
    return getBaseMessage() + " :(";
  }
}
