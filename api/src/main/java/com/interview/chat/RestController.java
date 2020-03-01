package com.interview.chat;

import com.interview.chat.bots.Bot;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestController {
  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(path = "/chat/{bot}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, String>> getChat(@PathVariable String bot) {
    System.out.println(bot);
    Bot myBot = new BotFactory().getBot(bot);
    return ResponseEntity.ok(Map.of("message", myBot.getResponse()));
  }
}
