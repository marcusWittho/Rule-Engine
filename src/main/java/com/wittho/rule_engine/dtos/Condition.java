package com.wittho.rule_engine.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Condition {

  private String attribute;
  private String operator;
  private Object value;
}
