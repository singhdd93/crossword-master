package com.crosswordmaster.brain;

public class Field {

  private int type;
  private String text;
  public static final int BLANK = 0;
  public static final int STRING = 1;
  public static final int LEGEND = 2;

  public int getType() {
      return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getText() {
      return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
