package com.pt.pires.services.external;

import com.pt.pires.domain.exceptions.VehicleManagerException;

public interface IFileService {

	void addPortraitImage(String vehicleName,byte[] imageBytes) throws VehicleManagerException;
	
	void addFileToVehicle(String vehicleName,byte[] file) throws VehicleManagerException;
	
}
