package com.pt.pires.domain;

import java.util.Date;

import com.pt.pires.domain.exceptions.InvalidLicenseException;

public class License {

	/* Should not be persisted. */
    private static final String license1 = "(^[A-Z]{2}-[A-Z]{2}-[0-9]{2}$)";
    private static final String license2 = "(^[A-Z]{2}-[0-9]{2}-[A-Z]{2}$)";
    private static final String license3 = "(^[0-9]{2}-[A-Z]{2}-[A-Z]{2}$)";
    private static final String license_pattern = license1 + "|" + license2 + "|" + license3;
	
	private String license;
	
	private Date date;
	
	public License(String license,Date date) throws InvalidLicenseException{
		setLicense(license);
		this.date = date;
	}
	
	public String getLicense(){
		return license;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public void setLicense(String license) throws InvalidLicenseException{
		if(!license.matches(license_pattern)){
			throw new InvalidLicenseException();
		}
		this.license = license;
	}
	
	@Override
	public boolean equals(Object obj) {
		License license = (License) obj;
		return this.license.equals(license.getLicense()) && 
				(this.date.compareTo(license.getDate()) == 0);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}