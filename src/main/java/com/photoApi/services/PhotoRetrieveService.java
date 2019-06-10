package com.photoApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photoApi.photoObjects.PhotoData;

@Service
public class PhotoRetrieveService {
	
	private PhotoDatabaseService photoDatabaseService;
	
	@Autowired
	public PhotoRetrieveService(PhotoDatabaseService photoDatabaseService) {
		this.photoDatabaseService = photoDatabaseService;
	}
	
	public ArrayList<PhotoData> retrieveAllPhotos() {
		return photoDatabaseService.retrieveAllPhotos();
	}
	
	public String getImageForPhoto(String filename) {
		return photoDatabaseService.getImageByFilename(filename);
	}

}
