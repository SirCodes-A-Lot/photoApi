package com.photoApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.photoApi.photoObjects.PhotoData;

public interface PhotoRepository extends CrudRepository<PhotoData, String> {

	PhotoData findByFilename(String filename);

	@Transactional
	int deleteAllByFilename(String filename);
	
}
