package com.interview.chat.bots;

public class GladBot extends Bot {

  @Override
  public String getResponse() {
    return getBaseMessage() + " :)";
  }
}
