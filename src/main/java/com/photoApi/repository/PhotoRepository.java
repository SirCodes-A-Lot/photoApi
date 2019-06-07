package com.photoApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.photoApi.photoObjects.PhotoData;

@Repository
public interface PhotoRepository extends CrudRepository<PhotoData, String> {
	
}
