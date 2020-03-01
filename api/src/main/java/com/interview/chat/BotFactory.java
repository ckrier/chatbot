package com.interview.chat;

import com.interview.chat.bots.AngryBot;
import com.interview.chat.bots.Bot;
import com.interview.chat.bots.DefaultBot;
import com.interview.chat.bots.GladBot;
import com.interview.chat.bots.SadBot;

public class BotFactory {

  public Bot getBot(String type) {
    switch (type.toUpperCase()) {
      case "MAD":
        return new AngryBot();
      case "SAD":
        return new SadBot();
      case "GLAD":
        return new GladBot();
      default:
        return new DefaultBot();
    }
  }
}
