package com.photoApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.photoApi.photoObjects.PhotoData;

public interface PhotoRepository extends CrudRepository<PhotoData, String> {

	String findByFilename(String filename);

	@Transactional
	int deleteAllByFilename(String filename);
	
}
