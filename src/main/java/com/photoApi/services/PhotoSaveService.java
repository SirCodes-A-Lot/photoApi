package com.photoApi.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.photoApi.Constants.ApiConstants;
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
			return ApiConstants.ERROR_FILENAME_TAKEN;
		}
		
		PhotoData photoWithImageData = photoDatabaseService.findPhotoByPhotoData(imageData);
		if (photoWithImageData!= null) {
			return ApiConstants.ERROR_ALREADY_UPLOADED_FILENAME_IS + photoWithImageData.getFilename();
		}
		HashMap<String, String> location = getPhotoLocation(xCoord, yCoord);
		PhotoData photoData = new PhotoData(filename, imageData, format, location.get(ApiConstants.COUNTRY),
				location.get(ApiConstants.CITY), xCoord, yCoord);
		photoDatabaseService.savePhotoToDatabase(photoData);
		return ApiConstants.SUCCESS;
	}
	
	/**
	 * gets the location of the photo from coords to populate metadata
	 */
	@SuppressWarnings("unchecked")
	private HashMap<String, String> getPhotoLocation(double xCoord, double yCoord) {
		HashMap<String, String> location = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        String geocodeUrl = ApiConstants.GEOCODE_URL_START + xCoord + "," + yCoord + ApiConstants.GEOCODE_URL_END;
		HashMap<String, Object> locationData = restTemplate.getForObject(geocodeUrl, HashMap.class);
		location.put(ApiConstants.CITY, (String) locationData.get(ApiConstants.CITY));
		location.put(ApiConstants.COUNTRY, (String) locationData.get(ApiConstants.COUNTRY));
		
		return location;
	}
}
