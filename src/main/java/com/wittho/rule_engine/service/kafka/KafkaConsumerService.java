package com.wittho.rule_engine.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

  @KafkaListener(topics = "rules", groupId = "rule-engine")
  public void listen(String message) {
    System.out.println("Mensagem recebida: " + message);
  }
}
