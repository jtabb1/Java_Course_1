
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class CaesarCipherTwo {
  private String letters;
  private String shiftedLetters1;
  private int mainKey1;
  private String shiftedLetters2;
  private int mainKey2;

  public CaesarCipherTwo(int key1, int key2){
    mainKey1 = key1;
    mainKey2 = key2;
    letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    shiftedLetters1 = letters.substring(key1)
                    + letters.substring(0,key1);
    shiftedLetters2 = letters.substring(key2)
                    + letters.substring(0,key2);
  }

  public int getKey1(){return mainKey1;}
  public int getKey2(){return mainKey2;}

  public String breakCaesarCipher(String encrypted){
    return decryptFindingBothKeys(encrypted);
  }
  
  public String decrypt(String encrypted){
    return decryptFindingBothKeys(encrypted);
  }
  
  public String encrypt(String input) {
    return encryptBothKeysFaster(input);
  }

  public String decryptFindingBothKeys(String encrypted){
    String encr1 = halfOfString(encrypted,0);
    String encr2 = halfOfString(encrypted,1);
    int key1 = getKey(encr1);
    int key2 = getKey(encr2);
    System.out.println("possible key #1 = "+key1+", possible key #2 = "+key2);
    CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
    String decrypted = cc.encryptBothKeysFaster(encrypted,26-key1,26-key2);
    return decrypted;
  }

  public String decryptHavingBothKeys(String encrypted, int key1, int key2){
    String decrypted = encryptBothKeysFaster(encrypted,26-key1,26-key2);
    return decrypted;
  }

  public String encryptBothKeysFaster(String input) {
    return encryptBothKeysFaster(input, mainKey1, mainKey2);
  }

  public String encryptBothKeysFaster(String input, int key1, int key2) {
    CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
    StringBuilder out = new StringBuilder(input);
    for (int i = 0; i < out.length(); i+=2) {
      out.setCharAt(i, getEncryptedChar(out.charAt(i), cc.shiftedLetters1));
    }
    for (int i = 1; i < out.length(); i+=2) {
      out.setCharAt(i, getEncryptedChar(out.charAt(i), cc.shiftedLetters2));
    }
    return out.toString();
  }

  public char getEncryptedChar(char ch, String shifted){
    int k = letters.indexOf(Character.toUpperCase(ch));
    if (k != -1) {
      if (Character.isLowerCase(ch)) {
        ch = Character.toLowerCase(shifted.charAt(k));
      } else {
        ch = shifted.charAt(k);
      }
    }
    return ch;
  }

  public String encryptBothKeys(String input) {
    return encryptBothKeys(input, mainKey1, mainKey2);
  }

  public String encryptBothKeys(String input, int key1, int key2) {
    StringBuilder sb1 = new StringBuilder(encrypt(input,key1));
    StringBuilder sb2 = new StringBuilder(encrypt(input,key2));
    for (int i = 0; i < sb1.length(); i++){
      if (i%2 == 1){
        sb1.setCharAt(i, sb2.charAt(i));
      }
    }
    return sb1.toString();
  }

  public String encrypt(String input, int key) {
    StringBuilder out = new StringBuilder(input);
    String shifted = letters.substring(key) + letters.substring(0,key);
    for (int i = 0; i < out.length(); i++) {
      int k = letters.indexOf(Character.toUpperCase(out.charAt(i)));
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

  public String halfOfString(String input, int start){
    StringBuilder sb = new StringBuilder();
    for(int i=start; i<input.length(); i+=2){
      sb.append(input.charAt(i));
    }
    return sb.toString();
  }

  public int getKey(String encrypted){
    int[] freqs = countLetters(encrypted);
    int maxDex = maxIndex(freqs);
    int dkey = maxDex - 4;
    if (maxDex < 4) {
      dkey = 26 - (4-maxDex);
    }
    return dkey;
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
  
  public int maxIndex(int[] vals){
    int maxDex = 0;
    for (int k=0; k < vals.length; k++){
      if (vals[k] > vals[maxDex]){
        maxDex = k;
      }
    }
    return maxDex;
  }
}
