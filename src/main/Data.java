/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class creates the Arrays that hold data for the CSV files
 * @author Aaron Renner
 *
 */
public class Data {
	private ArrayList<PersonEntry> entryArray = new ArrayList<PersonEntry>();
	private ArrayList<String> rejectedLine = new ArrayList<String>();
	private PersonEntry personEntryPlaceHolder;
	private String csvSeperator = ",";
	private File outputDirectory;
	private Logger logger;
	private String newline = "\n";
	
	public Data() {}
	/**
	 * This instantiates the data collection method that will pull data from the CSV file
	 * @param csvFile location of the CSV file
	 * @param outputDirectory parent folder for CSV file -Where To Output-
	 */
	public Data(File csvFile, File outputDirectory, Logger loggerIn) {
		this.outputDirectory = outputDirectory;
		this.logger = loggerIn;
		logger.logData("Starting to read CSV" + newline);
		readCSV(csvFile);
		logger.logData("Finished reading and parsing CSV" + newline);
		logger.logData("Writing bad CSV entries to rejected.csv" + newline);
		writeMistakes(rejectedLine, this.outputDirectory);
		logger.logData("Finised CSV work, I have array of good entries" + newline);
	}
	
	/**
	 * Reads the CSV file
	 * @param csvFile location of CSV file
	 */
	private void readCSV(File csvFile) {
		long count = 0;
		String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] lineEntry = line.split(csvSeperator);
                int lineEntryLength = lineEntry.length;
                if(count>0) {
                	if(lineEntryLength > 9 && lineEntry[9] != null) {
	            		personEntryPlaceHolder = new PersonEntry(lineEntry[0], lineEntry[1], lineEntry[2], lineEntry[3], lineEntry[4], lineEntry[5], lineEntry[6], lineEntry[7], lineEntry[8], lineEntry[9]);
	            		entryArray.add(personEntryPlaceHolder);
                	} else {
                		rejectedLine.add(line);
                	}
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Call this to get the parsed items in the CSV file
	 * @return Array that holds CSV data
	 */
	public ArrayList<PersonEntry> getDataEntry() {
		return entryArray;
	}
	
	/**
	 * Takes the records that dont comply with the format rules and outputs into rejected csv file
	 * @param inputFile array for rejected records
	 * @param location the parent file location for the output stuff
	 */
	private void writeMistakes(ArrayList<String> inputFile, File location) {
		String fileLocation = location.toString();
		try {
			FileWriter writeToFile = new FileWriter(fileLocation + "/" + "ms3CodingChallange - REJECTED.csv");
			for(String s : inputFile) {
				writeToFile.append(s + "\n");
				System.out.println(s);
			}
			writeToFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
