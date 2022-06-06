
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

  public int findStopCodon(String dna, int startIndex, String stopCodon) {
    if (startIndex == -1) {return dna.length();}
    int index = 0;
    int remainder = 1;
    while(remainder != 0 && index != -1) {
      index = dna.toLowerCase().indexOf(stopCodon.toLowerCase(),startIndex);
      if (index == -1) {return dna.length();}
      remainder = (index-startIndex)%3;
      // un-comment the below to see the iterations:
      //System.out.println("  >>: " + startIndex + ", " + index + ", " + remainder);
      startIndex = index + 1;
    }
    if (remainder == 0) {return index;}
    return dna.length();
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

    System.out.println(-3%3);

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
