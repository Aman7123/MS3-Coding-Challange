package main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;
import java.sql.Statement;  

/**
 * This class handles all the database management work such as connect, create table, and insert
 * @author Aaron
 *
 */
public class CreateDB {
	
	private String dbLocation;
	private Logger logger;
	private Connection connection;
	
	/**
	 * This method instantiates the database info
	 * @param dbLocation location to create the db file
	 * @param loggerIn pass in the logger class
	 */
	public CreateDB(String dbLocation, Logger loggerIn) {
		this.dbLocation = dbLocation;
		this.logger = loggerIn;
        String url = "jdbc:sqlite:" + this.dbLocation;  
        
        try { 
            this.connection = DriverManager.getConnection(url);  
            if (this.connection != null) {
                DatabaseMetaData meta = this.connection.getMetaData();
                logger.logData("Connection to DB is green");
                System.out.println("The driver name is " + meta.getDriverName());  
                System.out.println("A new database has been created.");  
            }  
   
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            logger.logData("Connection to DB is a no go");
        } 
	}
   
  /**
   * This method will be looped by the main method to insert a row into the DB
   * @param the data to be inserted into the db
   */
    public void insert(String firstName, String lastName, String email, String gender, String profileImage,
			String paymentMethod, String chargeAmount, String boolValueOne,
			String boolValueTwo, String place) {  
        String sql = "INSERT INTO transactions(firstName, lastName, email, gender, profileImage, paymentMethod, chargeAmount, booleanValueOne, booleanValueTwo, place) VALUES(?,?, ?, ?, ?, ?, ?, ?, ?, ?)";  
   
        try{  
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, firstName);  
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, gender);
            pstmt.setString(5, profileImage);
            pstmt.setString(6, paymentMethod);
            pstmt.setString(7, chargeAmount);
            pstmt.setString(8, boolValueOne);
            pstmt.setString(9, boolValueTwo);
            pstmt.setString(10, place);
            pstmt.executeUpdate();
            logger.logData("Added " + firstName + "," + lastName + " to DB");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    
    /**
     * This method will create the table in the DB for data to be put into
     */
    public void CreateTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:" + dbLocation;  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS transactions (\n"  
                + " id integer PRIMARY KEY,\n"  
                + " firstName text NOT NULL,\n"
                + " lastName text NOT NULL,\n"
                + " email text NOT NULL,\n"
                + " gender text NOT NULL,\n"
                + " profileImage text NOT NULL,\n"
                + " paymentMethod text NOT NULL,\n"
                + " chargeAmount text NOT NULL,\n"
                + " booleanValueOne text NOT NULL,\n"
                + " booleanValueTwo text NOT NULL,\n"
                + " place text NOT NULL \n"
                + ");";  
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
}