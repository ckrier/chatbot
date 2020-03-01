package com.interview.chat.bots;

public class AngryBot extends Bot {

  @Override
  public String getResponse() {
    return getBaseMessage() + " >:(";
  }
}
