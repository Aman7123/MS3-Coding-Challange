package main;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
/**
 * This is the main class that will run when executing
 * @author Aaron
 *
 */
public class MS3_Coding_Challange {
	
	private static Data dataProcessing;
	private static CreateDB dbCommands;
	private static ArrayList<PersonEntry> entryArray;
	private static File csvFile;
	private static File csvFileOutput;
	private static String csvFileOutputasString;
	private static Logger logger;
	private static String newline = "\n";
	private static long startTime = System.nanoTime();

	/**
	 * This is the main running class of the program, everything in a chain happens here and should be run from a command line
	 * The process is as follows:
	 * 1. Gets the CSV file and makes sure it meets standards of execution
	 * 2. Sends that CSV file off to be parsed and split into good and bad data
	 * 3. We aquire the Array containing good data
	 * 4. We create a sqlite database
	 * 5. We create a table for the data to be entered into
	 * 6. We insert the data into the database
	 * 
	 * @param args file location of the csv file on HDD
	 */
	public static void main(String[] args) {
		try {
			if(args[0] != null) {
				csvFile = new File(args[0]);
				if(csvFile.exists() && csvFile.canRead()) {
					csvFileOutput = csvFile.getParentFile();
					csvFileOutputasString = csvFileOutput.getPath();
					logger = new Logger(csvFileOutputasString);
					logger.logData("Logger established, 'starting program'" + newline);
					logger.logData("Starting CSV splitting" + newline);
					dataProcessing = new Data(csvFile, csvFileOutput, logger);
					entryArray = dataProcessing.getDataEntry();
					logger.logData("Creating sqlite DB, and connecting" + newline);
					dbCommands = new CreateDB(csvFileOutput + "\\ms3CodingChallange.db", logger);
					logger.logData("Creating table in DB" + newline);
					dbCommands.CreateTable();
					logger.logData("Starting to parse data into DB" + newline);
					for(PersonEntry PE : entryArray) {
						dbCommands.insert(PE.getfirstName(), PE.getlastName(), 
											PE.getemail(), PE.getGender(), PE.getprofileImage(), 
											PE.getpaymentMethod(), PE.getchargeAmount(), PE.getboolOne(), PE.getboolTwo(), PE.getplace());
					}
					wrapUpTime();
				}
				else {
					popupError("You have given file location but it is read only or does not exist");
				}
			
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			popupError("No location to csv file given \n" + e);
		}
	}
	
	private static void wrapUpTime() {
		long endTime = System.nanoTime();
		long durationInNano = (endTime - startTime);
		long durationInMillis = TimeUnit.NANOSECONDS.toMillis(durationInNano);
		logger.logData("Program Runtime: " + durationInMillis + " milliseconds");
		
	}

	/**
	 * This method creates a popup letting you know you messed up providing the location of the CSV file
	 * @param message input message to display
	 */
	private static void popupError(String message) {
		JOptionPane.showMessageDialog(null, message, "ms3 Coding Challange", JOptionPane.INFORMATION_MESSAGE);
	}

}
