package com.paul.generators;

import java.util.Random;

public class RndInput {

  //Main 0xFACE, second 0xFEED
  public String generate(int length, int seed) {
    final Random r = new Random(seed);
    
    String s = "";

    for (int i = 0; i < length; i++) {
      s += r.nextBoolean() ? "1" : "0";
    }

    return s;
  }
}
