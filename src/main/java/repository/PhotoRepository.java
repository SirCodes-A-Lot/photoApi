package repository;

import org.springframework.data.repository.CrudRepository;

import com.photoApi.photoObjects.PhotoData;

public interface PhotoRepository extends CrudRepository<PhotoData, String> {
	
}
