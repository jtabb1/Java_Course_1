
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.Random;

public class WordLengths {

  public void test__decrypt__tt00(){
    String message; int key;
    String encrypted; String decrypted;
    CaesarCipher cc = new CaesarCipher();

    message = "Hello there, meritocracies of America!"; key = 8;
    encrypted = cc.encrypt(message, key);
    decrypted = decrypt(encrypted);
    System.out.println("message: "+message);
    System.out.println("encrypted: "+encrypted);
    System.out.println("decrypted: "+decrypted);
    System.out.println();
    message = "Hello there, meritocracies of America!"; key = 21;
    encrypted = cc.encrypt(message, key);
    decrypted = decrypt(encrypted);
    System.out.println("message: "+message);
    System.out.println("encrypted: "+encrypted);
    System.out.println("decrypted: "+decrypted);
    System.out.println();
    message = "BananaRama_eeeeeee"; key = 22;
    encrypted = cc.encrypt(message, key);
    decrypted = decrypt(encrypted);
    System.out.println("message: "+message);
    System.out.println("encrypted: "+encrypted);
    System.out.println("decrypted: "+decrypted);
    System.out.println();
  }

  public void test__decrypt_new(){
    String encrypted;
    encrypted = "Lujyfwapvu huk zljbypaf hyl mbukhtluahs whyaz vm avkhf'z Pualyula.";
    encrypted = "lujyfwapvu huk zljbypaf hyl mbukhtluahs whyaz vm avkhf'z pualyula.".toUpperCase();
    System.out.println("encrypted: "+encrypted);
    System.out.println("decrypted: "+decrypt(encrypted));
    System.out.println();
    encrypted = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
    encrypted = "gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu".toUpperCase();
    System.out.println("encrypted: "+encrypted);
    System.out.println("decrypted: "+decrypt(encrypted));
    System.out.println();
  }
  
  public String decrypt(String encrypted){
    CaesarCipher cc = new CaesarCipher();
    int[] freqs = countLetters(encrypted);
    int maxDex = maxIndex(freqs);
    int dkey = maxDex - 4;
    if (maxDex < 4) {
      dkey = 26 - (4-maxDex);
    }
    return cc.encrypt(encrypted,26-dkey);
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

  public void simulate(int rolls){
    Random rand = new Random();
    int [] counts = new int [13];
    
    for(int k=0; k < rolls; k++){
      int d1 = rand.nextInt(6) + 1;
      int d2 = rand.nextInt(6) + 1;
      counts[d1 + d2] += 1;
    }
    for (int k=2; k <= 12; k++){
      System.out.println(k+"'s=\t"+counts[k]+"\t"+100.0*counts[k]/rolls);
    }
  }

  void countShakespeare(){
    String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt", 
                  "likeit.txt", "macbeth.txt", "romeo.txt"};
    String[] common = getCommon();
    int[] counts = new int[common.length];
    for (int k=0; k < plays.length; k++){
      FileResource resource = new FileResource(
                                    "CommonWordsData/" + plays[k]);
      countWords(resource, common, counts);
      System.out.println("done with " + plays[k]);
    }
    for (int k=0; k < common.length; k++){
      System.out.println(common[k] + "\t" + counts[k]);
    }
  }

  public int indexOf(String[] list, String word){
    for (int k = 0; k < list.length; k++){
      if (list[k].equals(word)){
        return k;
      }
    }
    return -1;
  }

  public void countWords(FileResource resource, String[] common, 
                          int[] counts){
    for (String word : resource.words()){
      word = word.toLowerCase();
      int index = indexOf(common, word);
      if (index != -1) {
        counts[index] += 1;
      }
    }
  }

  public String[] getCommon(){
    FileResource resource = new FileResource(
                                    "CommonWordsData/common.txt");
    String[] common = new String[20];
    int index = 0;
    for (String s : resource.words()){
      common[index] = s;
      index += 1;
    }
    return common;
  }

}
