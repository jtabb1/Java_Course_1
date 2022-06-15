
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class CaesarCipher {

  public void test__testCaesar(){
    int key = 3;
    FileResource fr = new FileResource();
    String message = fr.asString();
    String encrypted = encrypt(message, key);
    System.out.println("key is " + key + "\n" + encrypted);
  }

  public void test__encryptTwoKeys(){
    String input; int key1; int key2;

    input = "First Legion"; key1 = 23; key2 = 17;
    System.out.println("input: "+input+", key1: "+key1+", key2: "+key2);
    System.out.println("encrypted: "+encryptTwoKeys(input, key1, key2));
    System.out.println();
    input = "First Legion"; key1 = 23;
    System.out.println("input: "+input+", key1: "+key1);
    System.out.println("encrypted: "+encrypt(input, key1));
    System.out.println();
    input = "First Legion"; key1 = 17;
    System.out.println("input: "+input+", key1: "+key1);
    System.out.println("encrypted: "+encrypt(input, key1));
    System.out.println();
  }

  public String encryptTwoKeys(String input, int key1, int key2) {
    StringBuilder sb1 = new StringBuilder(encrypt(input,key1));
    StringBuilder sb2 = new StringBuilder(encrypt(input,key2));
    for (int i = 0; i < sb1.length(); i++){
      if (i%2 == 1){
        sb1.setCharAt(i, sb2.charAt(i));
      }
    }
    return sb1.toString();
  }

  public void test__encrypt(){
    String input; int key;

    input = "FIRST LEGION ATTACK EAST FLANK!"; key = 23;
    System.out.println("input: "+input+", key: "+key);
    System.out.println("encrypted: "+encrypt(input, key));
    System.out.println();
    input = "First Legion"; key = 23;
    System.out.println("input: "+input+", key: "+key);
    System.out.println("encrypted: "+encrypt(input, key));
    System.out.println();
    input = "First Legion"; key = 17;
    System.out.println("input: "+input+", key: "+key);
    System.out.println("encrypted: "+encrypt(input, key));
    System.out.println();    
  }

  public String encrypt(String input, int key) {
    StringBuilder out = new StringBuilder(input);
    String ltrs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String shifted = ltrs.substring(key) + ltrs.substring(0,key);
    for (int i = 0; i < out.length(); i++) {
      int k = ltrs.indexOf(Character.toUpperCase(out.charAt(i)));
      if (k != -1) {
        if (Character.isLowerCase(out.charAt(i))) {
          out.setCharAt(i, Character.toLowerCase(shifted.charAt(k)));
        } else {
          out.setCharAt(i, shifted.charAt(k));
        }
      }
    }
    return out.toString();
  }

}
