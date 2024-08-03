package EmailApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "dreamcompany.com";
 	
    //	Constructor
	
	public Email(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
//		Call a method asking for department
		
		this.department = setDepartment();
		
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
//		Combine elements to generate mail
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		
	}
	
	private String setDepartment() {
		System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Devlopmen\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {return "sales"; }
		else if (depChoice == 2) {return "dev"; }
		else if (depChoice == 3) {return "acc"; }
		else { return ""; }
	}
	
	private String randomPassword(int length) {
		String passwordSet= "ABCDEFGHIJKLMNQSTUVWXYZ0123456789!@#$%";
		char[] password  = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
   }
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity  = capacity;
		
	}
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() {return alternateEmail; }
	public String getPassword() {return password; }
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
	
}
