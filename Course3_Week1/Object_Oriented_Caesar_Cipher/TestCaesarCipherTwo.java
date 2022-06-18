
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class TestCaesarCipherTwo {

  public void simpleTests__for__Quiz__9(){
    CaesarCipherTwo cc0 = new CaesarCipherTwo(0, 0);
    FileResource fr = new FileResource();
    String encrypted0 = fr.asString();
    System.out.println(encrypted0);
    System.out.println(cc0.decryptFindingBothKeys(encrypted0));
  }

  public void simpleTests__for__Quiz__7(){
    CaesarCipherTwo cc0 = new CaesarCipherTwo(0, 0);
    String encrypted0 = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
    System.out.println(encrypted0);
    System.out.println(cc0.decryptFindingBothKeys(encrypted0));
  }

  public void simpleTests__for__Quiz__6(){
    int key1_0 = 14; int key2_0 = 24;
    CaesarCipherTwo cc0 = new CaesarCipherTwo(key1_0, key2_0);
    String encrypted0 = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
    System.out.println(encrypted0);
    System.out.println(cc0.decryptHavingBothKeys(encrypted0,key1_0,key2_0));
  }

  public void simpleTests__for__Quiz__2(){
    int key1_0 = 21; int key2_0 = 8;
    CaesarCipherTwo cc0 = new CaesarCipherTwo(key1_0, key2_0);
    String message;
    message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
    String encrypted0 = cc0.encrypt(message);
    int key1_1 = 16; int key2_1 = 4;
    CaesarCipherTwo cc1 = new CaesarCipherTwo(key1_1, key2_1);
    String encrypted1 = cc1.encrypt(message);
    System.out.println(message);
    System.out.println("key0: ("+cc0.getKey1()+", "+cc0.getKey2()+")");
    System.out.println(encrypted0);
    System.out.println(cc0.decryptHavingBothKeys(encrypted0,key1_0,key2_0));
    System.out.println("key1: ("+cc1.getKey1()+", "+cc1.getKey2()+")");
    String decrypted0 = cc1.breakCaesarCipher(encrypted0);
    System.out.println(encrypted1);
    System.out.println(decrypted0);
  }

  public void simpleTests(){
    int key1_0 = 17; int key2_0 = 3;
    CaesarCipherTwo cc0 = new CaesarCipherTwo(key1_0, key2_0);
    FileResource fr = new FileResource();
    String message = fr.asString();
    String encrypted0 = cc0.encrypt(message);
    int key1_1 = 16; int key2_1 = 4;
    CaesarCipherTwo cc1 = new CaesarCipherTwo(key1_1, key2_1);
    String encrypted1 = cc1.encrypt(message);
    System.out.println(message);
    System.out.println("key0: ("+cc0.getKey1()+", "+cc0.getKey2()+")");
    System.out.println(encrypted0);
    System.out.println(cc0.decryptHavingBothKeys(encrypted0,key1_0,key2_0));
    System.out.println("key1: ("+cc1.getKey1()+", "+cc1.getKey2()+")");
    String decrypted0 = cc1.breakCaesarCipher(encrypted0);
    System.out.println(encrypted1);
    System.out.println(decrypted0);
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
