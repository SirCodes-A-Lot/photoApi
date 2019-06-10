package com.photoApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photoApi.photoObjects.PhotoData;
import com.photoApi.photoObjects.PhotoMetadata;

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
		//TODO do null check
		return photoDatabaseService.getPhotoDataByFilename(filename).getImageData();
	}
	
	public PhotoMetadata getPhotoMetadataByFilename(String filename){
		PhotoData photoData = photoDatabaseService.getPhotoDataByFilename(filename);
		if (photoData != null) {
			return new PhotoMetadata(photoData);
		} else {
			return null;
		}
	}

}
