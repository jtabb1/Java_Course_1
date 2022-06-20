
/**
 * Write a description of WordFrequenciesNew here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class WordFrequenciesNew {
  private ArrayList<String> myWords;
  private ArrayList<Integer> myFreqs;

  public WordFrequenciesNew(){
    myWords = new ArrayList<String>();
    myFreqs = new ArrayList<Integer>();
  }

  public void findUnique(){
    FileResource fr = new FileResource();
    myWords.clear();
    myFreqs.clear();
    for(String word : fr.words()){
      word = word.toLowerCase();
      int idx = myWords.indexOf(word);
      if(idx == -1){
        myWords.add(word);
        myFreqs.add(1);
      } else {
        int freq = myFreqs.get(idx);
        myFreqs.set(idx, freq+1);
      }
    }
  }

  public int findIndexOfMax(){
    int max = myFreqs.get(0);
    int maxIndex = 0;
    for(int k=0; k < myFreqs.size(); k++){
        if (myFreqs.get(k) > max){
            max = myFreqs.get(k);
            maxIndex = k;
        }
    }
    return maxIndex;
  }

  public void tester(){
    findUnique();
    System.out.println("# unique words = "+myWords.size());
    for(int k=0; k < myWords.size(); k++){
      System.out.println(myFreqs.get(k)+"\t"+myWords.get(k));
    }
    int maxI = findIndexOfMax();
    System.out.println("The word that occurs most often and its count are: "
    + myWords.get(maxI) + " and " + myFreqs.get(maxI));
    System.out.println("# unique words = "+myWords.size());

  }
}

