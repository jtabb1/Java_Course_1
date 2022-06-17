
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
    input = "Top ncmy qkff vi vguv vbg ycpx";
    expected = "?";
    output = decryptTwoKeys(input,2,20);
    isPassed = output.equals(expected);
    System.out.println("input: "+input);
    System.out.println("expected output: "+expected);
    System.out.println("  actual output: "+output);
    System.out.println("Did the test pass? "+isPassed);
    System.out.println();
    input = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
    expected = "?";
    output = decryptTwoKeys(input);
    isPassed = output.equals(expected);
    System.out.println("input: "+input);
    System.out.println("expected output: "+expected);
    System.out.println("  actual output: "+output);
    System.out.println("Did the test pass? "+isPassed);
    System.out.println();
    input = "Xifqvximt tsdtlxzrx iijirvtl ek Uybi afvbw yehvv xyi gfqdse iekmfrrpzdrxzse fj xyi jzich sw tsdtlxrxzseec xifqvxic, fjkie xmmie zr xyi trwk, xyek klv nsipu rvfyeh yj zw xyvvi-hzqvrjmfrrp eeh ulijxzsew lfa xymekj zr xymj nsipu iiceki xf vetl sklvv eii melvvvrkpp xifqvximt. Xrov dsmmek e tzees xyvfyxl e hfsi-wvrqv rru gprremek e jcmxlk-gekl xyek rzfmuw gfpcmjmfrj nmkl sklvv ezvgprrvw ej kaf vbrqgpvw. Zx wyslpu klvvvjfvv esk jyitimji xyek tsdtlxzrx gvftvvkmvw esslx xyiji kvsdikvzg xymekj rru klvmi zrkiietxzse rvv tsdqfr-tceti eeh mdtfvkeex. Nlzpv klzw mj jxzpc r mecmu rvxydiex, ni afych pzov ks edieh xyek dsjx sw klv xifqvximt hyvwkmfrj giftci gfrtiir xyidwvpmij nmkl lrzv ks hf nmkl lfa xymekj rvv tservgkiu. Mk zw mdtfvkeex xyek ymxlnepw eii wljwmtmvrkpp jxiezkyx eeh wdsfxy ks wltgsix xyi himmmek sw wejx grvj, flx eesklvv ijwvrkmrp tisgiixp, aymtl av lwlecpp kebi jfv kieexvh, zw xyek ymxlnepw eii gfrkmeyfyj, mehviu tservgkmek E xf S, eeh rfx nlwk rtgvfbzqrxvpp. Xyi gfviijtfrumek wlfwmvpu fj gfqgykekmfrrp kvsdikvp zw swxvr vvjvviiu ks ej tsdtlxrxzseec ksgscsxc. R xsfh tfvkmfr sw fyi vjwsixj dep si gcejwzjziu ks fvpfrx ks xymj jysjzich eeh eii himmie sc egtcmtekmfrj zr e zrvzikc sw fxyii wmvpuw, klv gvvhzgkmfr sw klv jxiytxlvv fj jfpuiu gvfxvmew eeh xyi vvgfrjxiytxzse fj llqrr sikrrj sizrx kaf. Xyi lrpcqrvb fj slv afvb zw jrwk rpxsimkldw xyek zqgpvqvrk deklvqrxzgrp qfhvpj ks swjvv mewzkyxj zrks eeh eewniiw xf jytl ulijxzsew."
    + "Av rvv vbgpfvzrx zwjyvw wlgy rw lfa xvgyrzulij wsi jsczzrx gvffcidw grr fv umjgfzvvvh, zqgvfzvh, rrrppdvh, rru uidsewkvrxvh xf si gfviitx si ftkmdec. Av vbgitx xf debi pveumek gfrkvzflxzsew me tsdtlxrxzseec xifqvxic, xifqvximt dsuicmek, ueke wkvlgkyiij, lzky-giijfvdeegv tsdtlxzrx, M/S-iwjzgziegp wsi vbkiirrp qvqfvp, kvsxvrtymt zrwsiqrxzse jcjxvqj (KZW), fzscsxmtec tsdtlxzrx, eeh hrxr tsdtiijwzse."
    + "Sitelwv fj xyi kvsdikvzg rrxlvv fj xyi tycjmtec nsipu zr aymtl av cmmi, xifqvximt gvffcidw eimji me rrp rvve xyek zrkiietxj nmkl xyi tycjmtec nsipu. Kvsdikvzg gfqgykmek jfglwvw se uijmxrzrx, eeeccqmek, rru zqgpvqvrkmek iwjzgziex eckfvzxyqj wsi xifqvximt gvffcidw. Klv xifqvximt tsdtlxzrx xvfyg fj xyi hvtrvkqvrk zw mexvveekmfrrpcc vvrfaeiu wsi zxj tseximsykmfrj ks xyi jlruediexrp tisspvqj zr gfqgykekmfrrp kvsdikvp, euhiijwzrx dejwzzv ueke qrrrkvqvrk zwjyvw me xifqvximt gvffcidw, rru rtgppmek kvsdikvzg xvgyrzulij ks e zrvzikc sw rvvej, megcyumek qfpvglprv fzscsxc, xifqvximt dsuicmek, issskmtw, xifkieglzg mejfvdekmfr wpwkidw, vgfpfkp, eeh tysksemtw."
    + "Xyi kislt etxzzvpp tscprffvrxvw azxy fxyii xvfygw azxyme klv uigeixdiex eeh azxy klv iijirvtlvvj zr sklvv hvtrvkqvrkw ek Uybi. Klvc gfpcessieki azxy wetycxp zr Qrxyidekmtw, Smfpfkp, Fzstlvqzwkvp, Icitximtec rru Tsdtlxvv Iekzrviimek, rru klv Emtlfprw Wtlfsc fj Iezzvfrdiex. Sipseh Hlov, xyi kislt ecwf tscprffvrxvw azxy iijirvtlvvj rx zrvzslw xft mewkmkykij. Fvgryji sw zxj uigxy rru svveuxy, xyi kvsdikvzg gfqgykmek kislt ek Uybi mj rvxyrfcc xyi xft kvsdikvzg gfqgykmek kislt me klv eekmfr.";
    expected = "?";
    output = decryptTwoKeys(input);
    isPassed = output.equals(expected);
    System.out.println("input: "+input);
    System.out.println("expected output: "+expected);
    System.out.println("  actual output: "+output);
    System.out.println("Did the test pass? "+isPassed);
    System.out.println();
    /* *
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