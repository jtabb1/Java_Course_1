
import java.util.Currency;

import edu.duke.*;

/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

  public void testProcessGenes2() {

    FileResource fr = new FileResource("brca1line.fa");
    String dna = fr.asString();
    System.out.println(); processGenes2(getAllGenes(dna));
  }

  // %

  public void processGenes2(StorageResource genes) {
    
    System.out.println("All genes that have more than 0 amino acids:");
    printGenesWithMoreThanXAminoAcids(0, genes);

    System.out.print("The number of genes that have more than 0 amino acids: ");
    System.out.println(numOfGenesWithMoreThanXAminoAcids(0, genes));

    System.out.println("The genes whose C-G ratio is more than 0.35:");
    printGenesWithCGRatioMoreThanX(.35, genes);

    System.out.print("The number of genes whose C-G ratio is more than 0.35: ");
    System.out.println(numOfGenesWithCGRatioMoreThanX(.35, genes));

    System.out.println("The longest gene in the strand is:");
    String longest = longestGene(genes);
    System.out.println(longest);
    System.out.println("It has " + longest.length() + " amino acids in it.");
  }

  public void testProcessGenes1() {

    String dna00 = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
    String dna01 = "NGDSRAHGF";
    String dna02 = "ATGJGCMOU";
    String dna03 = "NYRTRXTAA";
    String dna04 =  "svaATG123TAAATGTAGATG123456TGADE";
    String dna05 = "AVAATG1234TAADE";

    String dna07 = "AAATGCCCTAACTAGATTAAGAAACC";
    String dna08 = "ATGCCATAG";

    System.out.println(); processGenes1(getAllGenes(dna00));
    System.out.println(); processGenes1(getAllGenes(dna01));
    System.out.println(); processGenes1(getAllGenes(dna02));
    System.out.println(); processGenes1(getAllGenes(dna04));
    System.out.println(); processGenes1(getAllGenes(dna07));
    System.out.println(); processGenes1(getAllGenes(dna08));
  }

  public void processGenes1(StorageResource genes) {
    
    System.out.println("All genes that have more than 9 amino acids:");
    printGenesWithMoreThanXAminoAcids(9, genes);

    System.out.print("The number of genes that have more than 9 amino acids: ");
    System.out.println(numOfGenesWithMoreThanXAminoAcids(9, genes));

    System.out.println("The genes whose C-G ratio is more than 0.35:");
    printGenesWithCGRatioMoreThanX(.35, genes);

    System.out.print("The number of genes whose C-G ratio is more than 0.35: ");
    System.out.println(numOfGenesWithCGRatioMoreThanX(.35, genes));

    System.out.println("The longest gene in the strand is:");
    String longest = longestGene(genes);
    System.out.println(longest);
    System.out.println("It has " + longest.length() + " amino acids in it.");
  }

  public void printGenesWithMoreThanXAminoAcids(int x, StorageResource genes) {
    for (String g: genes.data()) {if (g.length() > x) {System.out.println(g);}}
  }

  public int numOfGenesWithMoreThanXAminoAcids(int x, StorageResource genes) {
    int ctr = 0;
    for (String g: genes.data()) {if (g.length() > x) {ctr = ctr + 1;}}
    return ctr;
  }

  public void printGenesWithCGRatioMoreThanX(double x, StorageResource genes) {
    for (String g: genes.data()) {
      if (cgRatio(g) > x) {
        System.out.println(g);
      }
    }
  }

  public int numOfGenesWithCGRatioMoreThanX(double x, StorageResource genes) {
    int ctr = 0;
    for (String g: genes.data()) {if (cgRatio(g) > x) {ctr = ctr + 1;}}
    return ctr;
  }

  public String longestGene(StorageResource genes) {
    int longest = 0;
    String longestGene = "";
    for (String g: genes.data()) {
      if (g.length() > longest) {
        longest = g.length();
        longestGene = g;
      }
    }
    return longestGene;
  }
  
  public int countCTG(String dna) {
    String codon = "ctg"; codon = codon.toLowerCase();
    StorageResource genes = new StorageResource();
    genes = getAllGenes(dna);
    int ctr = 0;
    for (String g: genes.data()) {
      for (int i = 0; i < g.length() - 3; i = i + 3) {
        //System.out.println(i + ", " + i+3 + "; " + g.substring(i,i+3).toLowerCase());
        if (g.substring(i,i+3).toLowerCase().equals(codon)) {
          ctr = ctr + 1;
        }
      }
    }
    return ctr;
  }

  public void testCountCTG() {
    //String dna000 = "ATG"+"CTG"+"CTG"+"AGC"+"TGA"+"TAA"+"TAG"+"AGG"+"GCC"+"ATG"+"TAA"+"CTG";
    String dna00 = "ATG"+"CTG"+"CTG"+"AGC"+"TGA"+"TAA"+"TAGCTGCTG"+"ATG"+"TAA"+"CTG";
    String dna07 = "AA"+"ATGCTGTAA"+"CTGGATTAAGAAACC";
    String dna08 = "ATGCTGTAG";
    
    System.out.println(countCTG(dna00));
    System.out.println(countCTG(dna07));
    System.out.println(countCTG(dna08));
  }

  public void testCGRatio () {
    String dna00 = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
    String dna01 = "NGDSRAHGF";
    String dna02 = "ATGJGCMOU";
    String dna03 = "NYRTRXTAA";
    String dna04 =  "svaATG123TAAATGTAGATG123456TGADE";
    String dna05 = "AVAATG1234TAADE";

    String dna07 = "AAATGCCCTAACTAGATTAAGAAACC";
    String dna08 = "ATGCCATAG";
    
    System.out.println(cgRatio(dna08));
  }
  
  public double cgRatio(String dna) {
    dna = dna.toLowerCase();
    int ctr = 0;
    for (int i = 0; i < dna.length(); i++) {
      char aminoAcid = dna.charAt(i);
      if (aminoAcid == 'c' || aminoAcid == 'g') {
        ctr = ctr + 1;
      }
    }
    return (double) ctr/dna.length();
  }

  public StorageResource getAllGenes(String dna) {
    int idx = 0;
    int ctr = 0;
    StorageResource geneList = new StorageResource();
    System.out.println("Starting to gather genes:");
    while(true) {
      String gene = findGene(dna, idx);
      if (gene.length() == 0) {
        System.out.println("stopped iteration(s).");
        break;
      }
      geneList.add(gene);
      ctr = ctr + 1;

      System.out.println("gene found and added: " + gene);
      idx = dna.indexOf(gene,idx) + gene.length();
    }
    System.out.println("There are a total of " + ctr + 
      " gene(s) in this strand of dna.");
    return geneList;
  }

  public void testOn(String dna) {
    System.out.println("Testing getAllGenes on " + dna);
    StorageResource genes = getAllGenes(dna);
    for (String g: genes.data()) {
      System.out.println(g);
    }
  }

  public void testGetAllGenes () {
    String dna00 = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
    String dna01 = "NGDSRAHGF";
    String dna02 = "ATGJGCMOU";
    String dna03 = "NYRTRXTAA";
    String dna04 =  "svaATG123TAAATGTAGATG123456TGADE";
    String dna05 = "AVAATG1234TAADE";

    testOn(dna00);
  }

  public String findGene(String dna, int startIndex) {
    String dnaLower = dna.toLowerCase();
    startIndex = dnaLower.indexOf("atg", startIndex);
    if (startIndex == -1) {return "";}
    int idxTaa = findStopCodon(dnaLower, startIndex, "taa");
    int idxTag = findStopCodon(dnaLower, startIndex, "tag");
    int idxTga = findStopCodon(dnaLower, startIndex, "tga");
    int minIdx = Math.min(idxTaa,Math.min(idxTag,idxTga));
    if (minIdx == dna.length()) {return "";}
    return dna.substring(startIndex,minIdx+3);
  }

  public int findStopCodon(String dna, int startIndex, String stopCodon) {
    if (startIndex == -1) {return dna.length();}
    dna = dna.toLowerCase();
    stopCodon = stopCodon.toLowerCase();
    int index = dna.indexOf(stopCodon.toLowerCase(),startIndex+3);
    while(index != -1) {
      int diff = index - startIndex;
      if (diff % 3 == 0) {
        return index;
      } else {
        index = dna.indexOf(stopCodon,index+1);
      }
      // un-comment the below to see the iterations:
      //System.out.println("  >>: " + startIndex + ", " + index + ", " + diff);
    }
    return dna.length();
  }

  public String findGene(String dna) {
    String dnaLower = dna.toLowerCase();
    int startIndex = dnaLower.indexOf("atg");
    if (startIndex == -1) {return "";}
    int idxTaa = findStopCodon(dnaLower, startIndex, "taa");
    int idxTag = findStopCodon(dnaLower, startIndex, "tag");
    int idxTga = findStopCodon(dnaLower, startIndex, "tga");
    int minIdx = Math.min(idxTaa,Math.min(idxTag,idxTga));
    if (minIdx == dna.length()) {return "";}
    return dna.substring(startIndex,minIdx+3);
  }

  public void printAllGenes(String dna) {
    int idx;
    while(true) {
      String gene = findGene(dna);
      if (gene.length() == 0) {
        System.out.println("stopped iteration(s).");
        return;
      }
      System.out.println("iteration:");
      System.out.println("gene found: " + gene);
      idx = dna.indexOf(gene);
      System.out.println(idx + ", " + gene.length() + ", " + dna.length());
      if (gene.length() == dna.length()) {
        System.out.println("stopped iteration(s).");
        return;
      }
      dna = dna.substring(idx+gene.length(), dna.length()-1);
      System.out.println("dna left: " + dna);
    }
  }

  public void testPrintAllGenes() {
    String dna;
    String dna01 = "NGDSRAHGF";
    String dna02 = "ATGJGCMOU";
    String dna03 = "NYRTRXTAA";
    String dna04 =  "svaATG123TAAATGTAGATG123456TGADE";
    String dna05 = "AVAATG1234TAADE";
    String dna06 = "ATGgatcctccatatacaacggtatctccacctcaggtttagatctcaacaacgga" + 
      "accattgccgacatgagacagttaggtatcgtcgagagttacaagctaaaacgagcagtagtcagctctgcatct" + 
      "gaagccgctgaagttctactaagggtggataacatcatccgtgcaagaccaagaaccgccaatagacaacatatg" + 
      "taacatatttaggatatacctcgaaaataataaaccgccacactgtcattattataattagaaacagaacgcaaa" + 
      "aattatccactatataattcaaagacgcgaaaaaaaaagaacaacgcgtcatagaacttttggcaattcgcgtca" + 
      "caaataaattttggcaacttatgtttcctcttcgagcagtactcgagccctgtctcaagaatgtaataataccca" + 
      "tcgtaggtatggttaaagatagcatctccacaacctcaaagctccttgccgagagtcgccctcctttgtcgagta" + 
      "attttcacttttcatatgagaacttattttcttattctttactctcacatcctgtagtgattgacactgcaacag" + 
      "ccaccatcactagaagaacagaacaattacttaatagaaaaattatatcttcctcgaaacgatttcctgcttcca" + 
      "acatctacgtatatcaagaagcattcacttaccatgacacagcttcagatttcattattgctgacagctactata" + 
      "tcactactccatctagtagtggccacgccctatgaggcatatcctatcggaaaacaataccccccagtggcaaga" + 
      "gtcaatgaatcgtttacatttcaaatttccaatgatacctataaatcgtctgtagacaagacagctcaaataaca" + 
      "tacaattgcttcgacttaccgagctggctttcgtttgactctagttctagaacgttctcaggtgaaccttcttct" + 
      "gacttactatctgatgcgaacaccacgttgtatttcaatgtaatactcgagggtacggactctgccgacagcacg" + 
      "tctttgaacaatacataccaatttgttgttacaaaccgtccatccatctcgctatcgtcagatttcaatctattg" + 
      "gcgttgttaaaaaactatggttatactaacggcaaaaacgctctgaaactagatcctaatgaagtcttcaacgtg" + 
      "acttttgaccgttcaatgttcactaacgaagaatccattgtgtcgtattacggacgttctcagttgtataatgcg" + 
      "ccgttacccaattggctgttcttcgattctggcgagttgaagtttactgggacggcaccggtgataaactcggcg" + 
      "attgctccagaaacaagctacagttttgtcatcatcgctacagacattgaaggattttctgccgttgaggtagaa" + 
      "ttcgaattagtcatcggggctcaccagttaactacctctattcaaaatagtttgataatcaacgttactgacaca" + 
      "ggtaacgtttcatatgacttacctctaaactatgtttatctcgatgacgatcctatttcttctgataaattgggt" + 
      "tctataaacttattggatgctccagactgggtggcattagataatgctaccatttccgggtctgtcccagatgaa" + 
      "ttactcggtaagaactccaatcctgccaatttttctgtgtccatttatgatacttatggtgatgtgatttatttc" + 
      "aacttcgaagttgtctccacaacggatttgtttgccattagttctcttcccaatattaacgctacaaggggtgaa" + 
      "tggttctcctactattttttgccttctcagtttacagactacgtgaatacaaacgtttcattagagtttactaat" + 
      "tcaagccaagaccatgactgggtgaaattccaatcatctaatttaacattagctggagaagtgcccaagaatttc" + 
      "gacaagctttcattaggtttgaaagcgaaccaaggttcacaatctcaagagctatattttaacatcattggcatg" + 
      "gattcaaagataactcactcaaaccacagtgcgaatgcaacgtccacaagaagttctcaccactccacctcaaca" + 
      "agttcttacacatcttctacttacactgcaaaaatttcttctacctccgctgctgctacttcttctgctccagca" + 
      "gcgctgccagcagccaataaaacttcatctcacaataaaaaagcagtagcaattgcgtgcggtgttgctatccca" + 
      "ttaggcgttatcctagtagctctcatttgcttcctaatattctggagacgcagaagggaaaatccagacgatgaa" + 
      "aacttaccgcatgctattagtggacctgatttgaataatcctgcaaataaaccaaatcaagaaaacgctacacct" + 
      "ttgaacaacccctttgatgatgatgcttcctcgtacgatgatacttcaatagcaagaagattggctgctttgaac" + 
      "actttgaaattggataaccactctgccactgaatctgatatttccagcgtggatgaaaagagagattctctatca" + 
      "ggtatgaatacatacaatgatcagttccaatcccaaagtaaagaagaattattagcaaaacccccagtacagcct" + 
      "ccagagagcccgttctttgacccacagaataggtcttcttctgtgtatatggatagtgaaccagcagtaaataaa" + 
      "tcctggcgatatactggcaacctgtcaccagtctctgatattgtcagagacagttacggatcacaaaaaactgtt" + 
      "gatacagaaaaacttttcgatttagaagcaccagagaaggaaaaacgtacgtcaagggatgtcactatgtcttca" + 
      "ctggacccttggaacagcaatattagcccttctcccgtaagaaaatcagtaacaccatcaccatataacgtaacg" + 
      "aagcatcgtaaccgccacttacaaaatattcaagactctcaaagcggtaaaaacggaatcactcccacaacaatg" + 
      "tcaacttcatcttctgacgattttgttccggttaaagatggtgaaaatttttgctgggtccatagcatggaacc" + 
      "agacagaagaccaagtaagaaaaggttagtagatttttcaaataagagtaatgtcaatgttggtcaagttaagga" + 
      "cattcacggacgcatcccagaaatgctgtgattatacgcaacgatattttgcttaattttattttcctgttttat" + 
      "tttttattagtggtttacagataccctatattttatttagtttttatacttagagacatttaattttaattccat" + 
      "tcttcaaatttcatttttgcacttaaaacaaagatccaaaaatgctctcgccctcttcatattgagaatacactc" + 
      "cattcaaaattttgtcgtcaccgctgattaatttttcactaaactgatgaataatcaaaggccccacgtcagaac" + 
      "cgactaaagaagtgagttttattttaggaggttgaaaaccattattgtctggtaaattttcatcttcttgacatt" + 
      "taacccagtttgaatccctttcaatttctgctttttcctccaaactatcgaccctcctgtttctgtccaacttat" + 
      "gtcctagttccaattcgatcgcattaataactgcttcaaatgttattgtgtcatcgttgactttaggtaatttct" + 
      "ccaaatgcataatcaaactatttaaggaagatcggaattcgtcgaacacttcagtttccgtaatgatctgatcgtctttatccacatgttgtaattcactaaaatctaaaacgtatttttcaatgcataaatcgttctttttattaataatgcagatggaaaatctgtaaacgtgcgttaatttagaaagaacatccagtataagttcttctatatagtcaattaaagcaggatgcctattaatgggaacgaactgcggcaagttgaatgactggtaagtagtgtagtcgaatgactgaggtgggtatacatttctataaaataaaatcaaattaatgtagcattttaagtataccctcagccacttctctacccatctattcataaagctgacgcaacgattactattttttttttcttcttggatctcagtcgtcgcaaaaacgtataccttctttttccgaccttttttttagctttctggaaaagtttatattagttaaacagggtctagtcttagtgtgaaagctagtggtttcgattgactgatattaagaaagtggaaattaaattagtagtgtagacgtatatgcatatgtatttctcgcctgtttatgtttctacgtacttttgatttatagcaaggggaaaagaaatacatactattttttggtaaaggtgaaagcataatgtaaaagctagaataaaatggacgaaataaagagaggcttagttcatcttttttccaaaaagcacccaatgataataactaaaatgaaaaggatttgccatctgtcagcaacatcagttgtgtgagcaataataaaatcatcacctccgttgcctttagcgcgtttgtcgtttgtatcttccgtaattttagtcttatcaatgggaatcataaattttccaatgaattagcaatttcgtccaattctttttgagcttcttcatatttgctttggaattcttcgcacttcttttcccattcatctctttcttcttccaaagcaacgatccttctacccatttgctcagagttcaaatcggcctctttcagtttatccattgcttccttcagtttggcttcactgtcttctagctgttgttctagatcctggtttttcttggtgtagttctcattattagatctcaagttattggagtcttcagccaattgctttgtatcagacaattgactctctaacttctccacttcactgtcgagttgctcgtttttagcggacaaagatttaatctcgttttctttttcagtgttagattgctctaattctttgagctgttctctcagctcctcatatttttcttgccatgactcagattctaattttaagctattcaatttctctttgatc";
    String dna07 = "AAATGCCCTAACTAGATTAAGAAACC";
    dna = dna01; System.out.println((dna)); printAllGenes(dna);
    dna = dna02; System.out.println((dna)); printAllGenes(dna);
    dna = dna03; System.out.println((dna)); printAllGenes(dna);
    dna = dna04; System.out.println((dna)); printAllGenes(dna);
    dna = dna05; System.out.println((dna)); printAllGenes(dna);
    dna = dna06; System.out.println((dna)); printAllGenes(dna);
    dna = dna07; System.out.println((dna)); printAllGenes(dna);
  }

  public void testFindGene() {
    String dna;
    String dna01 = "NGDSRAHGF";
    String dna02 = "ATGJGCMOU";
    String dna03 = "NYRTRXTAA";
    String dna04 =  "svaATG123TAADE";
    String dna05 = "AVAATG1234TAADE";
    String dna06 = "ATGgatcctccatatacaacggtatctccacctcaggtttagatctcaacaacggaaccattgccgacatgagacagttaggtatcgtcgagagttacaagctaaaacgagcagtagtcagctctgcatctgaagccgctgaagttctactaagggtggataacatcatccgtgcaagaccaagaaccgccaatagacaacatatgtaacatatttaggatatacctcgaaaataataaaccgccacactgtcattattataattagaaacagaacgcaaaaattatccactatataattcaaagacgcgaaaaaaaaagaacaacgcgtcatagaacttttggcaattcgcgtcacaaataaattttggcaacttatgtttcctcttcgagcagtactcgagccctgtctcaagaatgtaataatacccatcgtaggtatggttaaagatagcatctccacaacctcaaagctccttgccgagagtcgccctcctttgtcgagtaattttcacttttcatatgagaacttattttcttattctttactctcacatcctgtagtgattgacactgcaacagccaccatcactagaagaacagaacaattacttaatagaaaaattatatcttcctcgaaacgatttcctgcttccaacatctacgtatatcaagaagcattcacttaccatgacacagcttcagatttcattattgctgacagctactatatcactactccatctagtagtggccacgccctatgaggcatatcctatcggaaaacaataccccccagtggcaagagtcaatgaatcgtttacatttcaaatttccaatgatacctataaatcgtctgtagacaagacagctcaaataacatacaattgcttcgacttaccgagctggctttcgtttgactctagttctagaacgttctcaggtgaaccttcttctgacttactatctgatgcgaacaccacgttgtatttcaatgtaatactcgagggtacggactctgccgacagcacgtctttgaacaatacataccaatttgttgttacaaaccgtccatccatctcgctatcgtcagatttcaatctattggcgttgttaaaaaactatggttatactaacggcaaaaacgctctgaaactagatcctaatgaagtcttcaacgtgacttttgaccgttcaatgttcactaacgaagaatccattgtgtcgtattacggacgttctcagttgtataatgcgccgttacccaattggctgttcttcgattctggcgagttgaagtttactgggacggcaccggtgataaactcggcgattgctccagaaacaagctacagttttgtcatcatcgctacagacattgaaggattttctgccgttgaggtagaattcgaattagtcatcggggctcaccagttaactacctctattcaaaatagtttgataatcaacgttactgacacaggtaacgtttcatatgacttacctctaaactatgtttatctcgatgacgatcctatttcttctgataaattgggttctataaacttattggatgctccagactgggtggcattagataatgctaccatttccgggtctgtcccagatgaattactcggtaagaactccaatcctgccaatttttctgtgtccatttatgatacttatggtgatgtgatttatttcaacttcgaagttgtctccacaacggatttgtttgccattagttctcttcccaatattaacgctacaaggggtgaatggttctcctactattttttgccttctcagtttacagactacgtgaatacaaacgtttcattagagtttactaattcaagccaagaccatgactgggtgaaattccaatcatctaatttaacattagctggagaagtgcccaagaatttcgacaagctttcattaggtttgaaagcgaaccaaggttcacaatctcaagagctatattttaacatcattggcatggattcaaagataactcactcaaaccacagtgcgaatgcaacgtccacaagaagttctcaccactccacctcaacaagttcttacacatcttctacttacactgcaaaaatttcttctacctccgctgctgctacttcttctgctccagcagcgctgccagcagccaataaaacttcatctcacaataaaaaagcagtagcaattgcgtgcggtgttgctatcccattaggcgttatcctagtagctctcatttgcttcctaatattctggagacgcagaagggaaaatccagacgatgaaaacttaccgcatgctattagtggacctgatttgaataatcctgcaaataaaccaaatcaagaaaacgctacacctttgaacaacccctttgatgatgatgcttcctcgtacgatgatacttcaatagcaagaagattggctgctttgaacactttgaaattggataaccactctgccactgaatctgatatttccagcgtggatgaaaagagagattctctatcaggtatgaatacatacaatgatcagttccaatcccaaagtaaagaagaattattagcaaaacccccagtacagcctccagagagcccgttctttgacccacagaataggtcttcttctgtgtatatggatagtgaaccagcagtaaataaatcctggcgatatactggcaacctgtcaccagtctctgatattgtcagagacagttacggatcacaaaaaactgttgatacagaaaaacttttcgatttagaagcaccagagaaggaaaaacgtacgtcaagggatgtcactatgtcttcactggacccttggaacagcaatattagcccttctcccgtaagaaaatcagtaacaccatcaccatataacgtaacgaagcatcgtaaccgccacttacaaaatattcaagactctcaaagcggtaaaaacggaatcactcccacaacaatgtcaacttcatcttctgacgattttgttccggttaaagatggtgaaaatttttgctgggtccatagcatggaaccagacagaagaccaagtaagaaaaggttagtagatttttcaaataagagtaatgtcaatgttggtcaagttaaggacattcacggacgcatcccagaaatgctgtgattatacgcaacgatattttgcttaattttattttcctgttttattttttattagtggtttacagataccctatattttatttagtttttatacttagagacatttaattttaattccattcttcaaatttcatttttgcacttaaaacaaagatccaaaaatgctctcgccctcttcatattgagaatacactccattcaaaattttgtcgtcaccgctgattaatttttcactaaactgatgaataatcaaaggccccacgtcagaaccgactaaagaagtgagttttattttaggaggttgaaaaccattattgtctggtaaattttcatcttcttgacatttaacccagtttgaatccctttcaatttctgctttttcctccaaactatcgaccctcctgtttctgtccaacttatgtcctagttccaattcgatcgcattaataactgcttcaaatgttattgtgtcatcgttgactttaggtaatttctccaaatgcataatcaaactatttaaggaagatcggaattcgtcgaacacttcagtttccgtaatgatctgatcgtctttatccacatgttgtaattcactaaaatctaaaacgtatttttcaatgcataaatcgttctttttattaataatgcagatggaaaatctgtaaacgtgcgttaatttagaaagaacatccagtataagttcttctatatagtcaattaaagcaggatgcctattaatgggaacgaactgcggcaagttgaatgactggtaagtagtgtagtcgaatgactgaggtgggtatacatttctataaaataaaatcaaattaatgtagcattttaagtataccctcagccacttctctacccatctattcataaagctgacgcaacgattactattttttttttcttcttggatctcagtcgtcgcaaaaacgtataccttctttttccgaccttttttttagctttctggaaaagtttatattagttaaacagggtctagtcttagtgtgaaagctagtggtttcgattgactgatattaagaaagtggaaattaaattagtagtgtagacgtatatgcatatgtatttctcgcctgtttatgtttctacgtacttttgatttatagcaaggggaaaagaaatacatactattttttggtaaaggtgaaagcataatgtaaaagctagaataaaatggacgaaataaagagaggcttagttcatcttttttccaaaaagcacccaatgataataactaaaatgaaaaggatttgccatctgtcagcaacatcagttgtgtgagcaataataaaatcatcacctccgttgcctttagcgcgtttgtcgtttgtatcttccgtaattttagtcttatcaatgggaatcataaattttccaatgaattagcaatttcgtccaattctttttgagcttcttcatatttgctttggaattcttcgcacttcttttcccattcatctctttcttcttccaaagcaacgatccttctacccatttgctcagagttcaaatcggcctctttcagtttatccattgcttccttcagtttggcttcactgtcttctagctgttgttctagatcctggtttttcttggtgtagttctcattattagatctcaagttattggagtcttcagccaattgctttgtatcagacaattgactctctaacttctccacttcactgtcgagttgctcgtttttagcggacaaagatttaatctcgttttctttttcagtgttagattgctctaattctttgagctgttctctcagctcctcatatttttcttgccatgactcagattctaattttaagctattcaatttctctttgatc";
    String dna07 = "AAATGCCCTAACTAGATTAAGAAACC";
    dna = dna01; System.out.println((dna)); System.out.println(findGene(dna));
    dna = dna02; System.out.println((dna)); System.out.println(findGene(dna));
    dna = dna03; System.out.println((dna)); System.out.println(findGene(dna));
    dna = dna04; System.out.println((dna)); System.out.println(findGene(dna));
    dna = dna05; System.out.println((dna)); System.out.println(findGene(dna));
    dna = dna06; System.out.println((dna)); System.out.println(findGene(dna));
    dna = dna07; System.out.println((dna)); System.out.println(findGene(dna));
  }

  public void testFindStopCodon() {
    int startIndex;
    String startCodon = "ATG";
    String stopCodon; // TAA, TAG, or TGA
    String dna;

    String dna01 = "NGDSRAHGF";
    String dna02 = "ATGJGCMOU";
    String dna03 = "NYRTRXTAA";
    String dna04 =  "svaATG123TAADE";
    String dna05 = "AVAATG1234TAADE";
    String dna06 = "ATGgatcctccatatacaacggtatctccacctcaggtttagatctcaacaacggaaccattgccgacatgagacagttaggtatcgtcgagagttacaagctaaaacgagcagtagtcagctctgcatctgaagccgctgaagttctactaagggtggataacatcatccgtgcaagaccaagaaccgccaatagacaacatatgtaacatatttaggatatacctcgaaaataataaaccgccacactgtcattattataattagaaacagaacgcaaaaattatccactatataattcaaagacgcgaaaaaaaaagaacaacgcgtcatagaacttttggcaattcgcgtcacaaataaattttggcaacttatgtttcctcttcgagcagtactcgagccctgtctcaagaatgtaataatacccatcgtaggtatggttaaagatagcatctccacaacctcaaagctccttgccgagagtcgccctcctttgtcgagtaattttcacttttcatatgagaacttattttcttattctttactctcacatcctgtagtgattgacactgcaacagccaccatcactagaagaacagaacaattacttaatagaaaaattatatcttcctcgaaacgatttcctgcttccaacatctacgtatatcaagaagcattcacttaccatgacacagcttcagatttcattattgctgacagctactatatcactactccatctagtagtggccacgccctatgaggcatatcctatcggaaaacaataccccccagtggcaagagtcaatgaatcgtttacatttcaaatttccaatgatacctataaatcgtctgtagacaagacagctcaaataacatacaattgcttcgacttaccgagctggctttcgtttgactctagttctagaacgttctcaggtgaaccttcttctgacttactatctgatgcgaacaccacgttgtatttcaatgtaatactcgagggtacggactctgccgacagcacgtctttgaacaatacataccaatttgttgttacaaaccgtccatccatctcgctatcgtcagatttcaatctattggcgttgttaaaaaactatggttatactaacggcaaaaacgctctgaaactagatcctaatgaagtcttcaacgtgacttttgaccgttcaatgttcactaacgaagaatccattgtgtcgtattacggacgttctcagttgtataatgcgccgttacccaattggctgttcttcgattctggcgagttgaagtttactgggacggcaccggtgataaactcggcgattgctccagaaacaagctacagttttgtcatcatcgctacagacattgaaggattttctgccgttgaggtagaattcgaattagtcatcggggctcaccagttaactacctctattcaaaatagtttgataatcaacgttactgacacaggtaacgtttcatatgacttacctctaaactatgtttatctcgatgacgatcctatttcttctgataaattgggttctataaacttattggatgctccagactgggtggcattagataatgctaccatttccgggtctgtcccagatgaattactcggtaagaactccaatcctgccaatttttctgtgtccatttatgatacttatggtgatgtgatttatttcaacttcgaagttgtctccacaacggatttgtttgccattagttctcttcccaatattaacgctacaaggggtgaatggttctcctactattttttgccttctcagtttacagactacgtgaatacaaacgtttcattagagtttactaattcaagccaagaccatgactgggtgaaattccaatcatctaatttaacattagctggagaagtgcccaagaatttcgacaagctttcattaggtttgaaagcgaaccaaggttcacaatctcaagagctatattttaacatcattggcatggattcaaagataactcactcaaaccacagtgcgaatgcaacgtccacaagaagttctcaccactccacctcaacaagttcttacacatcttctacttacactgcaaaaatttcttctacctccgctgctgctacttcttctgctccagcagcgctgccagcagccaataaaacttcatctcacaataaaaaagcagtagcaattgcgtgcggtgttgctatcccattaggcgttatcctagtagctctcatttgcttcctaatattctggagacgcagaagggaaaatccagacgatgaaaacttaccgcatgctattagtggacctgatttgaataatcctgcaaataaaccaaatcaagaaaacgctacacctttgaacaacccctttgatgatgatgcttcctcgtacgatgatacttcaatagcaagaagattggctgctttgaacactttgaaattggataaccactctgccactgaatctgatatttccagcgtggatgaaaagagagattctctatcaggtatgaatacatacaatgatcagttccaatcccaaagtaaagaagaattattagcaaaacccccagtacagcctccagagagcccgttctttgacccacagaataggtcttcttctgtgtatatggatagtgaaccagcagtaaataaatcctggcgatatactggcaacctgtcaccagtctctgatattgtcagagacagttacggatcacaaaaaactgttgatacagaaaaacttttcgatttagaagcaccagagaaggaaaaacgtacgtcaagggatgtcactatgtcttcactggacccttggaacagcaatattagcccttctcccgtaagaaaatcagtaacaccatcaccatataacgtaacgaagcatcgtaaccgccacttacaaaatattcaagactctcaaagcggtaaaaacggaatcactcccacaacaatgtcaacttcatcttctgacgattttgttccggttaaagatggtgaaaatttttgctgggtccatagcatggaaccagacagaagaccaagtaagaaaaggttagtagatttttcaaataagagtaatgtcaatgttggtcaagttaaggacattcacggacgcatcccagaaatgctgtgattatacgcaacgatattttgcttaattttattttcctgttttattttttattagtggtttacagataccctatattttatttagtttttatacttagagacatttaattttaattccattcttcaaatttcatttttgcacttaaaacaaagatccaaaaatgctctcgccctcttcatattgagaatacactccattcaaaattttgtcgtcaccgctgattaatttttcactaaactgatgaataatcaaaggccccacgtcagaaccgactaaagaagtgagttttattttaggaggttgaaaaccattattgtctggtaaattttcatcttcttgacatttaacccagtttgaatccctttcaatttctgctttttcctccaaactatcgaccctcctgtttctgtccaacttatgtcctagttccaattcgatcgcattaataactgcttcaaatgttattgtgtcatcgttgactttaggtaatttctccaaatgcataatcaaactatttaaggaagatcggaattcgtcgaacacttcagtttccgtaatgatctgatcgtctttatccacatgttgtaattcactaaaatctaaaacgtatttttcaatgcataaatcgttctttttattaataatgcagatggaaaatctgtaaacgtgcgttaatttagaaagaacatccagtataagttcttctatatagtcaattaaagcaggatgcctattaatgggaacgaactgcggcaagttgaatgactggtaagtagtgtagtcgaatgactgaggtgggtatacatttctataaaataaaatcaaattaatgtagcattttaagtataccctcagccacttctctacccatctattcataaagctgacgcaacgattactattttttttttcttcttggatctcagtcgtcgcaaaaacgtataccttctttttccgaccttttttttagctttctggaaaagtttatattagttaaacagggtctagtcttagtgtgaaagctagtggtttcgattgactgatattaagaaagtggaaattaaattagtagtgtagacgtatatgcatatgtatttctcgcctgtttatgtttctacgtacttttgatttatagcaaggggaaaagaaatacatactattttttggtaaaggtgaaagcataatgtaaaagctagaataaaatggacgaaataaagagaggcttagttcatcttttttccaaaaagcacccaatgataataactaaaatgaaaaggatttgccatctgtcagcaacatcagttgtgtgagcaataataaaatcatcacctccgttgcctttagcgcgtttgtcgtttgtatcttccgtaattttagtcttatcaatgggaatcataaattttccaatgaattagcaatttcgtccaattctttttgagcttcttcatatttgctttggaattcttcgcacttcttttcccattcatctctttcttcttccaaagcaacgatccttctacccatttgctcagagttcaaatcggcctctttcagtttatccattgcttccttcagtttggcttcactgtcttctagctgttgttctagatcctggtttttcttggtgtagttctcattattagatctcaagttattggagtcttcagccaattgctttgtatcagacaattgactctctaacttctccacttcactgtcgagttgctcgtttttagcggacaaagatttaatctcgttttctttttcagtgttagattgctctaattctttgagctgttctctcagctcctcatatttttcttgccatgactcagattctaattttaagctattcaatttctctttgatc";
    String dna07 = "AAATGCCCTAACTAGATTAAGAAACC";

    dna = dna01; stopCodon = "TAA"; // TAA, TAG, or TGA
    System.out.println((stopCodon + ": " + dna)); startIndex = dna.indexOf(startCodon);
    System.out.println(stopCodon + ": " + startIndex + ", " + dna.length() + ", " + findStopCodon(dna, startIndex, stopCodon));

    dna = dna02; stopCodon = "TAA"; // TAA, TAG, or TGA
    System.out.println((stopCodon + ": " + dna)); startIndex = dna.indexOf(startCodon);
    System.out.println(stopCodon + ": " + startIndex + ", " + dna.length() + ", " + findStopCodon(dna, startIndex, stopCodon));

    dna = dna03; stopCodon = "TAA"; // TAA, TAG, or TGA
    System.out.println((stopCodon + ": " + dna)); startIndex = dna.indexOf(startCodon);
    System.out.println(stopCodon + ": " + startIndex + ", " + dna.length() + ", " + findStopCodon(dna, startIndex, stopCodon));

    dna = dna04; stopCodon = "TAA"; // TAA, TAG, or TGA
    System.out.println((stopCodon + ": " + dna)); startIndex = dna.indexOf(startCodon);
    System.out.println(stopCodon + ": " + startIndex + ", " + dna.length() + ", " + findStopCodon(dna, startIndex, stopCodon));

    dna = dna05; stopCodon = "TAA"; // TAA, TAG, or TGA
    System.out.println((stopCodon + ": " + dna)); startIndex = dna.indexOf(startCodon);
    System.out.println(stopCodon + ": " + startIndex + ", " + dna.length() + ", " + findStopCodon(dna, startIndex, stopCodon));

    dna = dna06; stopCodon = "TAA"; // TAA, TAG, or TGA
    System.out.println((stopCodon + ": " + dna)); startIndex = dna.indexOf(startCodon);
    System.out.println(stopCodon + ": " + startIndex + ", " + dna.length() + ", " + findStopCodon(dna, startIndex, stopCodon) + ", " + dna.indexOf(stopCodon));

    dna = dna06; stopCodon = "TAG"; // TAA, TAG, or TGA
    System.out.println((stopCodon + ": " + dna)); startIndex = dna.indexOf(startCodon);
    System.out.println(stopCodon + ": " + startIndex + ", " + dna.length() + ", " + findStopCodon(dna, startIndex, stopCodon) + ", " + dna.indexOf(stopCodon));

    dna = dna06; stopCodon = "TGA"; // TAA, TAG, or TGA
    System.out.println((stopCodon + ": " + dna)); startIndex = dna.indexOf(startCodon);
    System.out.println(stopCodon + ": " + startIndex + ", " + dna.length() + ", " + findStopCodon(dna, startIndex, stopCodon) + ", " + dna.indexOf(stopCodon));

    dna = dna07; stopCodon = "TAA"; // TAA, TAG, or TGA
    System.out.println((stopCodon + ": " + dna)); startIndex = dna.indexOf(startCodon);
    System.out.println(stopCodon + ": " + startIndex + ", " + dna.length() + ", " + findStopCodon(dna, startIndex, stopCodon));
    
    dna = dna07; stopCodon = "TAG"; // TAA, TAG, or TGA
    System.out.println((stopCodon + ": " + dna)); startIndex = dna.indexOf(startCodon);
    System.out.println(stopCodon + ": " + startIndex + ", " + dna.length() + ", " + findStopCodon(dna, startIndex, stopCodon));
    
    dna = dna07; stopCodon = "TGA"; // TAA, TAG, or TGA
    System.out.println((stopCodon + ": " + dna)); startIndex = dna.indexOf(startCodon);
    System.out.println(stopCodon + ": " + startIndex + ", " + dna.length() + ", " + findStopCodon(dna, startIndex, stopCodon));
  }


}