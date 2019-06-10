package com.photoApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photoApi.photoObjects.PhotoData;
import com.photoApi.repositories.PhotoRepository;

@Service
public class PhotoDatabaseService {
	
	private PhotoRepository photoRepository;
	
	@Autowired
	public PhotoDatabaseService(PhotoRepository photoRepository) {
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

	public PhotoData findPhotoDataByFilename(String filename) {
		return photoRepository.findByFilename(filename);
	}

	public int deleteAllPhotosByFilename(String filename) {
		return photoRepository.deleteAllByFilename(filename);
	}
	
	public PhotoData findPhotoByPhotoData(String imageData) {
		return photoRepository.findByImageData(imageData);
	}

}
