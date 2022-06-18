
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class TestCaesarCipher {

  public void simpleTests__Quiz(){
    int key = 15;
    CaesarCipher cc = new CaesarCipher(key);
    //FileResource fr = new FileResource();
    //String message = fr.asString();
    String message;
    message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
    String encrypted = cc.encrypt(message);
    String decrypted = cc.decryptFromKey(encrypted);
    System.out.println(message);
    System.out.println(key);
    System.out.println(encrypted);
    System.out.println(decrypted);
  }

  public void simpleTests1(){
    int key0 = 20; int key1 = 11;
    CaesarCipher cc0 = new CaesarCipher(key0);
    FileResource fr = new FileResource();
    String message = fr.asString();
    String encrypted0 = cc0.encrypt(message);
    CaesarCipher cc1 = new CaesarCipher(key1);
    String encrypted1 = cc1.encrypt(message);
    String decrypted0 = cc1.breakCaesarCipher(encrypted0);
    System.out.println(message);
    System.out.println("key0: "+key0);
    System.out.println(encrypted0);
    System.out.println("key1: "+cc1.getKey());
    System.out.println(encrypted1);
    System.out.println(decrypted0);
    //System.out.println(breakCaesarCipher(encrypted));
  }

  public String breakCaesarCipher(String encrypted){
    int[] freqs = countLetters(encrypted);
    int maxDex = maxIndex(freqs);
    int dkey = maxDex - 4;
    if (maxDex < 4) {
      dkey = 26 - (4-maxDex);
    }
    CaesarCipher cc = new CaesarCipher(dkey);
    return cc.decryptFromKey(encrypted);
  }

  public void simpleTests0(){
    int key = 18;
    CaesarCipher cc = new CaesarCipher(key);
    FileResource fr = new FileResource();
    String message = fr.asString();
    String encrypted = cc.encrypt(message);
    String decrypted = cc.decryptFromKey(encrypted);
    System.out.println(message);
    System.out.println(key);
    System.out.println(encrypted);
    System.out.println(decrypted);
  }

  public String halfOfString(String input, int start){
    StringBuilder sb = new StringBuilder();
    for(int i=start; i<input.length(); i+=2){
      sb.append(input.charAt(i));
    }
    return sb.toString();
  }

  public int maxIndex(int[] vals){
    int maxDex = 0;
    for (int k=0; k < vals.length; k++){
      if (vals[k] > vals[maxDex]){
        maxDex = k;
      }
    }
    return maxDex;
  }

  public int[] countLetters(String message){
    int[] counts = new int[26];
    String alph = "abcdefghijklmnopqrstuvwxyz";
    for (int k=0; k < message.length(); k++){
      char ch = Character.toLowerCase(message.charAt(k));
      int dex = alph.indexOf(ch);
      if (dex != -1){
        counts[dex] += 1;
      }
    }
    return counts;
  }

}
