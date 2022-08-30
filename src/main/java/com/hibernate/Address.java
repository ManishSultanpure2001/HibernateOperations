package com.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "student_address") // Modifiy table
public class Address {
	@Id // for primary kry
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for auto increment
	@Column(name = "address_id") // for change column name
	private int id;
	
	@Column(length = 50,name="STREAT")
	private String streat;
	
	private String city;
	@Column(name="is_open")
	private boolean isOpen;
	
	@Transient// skip this column to create in table
	private double x;
	
	@Column(name="add_date")
	@Temporal(TemporalType.DATE)// it will give only Date 
	private Date addedDate;
	@Lob// for the large object
	private byte[] image;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String streat, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
		super();
		this.id = id;
		this.streat = streat;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedDate = addedDate;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreat() {
		return streat;
	}

	public void setStreat(String streat) {
		this.streat = streat;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
