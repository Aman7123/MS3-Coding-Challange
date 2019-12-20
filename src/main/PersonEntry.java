/**
 * 
 */
package main;

/**
 * This class sets the framework for storing the data in each line of a csv file
 * @author Aaron Renner
 *
 */
public class PersonEntry {
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String profileImage;
	private String paymentMethod;
	private String chargeAmount;
	private String boolValueOne;
	private String boolValueTwo;
	private String place;
	
	/**
	 * 
	 * @param firstName this stores first name in csv file row
	 * @param lastName this stores the last name in csv file row
	 * @param email this stores the email of csv file row
	 * @param gender stores the gener in csv file row
	 * @param profileImage stores the base64 representation of csv file row
	 * @param paymentMethod stores the payment method listed in csv file row
	 * @param chargeAmount stores the charged amount on card
	 * @param boolValueOne stores one of the two boolean values
	 * @param boolValueTwo stores the second out of two boolean values
	 * @param place stores the place of the charge
	 */
	public PersonEntry(String firstName, String lastName, String email, String gender, String profileImage,
			String paymentMethod, String chargeAmount, String boolValueOne,
			String boolValueTwo, String place) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.profileImage = profileImage;
		this.paymentMethod = paymentMethod;
		this.chargeAmount = chargeAmount;
		this.boolValueOne = boolValueOne;
		this.boolValueTwo = boolValueTwo;
		this.place = place;
	}
	
	/**
	 * Outputs the instance of this class as a string
	 */
	public String toString() {
		return this.firstName + ", " + this.lastName + ", " + this.email + ", " + this.gender + ", "+ this.profileImage + ", " + 
				this.paymentMethod + ", " + this.chargeAmount + ", " + this.boolValueOne + ", " + this.boolValueTwo + ", " + this.place;
	}
	
	/**
	 * Get first name
	 * @return first name
	 */
	public String getfirstName() {
		return this.firstName;
	}
	
	/**
	 * Get last name
	 * @return last name
	 */
	public String getlastName() {
		return this.lastName;
	}
	
	/**
	 * Get email
	 * @return email
	 */
	public String getemail() {
		return this.email;
	}
	
	/**
	 * Get gender
	 * @return gender
	 */
	public String getGender() {
		return this.gender;
	}
	
	/**
	 * Get base64 image
	 * @return profile image
	 */
	public String getprofileImage() {
		return this.profileImage;
	}
	
	/**
	 * Get payment method
	 * @return payment method
	 */
	public String getpaymentMethod() {
		return this.paymentMethod;
	}
	
	/**
	 * Get charge amount
	 * @return charge amount
	 */
	public String getchargeAmount() {
		return this.chargeAmount;
	}
	
	/**
	 * Get boolean value
	 * @return boolean value
	 */
	public String getboolOne() {
		return this.boolValueOne;
	}
	
	/**
	 * Get boolean value
	 * @return boolean value
	 */
	public String getboolTwo() {
		return this.boolValueTwo;
	}
	
	/**
	 * Get place
	 * @return place
	 */
	public String getplace() {
		return this.place;
	}
}

