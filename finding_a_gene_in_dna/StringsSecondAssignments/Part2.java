
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
  int howMany (String stringa, String stringb) {
    if (stringa.length() == 0) {return -1;}
    int idx = 0;
    int result = 0;
    while(true) {
      idx = stringb.indexOf(stringa, idx);
      if (idx == -1) {return result;}
      result = result + 1;
      idx = idx + stringa.length();
    }
  }

  void testHowMany() {
    String stringa;
    String stringb;

    stringa = "ha"; stringb = "ghahad";
    System.out.println(stringa + ", " + stringb + ", " + howMany(stringa,stringb));
    stringa = "ha"; stringb = "g";
    System.out.println(stringa + ", " + stringb + ", " + howMany(stringa,stringb));
    stringa = "ha"; stringb = "";
    System.out.println(stringa + ", " + stringb + ", " + howMany(stringa,stringb));
    stringa = "a"; stringb = "ggghahhahaha";
    System.out.println(stringa + ", " + stringb + ", " + howMany(stringa,stringb));
    stringa = "ha"; stringb = "ghahadhahaex";
    System.out.println(stringa + ", " + stringb + ", " + howMany(stringa,stringb));
    stringa = "ha"; stringb = "ha";
    System.out.println(stringa + ", " + stringb + ", " + howMany(stringa,stringb));
    stringa = ""; stringb = "ha";
    System.out.println(stringa + ", " + stringb + ", " + howMany(stringa,stringb));
  }
}
