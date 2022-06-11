/**
 * Write a description of CSVHandling here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class CSVHandling {

  public void tester(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();

    parser = fr.getCSVParser();
    String country = "Namibia";
    System.out.println(countryInfo(parser, country));

    parser = fr.getCSVParser();
    String exportItem1 = "gold";
    String exportItem2 = "diamonds";
    listExportersTwoProducts(parser, exportItem1, exportItem2);

    parser = fr.getCSVParser();
    String exportItem = "gold";
    System.out.println(numberOfExporters(parser, exportItem));

    parser = fr.getCSVParser();
    String string = "$999,999,999";
    bigExporters(parser, string);
  }

  public void bigExporters(CSVParser parser, String string){
    for (CSVRecord record : parser) {
      String rUsdValue = record.get("Value (dollars)"); 
      if (rUsdValue.length()>string.length()) {
        String rCountry = record.get("Country");
        System.out.println(rCountry+" "+rUsdValue);
      }
    }
  }

  public int numberOfExporters(CSVParser parser, String exportItem){
    int ctr = 0;
    for (CSVRecord record : parser) {
      String rExports = record.get("Exports");
      if (rExports.contains(exportItem)) {
        ctr += 1;
      }
    }
    return ctr;
  }

  public void listExportersTwoProducts(CSVParser parser, 
    String exportItem1, String exportItem2){
    for (CSVRecord record : parser) {
      String rExports = record.get("Exports");
      if (rExports.contains(exportItem1) 
          && rExports.contains(exportItem2)) 
      {
        String rCountry = record.get("Country");
        System.out.println(rCountry);
      }
    }
  }

  public String countryInfo(CSVParser parser, String country){
    for (CSVRecord record : parser) {
      String rCountry = record.get("Country");
      if (rCountry.contains(country)) {
        String exports = record.get("Exports");
        String usdValue = record.get("Value (dollars)"); 
        return country+": "+exports+": "+usdValue;
      }
    }
    return "NOT FOUND";
  }

  public void readExports(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    for (CSVRecord record : parser) {
      System.out.println(record.get("Country"));
    }
  }

  public void testPrintExportersOf() {
    printExportersOf("gold");
  }

  public void printExportersOf(String product) {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    for (CSVRecord record : parser) {
      String exports = record.get("Exports");
      if (exports.indexOf(product) != -1) {
        System.out.println(record.get("Country"));
      }
    }
  }

}
