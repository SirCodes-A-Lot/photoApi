package com.photoApi.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photoApi.photoObjects.PhotoData;

@Service
public class PhotoSaveService {
	
	private PhotoDatabaseService photoDatabaseService;
	
	@Autowired
	public PhotoSaveService(PhotoDatabaseService photoDatabaseService) {
		this.photoDatabaseService = photoDatabaseService;
	}
	
	public void savePhotoToDataBase(String filename, String format, double xCoord, double yCoord) {
		HashMap<String, String> location = getPhotoLocation(xCoord, yCoord);
		PhotoData photoData = new PhotoData(filename, format, location.get("country"), location.get("city"),
				xCoord, yCoord);
		photoDatabaseService.savePhotoToDatabase(photoData);
	}
	
	/**
	 * gets the location of the photo from coords to populate metadata
	 */
	private HashMap<String, String> getPhotoLocation(double xCoord, double yCoord) {
		HashMap<String, String> location = new HashMap<>();
		//TODO get location data and populate into hashmap
		location.put("city", "city will go here");
		location.put("country", "country will go here");
		
		return location;
	}
}
