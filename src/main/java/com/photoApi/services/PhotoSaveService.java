package com.photoApi.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.photoApi.photoObjects.PhotoData;

@Service
public class PhotoSaveService {
	
	private PhotoDatabaseService photoDatabaseService;
	
	@Autowired
	public PhotoSaveService(PhotoDatabaseService photoDatabaseService) {
		this.photoDatabaseService = photoDatabaseService;
	}
	
	public String savePhotoToDataBase(String filename, String imageData, String format, double xCoord, double yCoord) {
		if (photoDatabaseService.findPhotoDataByFilename (filename)!= null) {
			return "ERROR: file name taken";
		}
		
		PhotoData photoWithImageData = photoDatabaseService.findPhotoByPhotoData(imageData);
		if (photoWithImageData!= null) {
			return "ERROR: this image has already been uploaded. Filename is: " + photoWithImageData.getFilename();
		}
		HashMap<String, String> location = getPhotoLocation(xCoord, yCoord);
		PhotoData photoData = new PhotoData(filename, imageData, format, location.get("country"), location.get("city"),
				xCoord, yCoord);
		photoDatabaseService.savePhotoToDatabase(photoData);
		return "Success";
	}
	
	/**
	 * gets the location of the photo from coords to populate metadata
	 */
	@SuppressWarnings("unchecked")
	private HashMap<String, String> getPhotoLocation(double xCoord, double yCoord) {
		HashMap<String, String> location = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        String geocodeUrl = "https://geocode.xyz/" + xCoord + "," + yCoord + "?json=1&auth=320198293500272387838x2579";
		HashMap<String, Object> locationData = restTemplate.getForObject(geocodeUrl, HashMap.class);
		location.put("city", (String) locationData.get("city"));
		location.put("country", (String) locationData.get("country"));
		
		return location;
	}
}
