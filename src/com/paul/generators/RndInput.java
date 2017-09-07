package com.paul.generators;

import java.util.Random;

public class RndInput {

  public String generate(int length) {
    final Random r = new Random(0xFACE);
    
    String s = "";

    for (int i = 0; i < length; i++) {
      s += r.nextBoolean() ? "1" : "0";
    }

    return s;
  }
}
