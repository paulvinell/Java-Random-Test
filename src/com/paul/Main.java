package com.paul;

import com.paul.Analyzer.Analysis;
import com.paul.generators.HumanInput;
import com.paul.generators.RndInput;
import com.paul.generators.TrueRndInput;

public class Main {

  public static void main(String[] args) {
    Analyzer a = new Analyzer(new RndInput().generate(3000, 0xFACE));

    for (int size = 1; size <= 6; size++) {
      a.run(size);
    }

    for (Analysis run : a.runs) {
      System.out.println(run.size + " " + 100 * run.averageRelDiff() + "%");
    }
  }
}