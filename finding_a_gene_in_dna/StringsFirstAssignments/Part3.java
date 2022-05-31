
/**  
 * Write a description of Part3 here.  
 *  
 * @author (your name)  
 * @version (a version number or a date)  
 */  
public class Part3 {
  public Boolean twoOccurrences(String stringa, String stringb) {
    int startIndex1 = stringb.indexOf(stringa);
    int startIndex2 = stringb.indexOf(stringa, startIndex1+stringa.length());
    if (startIndex1 == -1 || startIndex2 == -1) {return false;}
    return true;
  }

  public void testing() {
    System.out.println(twoOccurrences("sa", "wawas"));
    System.out.println(twoOccurrences("wa", "wawaws"));
    System.out.println(twoOccurrences("q", "wawas"));
    System.out.println(twoOccurrences("awa", "wawasawadawa"));
    System.out.println(twoOccurrences("x", "wawas"));
  }

  public String lastPart(String stringa, String stringb) {
    int startIndex1 = stringb.indexOf(stringa);
    String result = stringb.substring(startIndex1+stringa.length());
    if (startIndex1 == -1) {return stringb;}
    return result;
  }

  public void testLastPart() {
    String stringa;
    String stringb;
    String output;

    stringa = "an";
    stringb = "lanret";
    output = lastPart(stringa, stringb);
    System.out.println(stringa+", "+stringb+", "+output);

    stringa = "an";
    stringb = "banana";
    output = lastPart(stringa, stringb);
    System.out.println(stringa+", "+stringb+", "+output);

    stringa = "zoo";
    stringb = "forest";
    output = lastPart(stringa, stringb);
    System.out.println(stringa+", "+stringb+", "+output);

    stringa = "for";
    stringb = "forest";
    output = lastPart(stringa, stringb);
    System.out.println(stringa+", "+stringb+", "+output);

    stringa = "est";
    stringb = "forest";
    output = lastPart(stringa, stringb);
    System.out.println(stringa+", "+stringb+", "+output);

  }

}
