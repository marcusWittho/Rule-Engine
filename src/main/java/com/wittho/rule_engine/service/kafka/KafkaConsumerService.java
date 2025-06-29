package com.wittho.rule_engine.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wittho.rule_engine.service.RuleEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

  private final RuleEngineService ruleEngineService;
  private final ObjectMapper objectMapper;

  @KafkaListener(topics = "rules", groupId = "rule-engine")
  public void listenRules(String message) throws IOException {
    Map<String, Object> payload = objectMapper.readValue(message, Map.class);
    ruleEngineService.processPayload(payload);
  }
}
