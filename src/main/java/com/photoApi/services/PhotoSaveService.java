package com.photoApi.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

public class PhotoSaveService {
	
	private PhotoDatabaseService photoDatabaseService;
	
	@Autowired
	public PhotoSaveService(PhotoDatabaseService photoDatabaseService) {
		this.photoDatabaseService = photoDatabaseService;
	}
	
	public void savePhotoToDataBase(String filename, double xCoord, double yCoord) {
		//retrieve metadata
		//save a the PhotoData to the database
	}
	
	/**
	 * gets the location of the photo from coords to populate metadata
	 */
	private HashMap<String, String> getPhotoLocation(double xCoord, double yCoord) {
		HashMap<String, String> location = new HashMap<>();
		//TODO get location data and populate into hashmap
		return location;
	}
}
