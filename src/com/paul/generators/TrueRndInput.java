package com.paul.generators;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TrueRndInput {

  public String generate3k() {
    return returnFromFile("result3k.txt");
  }
  
  public String generate200k() {
    return returnFromFile("result200k.txt");
  }
  
  public String generate1m() {
    return returnFromFile("result_big.txt");
  }
  
  private String returnFromFile(String file) {
    String s = "";
    
    try {
      BufferedReader in = new BufferedReader(new FileReader(file));
        s = in.readLine();
        in.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return s;
  }
}
