package com.photoApi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

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
	
	public ArrayList<PhotoMetadata> retrieveAllPhotosMetadata() {
		ArrayList<PhotoData> photoDataList = photoDatabaseService.retrieveAllPhotos();
		ArrayList<PhotoMetadata> photoMetadataList = new ArrayList<>();
		ListIterator<PhotoData> photoDataIterator  = photoDataList.listIterator();
		while (photoDataIterator.hasNext()) {
			photoMetadataList.add(new PhotoMetadata(photoDataIterator.next()));
		}
		return photoMetadataList;
	}
	
	public String getImageForPhoto(String filename) {
		PhotoData photoData = photoDatabaseService.getPhotoDataByFilename(filename);
		if (photoData != null) {
			return photoData.getImageData();
		}
		return null;
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
