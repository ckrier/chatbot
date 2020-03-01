package com.interview.chat.bots;

import java.util.Random;

public abstract class Bot {
  String getBaseMessage() {
    return new Random(System.currentTimeMillis()).nextBoolean() ? "Yes" : "No";
  }

  public abstract String getResponse();
}
