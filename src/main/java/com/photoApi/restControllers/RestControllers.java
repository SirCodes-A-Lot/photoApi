package com.photoApi.restControllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.photoApi.Constants.ApiConstants;
import com.photoApi.photoObjects.PhotoMetadata;
import com.photoApi.photoObjects.Response;
import com.photoApi.services.PhotoDeleteService;
import com.photoApi.services.PhotoRetrieveService;
import com.photoApi.services.PhotoSaveService;

@RestController
public class RestControllers {
	
	private PhotoSaveService photoSaveService;
	
	private PhotoRetrieveService photoRetrieveService;
	
	private PhotoDeleteService photoDeleteService;
	
	@Autowired
	public RestControllers(PhotoSaveService photoSaveService, PhotoRetrieveService photoRetrieveService,
			PhotoDeleteService photoDeleteService) {
		this.photoSaveService = photoSaveService;
		this.photoRetrieveService = photoRetrieveService;
		this.photoDeleteService = photoDeleteService;
	}
	
	//returns a list of all photos data
	@GetMapping(ApiConstants.GET_ALL_PHOTOS_URL)
	public Response getAllPhotosData(@RequestHeader(ApiConstants.API_KEY) Long apiKey) {
		if (apiKey == null || apiKey - ApiConstants.API_KEY_VALUE != 0) {
			return new Response("403", null);
		}
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response = new Response("200", responseData);
    	response.data.put(ApiConstants.PHOTO_LIST, photoRetrieveService.retrieveAllPhotosMetadata());
		return response;
	}
	
	//returns a requested photo data
	@PostMapping(value = ApiConstants.GET_REQUESTED_PHOTO_METADATA_URL)
    public Response getRequestedPhotoData(@RequestBody HashMap<String,Object> requestData,
    		@RequestHeader(ApiConstants.API_KEY) Long apiKey) {
		if (apiKey == null || apiKey - ApiConstants.API_KEY_VALUE != 0) {
			return new Response("403", null);
		}
		Response response; 
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
		if (requestData.containsKey(ApiConstants.FILENAME)) {
			PhotoMetadata photoMetadata = 
					photoRetrieveService.getPhotoMetadataByFilename((String) requestData.get(ApiConstants.FILENAME));
			responseData.put(ApiConstants.PHOTO_METADATA, photoMetadata);
			response = new Response("200", responseData);
		} else {
			response = new Response("400", responseData);
		}
    	return response;
    }
	
	//uploads a photo to the database
	@PostMapping(value = ApiConstants.PHOTO_URL)
    public Response uploadPhoto(@RequestBody HashMap<String,Object> requestData,
    		@RequestHeader(ApiConstants.API_KEY) Long apiKey) {
		if (apiKey == null || apiKey - ApiConstants.API_KEY_VALUE != 0) {
			return new Response("403", null);
		}
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response; 
    	if (requestData.containsKey(ApiConstants.X_COORDINATE) && requestData.containsKey(ApiConstants.Y_COORDINATE) &&
    			requestData.containsKey(ApiConstants.FILENAME) && requestData.containsKey(ApiConstants.IMAGE_DATA)) {
        	String addPhotoStatus = photoSaveService.savePhotoToDataBase(
        			(String) requestData.get(ApiConstants.FILENAME), (String) requestData.get(ApiConstants.IMAGE_DATA),
        			(String) requestData.get(ApiConstants.FORMAT),
        			Double.valueOf((String) requestData.get(ApiConstants.X_COORDINATE)),
        			Double.valueOf((String) requestData.get(ApiConstants.Y_COORDINATE)));
        	responseData.put(ApiConstants.STATUS_REPORT, addPhotoStatus);
        	if (addPhotoStatus == ApiConstants.SUCCESS) {
        		response = new Response("201", responseData);
        	} else {
        		response = new Response("409", responseData);
        	}
    	} else {
    		response = new Response("400", responseData);
    	}
    	return response;
    }
	
	//deletes a photo from the database
	@DeleteMapping(value = ApiConstants.PHOTO_URL)
    public Response deletePhoto(@RequestBody HashMap<String,Object> requestData,
    		@RequestHeader(ApiConstants.API_KEY) Long apiKey) {
		if (apiKey == null || apiKey - ApiConstants.API_KEY_VALUE != 0) {
			return new Response("403", null);
		}
		Response response; 
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
		if (requestData.containsKey(ApiConstants.FILENAME)) {
			int numberDeleted = 
					photoDeleteService.deleteAllPhotosByFilename((String) requestData.get(ApiConstants.FILENAME));
			responseData.put(ApiConstants.NUMBER_DELETED, numberDeleted);
			response = new Response("200", responseData);
		} else {
			response = new Response("400", responseData);
		}
    	return response;
    }
	
	//get a photo picture
	@PostMapping(value = ApiConstants.GET_REQUESTED_PHOTO_IMAGE_DATA_URL)
    public Response getPhotoPicture(@RequestBody HashMap<String,Object> requestData,
    		@RequestHeader(ApiConstants.API_KEY) Long apiKey) {
		if (apiKey == null || apiKey - ApiConstants.API_KEY_VALUE != 0) {
			return new Response("403", null);
		}
		Response response; 
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
		if (requestData.containsKey(ApiConstants.FILENAME)) {
			String imageData = photoRetrieveService.getImageForPhoto((String) requestData.get(ApiConstants.FILENAME));
			responseData.put(ApiConstants.IMAGE_DATA, imageData);
			response = new Response("200", responseData);
		} else {
			response = new Response("400", responseData);
		}
    	return response;
    }
}
