
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class CodonCount {

  private HashMap<String,Integer> codonMap;

  public CodonCount(){
    codonMap = new HashMap<String,Integer>();
  }

  public void buildCodonMap(int start, String dna){
    codonMap.clear();
    for(int i=start;i<dna.length()-3;i+=3){
      String codon = dna.substring(i,i+3);
      if(codonMap.containsKey(codon)){
        Integer freq = codonMap.get(codon);
        codonMap.put(codon,freq+1);
      } else {
        codonMap.put(codon,1);
      }
    }
  }

  public String getMostCommonCodon(){
    String mostCommon = "";
    Integer maxFreq = 0;
    for(String key : codonMap.keySet()){
      Integer freq = codonMap.get(key);
      if(freq>maxFreq){
        maxFreq = freq;
        mostCommon = key;
      }
    }
    return mostCommon;
  }

  public void printCodonCounts(int start, int end){
    for(String key : codonMap.keySet()){
      Integer freq = codonMap.get(key);
      if(freq>=start && freq<=end){
        System.out.println(key+"\t"+freq);
      }
    }
  }

  public int numUniqueCodons(){
    return codonMap.size();
  }

  public int maxFreq(){
    return codonMap.get(getMostCommonCodon());
  }

  public void tester(){
    FileResource fr = new FileResource();
    String dna = fr.asString().toUpperCase();
    int frameStart = 0;
    int lowFreq = 1; int highFreq = 5;
    CodonCount cc = new CodonCount();
    cc.buildCodonMap(frameStart,dna);
    int numUnique = cc.numUniqueCodons();
    String mostCommon = cc.getMostCommonCodon();
    int maxFreq = cc.maxFreq();
    System.out.println("Reading from starting frame "+frameStart
                      +" results in "+numUnique+" unique codons");
    System.out.println(" and the most common codon is "+mostCommon
                      +" with a count of "+maxFreq);
    System.out.println("Counts of codons between "+lowFreq+" and "
                      +highFreq+" are:");
    cc.printCodonCounts(lowFreq,highFreq);
    System.out.println();
    frameStart = 1;
    lowFreq = 1; highFreq = 5;
    cc = new CodonCount();
    cc.buildCodonMap(frameStart,dna);
    numUnique = cc.numUniqueCodons();
    mostCommon = cc.getMostCommonCodon();
    maxFreq = cc.maxFreq();
    System.out.println("Reading from starting frame "+frameStart
                      +" results in "+numUnique+" unique codons");
    System.out.println(" and the most common codon is "+mostCommon
                      +" with a count of "+maxFreq);
    System.out.println("Counts of codons between "+lowFreq+" and "
                      +highFreq+" are:");
    cc.printCodonCounts(lowFreq,highFreq);
    System.out.println();
    frameStart = 2;
    lowFreq = 1; highFreq = 5;
    cc = new CodonCount();
    cc.buildCodonMap(frameStart,dna);
    numUnique = cc.numUniqueCodons();
    mostCommon = cc.getMostCommonCodon();
    maxFreq = cc.maxFreq();
    System.out.println("Reading from starting frame "+frameStart
                      +" results in "+numUnique+" unique codons");
    System.out.println(" and the most common codon is "+mostCommon
                      +" with a count of "+maxFreq);
    System.out.println("Counts of codons between "+lowFreq+" and "
                      +highFreq+" are:");
    cc.printCodonCounts(lowFreq,highFreq);
    System.out.println();
  }

}
