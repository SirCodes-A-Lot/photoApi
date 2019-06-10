package com.photoApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoDeleteService {
	
	PhotoDatabaseService photoDatabaseService;
	
	@Autowired
	public PhotoDeleteService (PhotoDatabaseService photoDatabaseService) {
		this.photoDatabaseService = photoDatabaseService;
	}

	public int deleteAllPhotosByFilename(String filename) {
		return photoDatabaseService.deleteAllPhotosByFilename(filename);
	}
	

}
