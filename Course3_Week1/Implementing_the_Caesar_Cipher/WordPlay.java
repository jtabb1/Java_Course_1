
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {

  public void __test__emphasize(){
    System.out.println(emphasize("dna ctgaaactga", 'a'));
    System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
  }

  public String emphasize(String str, char replaceMe){
    replaceMe = Character.toLowerCase(replaceMe);
    StringBuilder sb = new StringBuilder(str);
    for (int i = 0; i < sb.length(); i++) {
      if (Character.toLowerCase(sb.charAt(i)) == replaceMe) {
        if (i%2 == 0) {
          sb.setCharAt(i, '*');
        } else {
          sb.setCharAt(i, '+');
        }
      }
    }
    return sb.toString();
  }

  public void __test__replaceVowels(){
    System.out.println(replaceVowels("Hello World", '*'));
    System.out.println(replaceVowels("HEllo World", '*'));
  }

  public String replaceVowels(String str, char ch){
    StringBuilder sb = new StringBuilder(str);
    for (int i = 0; i < sb.length(); i++) {
      if (isVowel(sb.charAt(i))) {
        sb.setCharAt(i, ch);
      }
    }
    return sb.toString();
  }

  public void _test_isVowel(){
    System.out.println(isVowel('w'));
    System.out.println(isVowel('a'));
    System.out.println(isVowel('F'));
  }

  public boolean isVowel(char ch){
    String strLower = Character.toString(ch).toLowerCase();
    if ("aeiou".contains(strLower)){return true;}
    return false;
  }

}
