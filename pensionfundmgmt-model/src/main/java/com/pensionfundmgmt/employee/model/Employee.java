	package com.pensionfundmgmt.employee.model;

	public class Employee {
	
		private long id;
	
		private String firstName;
		
		private String lastName;
		
		private String emailId;
		
		private String passportNumber;
	
		public Employee() {
	
		}
	
		public Employee(String firstName, String lastName, String emailId) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailId = emailId;
		}
	
		public long getId() {
			return id;
		}
	
		public void setId(long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}
	
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
	

		public String getLastName() {
			return lastName;
		}
	
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	

		public String getEmailId() {
			return emailId;
		}
	
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getPassportNumber() {
			return passportNumber;
		}
	
		public void setPassportNumber(String passportNumber) {
			this.passportNumber = passportNumber;
		}
	
	}