
import edu.duke.*;

/**  
 * Write a description of Part4x here.  
 *  
 * @author (your name)  
 * @version (a version number or a date)  
 */  
public class Part4 {

  public String GetYouTubeURL(String string) {
    if (string.length() < 24) {return "";}
    String lowerString = string.toLowerCase();
    String youTubeReq = "youtube.com";
    int startIndex2 = lowerString.indexOf(youTubeReq);
    if (startIndex2 == -1) {return "";}

    int startIndex1 = lowerString.lastIndexOf("\"", startIndex2);
    int startIndex3 = lowerString.indexOf("\"", startIndex2+youTubeReq.length());
    if (startIndex3 == -1) {return "Warning: Missed incomplete youtube URL.";}
    return string.substring(startIndex1, startIndex3+1);
  }

  public void printYouTubeURLsFromWebPage() {
    String webPageOfURLList = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";
    URLResource ur = new URLResource(webPageOfURLList);
    String url;
    for (String s : ur.lines()) {
      url = GetYouTubeURL(s);
      if (url.length()>0) {System.out.println(url);}
    }
  }

}
