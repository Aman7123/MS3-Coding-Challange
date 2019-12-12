/**
 * 
 */
package main;

/**
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
	
	public PersonEntry(String firstName, String lastName, String email, String gender, String profileImage,
			String paymentMethod, String paymentAmount, String chargeAmount, String boolValueOne,
			String boolValueTwo, String place) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.profileImage = profileImage;
		this.paymentMethod = paymentAmount;
		this.chargeAmount = chargeAmount;
		this.boolValueOne = boolValueOne;
		this.boolValueTwo = boolValueTwo;
		this.place = place;
}
	public String toString() {
		return this.firstName + ", " + this.lastName + ", " + this.email + ", " + this.gender + ", "+ this.profileImage + ", " + 
				this.paymentMethod + ", " + this.chargeAmount + ", " + this.boolValueOne + ", " + this.boolValueTwo + ", " + this.place;
	}
	
	public String getfirstName() {
		return this.firstName;
	}
	
	public String getlastName() {
		return this.lastName;
	}
	
	public String getemail() {
		return this.email;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public String getprofileImage() {
		return this.profileImage;
	}
	
	public String getpaymentMethod() {
		return this.paymentMethod;
	}
	
	public String getchargeAmount() {
		return this.chargeAmount;
	}
	
	public String getboolOne() {
		return this.boolValueOne;
	}
	
	public String getboolTwo() {
		return this.boolValueTwo;
	}
	
	public String getplace() {
		return this.place;
	}
}

