package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	
	private String logFileName = "ms3CodingChallangeLog.txt";
	private File logFile;
	
	public Logger(String directory) {
		logFile = new File(directory + "\\" + logFileName);
		System.out.println(logFile.getAbsolutePath());
	}
	
	public void logData(String stringToWrite) {
		try {
			FileWriter fr = new FileWriter(logFile, true);
			fr.write(stringToWrite);
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
