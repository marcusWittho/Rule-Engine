package com.wittho.rule_engine.factory;

public interface ConditionEvaluator {

  boolean evaluate(Object attributeValue, Object conditionValue);
}
