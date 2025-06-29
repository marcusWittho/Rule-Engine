package com.wittho.rule_engine.factory;

import java.time.Duration;
import java.time.Instant;

public class ConditionEvaluatorFactory {

  public static ConditionEvaluator get(String operator) {
    return switch(operator) {
      case "greater_than" -> (v, c) -> ((Number) v).doubleValue() > ((Number) c).doubleValue();
      case "less_than" -> (v, c) -> ((Number) v).doubleValue() < ((Number) c).doubleValue();
      case "equals" -> Object::equals;
      case "contains" -> (v, c) -> v.toString().contains(c.toString());
      case "starts_with" -> (v, c) -> v.toString().startsWith(c.toString());
      case "within_last_minutes" -> (v, c) -> {
        Instant ts = Instant.parse(v.toString());
        long mins = ((Number) c).longValue();
        return Duration.between(ts, Instant.now()).toMinutes() <= mins;
      };
      default -> throw new UnsupportedOperationException("Operator: " + operator);
    };
  }
}
