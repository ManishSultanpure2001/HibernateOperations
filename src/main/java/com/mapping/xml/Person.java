package com.mapping.xml;

public class Person {
	
	private int personId;
	private String personName;
	private String personAddress;
	private String personPhone;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int personId, String personName, String personAddress, String personPhone) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personAddress = personAddress;
		this.personPhone = personPhone;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personePhone) {
		this.personPhone = personPhone;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personAddress=" + personAddress
				+ ", personePhone=" + personPhone + "]";
	}
	
	
	
}
