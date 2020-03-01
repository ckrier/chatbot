package com.interview.chat.bots;

public class DefaultBot extends Bot {

  @Override
  public String getResponse() {
    return getBaseMessage();
  }
}
