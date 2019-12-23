# CSV to SQLite

This project was made for Mountain State Software Solutions also known as MS3. This project is made in JAVA and will accept an input on the command line to a CSV file and will parse the file into useable data which is determined by the program and will output a SQLlite database using the sqlite-JDBC library.

## Getting Started

The most simple way to run this program is to check out my most recent build of it located in the "JarBuild" folder.

### Prerequisites

What things you need to do before hand to parse the data.

```
I recommend placing your CSV file into its own folder on the PC. 
This is because my program outputs a CSV file containing bad data, 
a log file, and the DB file all within the folder the original CSV is in.
```

### Installing

If you would like to compile the code yourself, I recommend the eclipse IDE, make sure to add the "BuildAddons" to the library tab.

## Running with a file

To get the program running I recommend using a Shift + Right Click in the folder that contains my ms3CodingChallenge.jar file and clicking "Open PowerShell window here"

### Once the PowerShell window is Open

Once PowerShell is open you are going to want to run the program using java command line arguments to direct the program to the path of the CSV, in this example below you see my CSV file is located in "Documents" under a folder called "csvTest"

```
java -jar .\ms3CodingChallange "C:/Users/Aaron/Documents/csvTest/ms3Interview - Jr Challenge 2.csv"
```

## Built With

* [Eclipse IDE](https://www.eclipse.org/) - My prefered IDE of choice
* [SQLite-JDBC](https://github.com/xerial/sqlite-jdbc) - A great way to get JAVA to connect to a SQLite database

## Versioning

This project will most likely only recieve this version which I'm listing as V-1.0

## Authors

* **Aaron Renner** - *Inital concept work and Senior Developer* - [Aaron Renner](https://github.com/Aman7123)

## License

This is an Open Source project please use any part of it however you please.

## Acknowledgments

* The great people at MS3 for letting me have this chance to join the team 
