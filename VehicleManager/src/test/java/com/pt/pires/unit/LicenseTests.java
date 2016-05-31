package com.pt.pires.unit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pt.pires.VehicleManagerApplication;
import com.pt.pires.domain.License;
import com.pt.pires.domain.exceptions.InvalidLicenseException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VehicleManagerApplication.class)
public class LicenseTests {

	private final static String VALID_LICENSE_1 = "44-11-HH";
	private final static String VALID_LICENSE_2 = "11-GG-19";
	private final static String VALID_LICENSE_3 = "KI-02-45";
	
	private final static String INVALID_LICENSE_1 = "AG-GG-21";
	private final static String INVALID_LICENSE_2 = "AV-22-TY";
	
	@Test
	public void validLicense1() throws InvalidLicenseException{
		License license = new License(VALID_LICENSE_1,new Date());
		assertTrue(license.getLicense().equals(VALID_LICENSE_1));
	}
	
	@Test
	public void validLicense2() throws InvalidLicenseException{
		License license = new License(VALID_LICENSE_2,new Date());
		assertTrue(license.getLicense().equals(VALID_LICENSE_2));
	}
	
	@Test
	public void validLicense3() throws InvalidLicenseException{
		License license = new License(VALID_LICENSE_3,new Date());
		assertTrue(license.getLicense().equals(VALID_LICENSE_3));
	}
	
	@Test(expected = InvalidLicenseException.class)
	public void invalidLicense1() throws InvalidLicenseException{
		new License(INVALID_LICENSE_1,new Date());
	}
	
	@Test(expected = InvalidLicenseException.class)
	public void invalidLicense2() throws InvalidLicenseException{
		new License(INVALID_LICENSE_2,new Date());
	}
}
