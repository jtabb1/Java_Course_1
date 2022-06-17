
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarBreaker {

  public void test__decryptTwoKeys(){
    String expected; String output;
    String input;
    boolean isPassed;
    input = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
    expected = "Just a test string with lots of eeeeeeeeeeeeeeeees";
    output = decryptTwoKeys(input);
    isPassed = output.equals(expected);
    System.out.println("input: "+input);
    System.out.println("expected output: "+expected);
    System.out.println("  actual output: "+output);
    System.out.println("Did the test pass? "+isPassed);
    System.out.println();
    input = "Lujyfwapvu huk zljbypaf hyl mbukhtluahs whyaz vm avkhf'z Pualyula.";
    expected = "Encryption and security are fundamental parts of today's Internet.";
    output = decrypt(input,7);
    isPassed = output.equals(expected);
    System.out.println("input: "+input);
    System.out.println("expected output: "+expected);
    System.out.println("  actual output: "+output);
    System.out.println("Did the test pass? "+isPassed);
    System.out.println();
    /* *
    input = "Lujyfwapvu huk zljbypaf hyl mbukhtluahs whyaz vm avkhf'z Pualyula.";
    System.out.println("input: "+input);
    output = decrypt(input,0); System.out.println("  actual output: "+output);
    output = decrypt(input,1); System.out.println("  actual output: "+output);
    output = decrypt(input,2); System.out.println("  actual output: "+output);
    output = decrypt(input,3); System.out.println("  actual output: "+output);
    output = decrypt(input,4); System.out.println("  actual output: "+output);
    output = decrypt(input,5); System.out.println("  actual output: "+output);
    output = decrypt(input,6); System.out.println("  actual output: "+output);
    output = decrypt(input,7); System.out.println("  actual output: "+output);
    output = decrypt(input,8); System.out.println("  actual output: "+output);
    output = decrypt(input,9); System.out.println("  actual output: "+output);
    output = decrypt(input,10); System.out.println("  actual output: "+output);
    output = decrypt(input,11); System.out.println("  actual output: "+output);
    output = decrypt(input,12); System.out.println("  actual output: "+output);
    output = decrypt(input,13); System.out.println("  actual output: "+output);
    output = decrypt(input,14); System.out.println("  actual output: "+output);
    output = decrypt(input,15); System.out.println("  actual output: "+output);
    output = decrypt(input,16); System.out.println("  actual output: "+output);
    output = decrypt(input,17); System.out.println("  actual output: "+output);
    output = decrypt(input,18); System.out.println("  actual output: "+output);
    output = decrypt(input,19); System.out.println("  actual output: "+output);
    output = decrypt(input,20); System.out.println("  actual output: "+output);
    output = decrypt(input,21); System.out.println("  actual output: "+output);
    output = decrypt(input,22); System.out.println("  actual output: "+output);
    output = decrypt(input,23); System.out.println("  actual output: "+output);
    output = decrypt(input,24); System.out.println("  actual output: "+output);
    output = decrypt(input,25); System.out.println("  actual output: "+output);
    System.out.println();
    /* */
  }

  public String decryptTwoKeys(String encrypted){
    String encr1 = halfOfString(encrypted,0);
    String encr2 = halfOfString(encrypted,1);
    int key1 = getKey(encr1);
    int key2 = getKey(encr2);
    System.out.println("possible key #1 = "+key1+", possible key #2 = "+key2);
    CaesarCipher cc = new CaesarCipher();
    String decrypted = cc.encryptTwoKeys(encrypted,26-key1,26-key2);
    return decrypted;
  }

  public String decryptTwoKeys(String encrypted, int key1, int key2){
    CaesarCipher cc = new CaesarCipher();
    String decrypted = cc.encryptTwoKeys(encrypted,26-key1,26-key2);
    return decrypted;
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

  public void test__halfOfString(){
    String expected; String output;
    String input; int start;
    boolean isPassed;
    input = "Qbkm Zgis"; start = 0; expected = "Qk gs";
    output = halfOfString(input, start);
    isPassed = output.equals(expected);
    System.out.println("input: "+input+", start: "+start);
    System.out.println("expected output: "+expected);
    System.out.println("  actual output: "+output);
    System.out.println("Did the test pass? "+isPassed);
    System.out.println();
    input = "Qbkm Zgis"; start = 1; expected = "bmZi";
    output = halfOfString(input, start);
    isPassed = output.equals(expected);
    System.out.println("input: "+input+", start: "+start);
    System.out.println("expected output: "+expected);
    System.out.println("  actual output: "+output);
    System.out.println("Did the test pass? "+isPassed);
    System.out.println();
  }

  public String halfOfString(String input, int start){
    StringBuilder sb = new StringBuilder();
    for(int i=start; i<input.length(); i+=2){
      sb.append(input.charAt(i));
    }
    return sb.toString();
  }

  public void testDecrypt(){
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

  public String decrypt(String encrypted, int dkey){
    CaesarCipher cc = new CaesarCipher();
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
  
}
