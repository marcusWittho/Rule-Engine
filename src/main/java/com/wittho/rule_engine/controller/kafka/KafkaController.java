package com.wittho.rule_engine.controller.kafka;

import com.wittho.rule_engine.service.kafka.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

  private final KafkaProducerService producerService;

  public KafkaController(KafkaProducerService producerService) {
    this.producerService = producerService;
  }

  @PostMapping("/send")
  public String sendMessage(@RequestParam String message) {
    producerService.sendMessage("rules", "key", message);
    return "Mensagem enviada";
  }
}
