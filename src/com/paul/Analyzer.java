package com.paul;

import java.util.ArrayList;
import java.util.HashMap;

public class Analyzer {

  public final String input;
  public ArrayList<Analysis> runs = new ArrayList<Analysis>();

  public Analyzer(String input) {
    this.input = input;
  }

  public Analysis run(int size) {
    HashMap<String, Integer> h = new HashMap<String, Integer>();

    for (int i = size; i < input.length(); i += size) {
      String c = input.substring(i - size, i);
      if (h.containsKey(c)) {
        h.put(c, h.get(c) + 1);
      } else {
        h.put(c, 1);
      }
    }

    return new Analysis(size, h);
  }

  public Analysis getAnalysisBySize(int size) {
    for (Analysis a : runs) {
      if (size == a.size) {
        return a;
      }
    }
    return null;
  }

  public class Analysis {

    public int size;
    public HashMap<String, Integer> values = new HashMap<String, Integer>();

    private Analysis(int size, HashMap<String, Integer> values) {
      this.size = size;
      this.values = values;

      runs.add(this);
    }

    private double average() {
      int total = 0;

      for (String key : values.keySet()) {
        total += values.get(key);
      }

      return (double) total / values.size();
    }


    public double averageRelDiff() {
      double diff = 0;
      double avg = average();

      for (String key : values.keySet()) {
        diff += Math.abs(1 - (values.get(key) / avg));
      }

      return (double) diff / values.size();
    }
  }
}
