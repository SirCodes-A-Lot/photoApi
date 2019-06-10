package com.photoApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.photoApi.photoObjects.PhotoData;
import java.lang.String;

public interface PhotoRepository extends CrudRepository<PhotoData, String> {

	PhotoData findByFilename(String filename);
	
	PhotoData findByImageData(String imagedata);

	@Transactional
	int deleteAllByFilename(String filename);
	
}
