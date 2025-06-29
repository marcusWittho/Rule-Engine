package com.wittho.rule_engine.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rule {

  private String name;
  private List<Condition> conditions;
  private Consequence consequence;
}
