package main;

import java.io.File;

public class MS3_Coding_Challange {
	
	private Data dataProcessing;

	public static void main(String[] args) {
		if(args.length > 1 && args[1] != null) {
			File fileToRead = new File(args[0]);
			File pathToWrite = new File(args[1]);
			if(fileToRead.isFile() || pathToWrite.isDirectory()) {
				new Data(fileToRead, pathToWrite);
			}			
		}

	}
	
	

}
