package com.photoApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.photoApi.photoObjects.PhotoData;

public interface PhotoRepository extends CrudRepository<PhotoData, String> {
	
}
