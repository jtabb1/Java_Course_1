import java.util.ArrayList;

/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharactersInPlay {
  private ArrayList<String> actors;
  private ArrayList<Integer> speeches;

  public CharactersInPlay(){
    actors = new ArrayList<String>();
    speeches = new ArrayList<Integer>();
  }

  public void update(String person){
    int idx = actors.indexOf(person);
    if(idx == -1){
      actors.add(person);
      speeches.add(1);
    } else {
      int freq = speeches.get(idx);
      speeches.set(idx,freq+1);
    }
  }

  public void findAllCharacters(){
    FileResource fr = new FileResource();
    actors.clear();
    speeches.clear();
    for(String word : fr.words()){
      int idx = word.indexOf(".");
      if(idx != -1){
        String person = word.substring(0, idx);
        update(person);
      }
    }
  }

  public int findIndexOfMax(){
    int max = speeches.get(0);
    int maxIndex = 0;
    for(int k=0; k < speeches.size(); k++){
        if (speeches.get(k) > max){
          max = speeches.get(k);
          maxIndex = k;
        }
    }
    return maxIndex;
  }

}
