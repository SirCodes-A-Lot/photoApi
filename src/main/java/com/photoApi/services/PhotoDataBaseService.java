package com.photoApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.photoApi.photoObjects.PhotoData;
import com.photoApi.repository.PhotoRepository;

public class PhotoDataBaseService {
	
	private PhotoRepository photoRepository;
	
	@Autowired
	public PhotoDataBaseService(PhotoRepository photoRepository) {
		this.photoRepository = photoRepository;
	}
	
	public void savePhotoToDatabase (PhotoData photoData) {
		photoRepository.save(photoData);
	}
	
	public ArrayList<PhotoData> retrieveAllPhotos() {
		Iterable <PhotoData> photoIterable = photoRepository.findAll();
		ArrayList<PhotoData> photoDataList = new ArrayList<>();
		photoIterable.forEach(photoDataList::add);
		return photoDataList;
	}

}
