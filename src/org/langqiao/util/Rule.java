package org.langqiao.util;

import java.io.Serializable;

public class Rule implements Serializable{
  private static final long serialVersionUID = 1L;
  private String field;
  private String op;
  private String value;
  private String type;

  public String getField(){
    return this.field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getOp() {
    return this.op;
  }

  public void setOp(String op) {
    this.op = op;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
