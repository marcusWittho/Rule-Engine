package com.wittho.rule_engine.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wittho.rule_engine.dtos.Rule;
import com.wittho.rule_engine.dtos.RuleSet;
import com.wittho.rule_engine.factory.ConditionEvaluator;
import com.wittho.rule_engine.factory.ConditionEvaluatorFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class RuleEngineService {

  private final ObjectMapper objectMapper = new ObjectMapper();
  private RuleSet ruleSet;

  @PostConstruct
  public void loadRules() throws IOException {
    ruleSet = objectMapper.readValue(new File("rules.json"), RuleSet.class);
  }

  public void processPayload(Map<String, Object> payload) {
    for (Rule rule : ruleSet.getRules()) {
      boolean allMatch = rule.getConditions().stream().allMatch(cond -> {
        Object payloadValue = payload.get(cond.getAttribute());
        ConditionEvaluator eval = ConditionEvaluatorFactory.get(cond.getOperator());
        return eval.evaluate(payloadValue, cond.getValue());
      });

      if (allMatch) {
        System.out.printf("[AÇÃO] %s: %s\n", rule.getConsequence().getType(),
            rule.getConsequence().getMessage());
      }
    }
  }
}
