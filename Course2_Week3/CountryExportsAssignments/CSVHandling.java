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
