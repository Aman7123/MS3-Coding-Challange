/**
 * 
 */
package main;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Aaron Renner
 *
 */
public class Data {
	private ArrayList<PersonEntry> entryArray = new ArrayList<PersonEntry>();
	private ArrayList<String> rejectedLine = new ArrayList<String>();
	private PersonEntry personEntryPlaceHolder;
	private String csvSeperator = ",";
	private File outputDirectory;
	
	public Data() {
	}
	
	public Data(File csvFile, File outputDirectory) {
		this.outputDirectory = outputDirectory;
		readCSV(csvFile);
		writeMistakes(rejectedLine, this.outputDirectory);
	}
	
	private void readCSV(File csvFile) {
		long count = 0;
		String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] lineEntry = line.split(csvSeperator);
                int lineEntryLength = lineEntry.length;
                if(count>0) {
                	if(lineEntryLength > 9 && lineEntry[9] != null) {
	            		personEntryPlaceHolder = new PersonEntry(lineEntry[0], lineEntry[1], lineEntry[2], lineEntry[3], lineEntry[4], lineEntry[4], lineEntry[5], lineEntry[6], lineEntry[7], lineEntry[8], lineEntry[9]);
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
	
	public void writeToLog(String line) {
		
	}
}
