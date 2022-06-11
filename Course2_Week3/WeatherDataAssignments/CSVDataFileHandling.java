
/**
 * Write a description of CSVDataFileHandling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class CSVDataFileHandling {

  public String fileWithColdestTemperature(){
    CSVRecord coldestRecord = null;
    DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles()){
      FileResource fr = new FileResource(f);
      CSVRecord record = coldestHourInFile();
    }
    return "";
  }

  public void testColdestHourInFile(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    CSVRecord coldestHour = coldestHourInFile(parser);
    System.out.println(coldestHour.get("TemperatureF"));
  }

  public CSVRecord coldestHourInFile(CSVParser parser){
    CSVRecord coldestHourRecord = null;
    for (CSVRecord record : parser){
      if (coldestHourRecord == null){
        coldestHourRecord = record;
      } else {
        coldestHourRecord = getColdestRecord(record, 
          coldestHourRecord);
      }
    }
    return coldestHourRecord;
  }

  public CSVRecord getColdestRecord(CSVRecord r1, CSVRecord r2){
    double tR1 = Double.parseDouble(r1.get("TemperatureF"));
    if (tR1 < -459.67) {return r2;}
    double tR2 = Double.parseDouble(r2.get("TemperatureF"));
    if (tR2 < -459.67) {return r1;}
    if (tR1 < tR2) {return r1;} else {return r2;}
  }

  public void tester0(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();

    parser = fr.getCSVParser();
    String country = "Nauru";
    System.out.println(countryInfo(parser, country));

    parser = fr.getCSVParser();
    String exportItem1 = "fish";
    String exportItem2 = "nuts";
    listExportersTwoProducts(parser, exportItem1, exportItem2);

    parser = fr.getCSVParser();
    String exportItem = "gold";
    System.out.println(numberOfExporters(parser, exportItem));

    parser = fr.getCSVParser();
    String string = "$999,999,999,999";
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
      if (rCountry.equals(country)) {
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
