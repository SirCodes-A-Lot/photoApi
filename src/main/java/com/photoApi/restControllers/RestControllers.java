package com.photoApi.restControllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.photoApi.photoObjects.PhotoMetadata;
import com.photoApi.photoObjects.Response;
import com.photoApi.services.PhotoDeleteService;
import com.photoApi.services.PhotoRetrieveService;
import com.photoApi.services.PhotoSaveService;

@RestController
public class RestControllers {
	
	private final Long API_KEY = 5634563846456L;
	
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
	@GetMapping("/getAllPhotosData")
	public Response getAllPhotosData(@RequestHeader("Api-Key") Long apiKey) {
		if (apiKey == null || apiKey - API_KEY != 0) {
			return new Response("403", null);
		}
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response = new Response("200", responseData);
    	response.data.put("photoList", photoRetrieveService.retrieveAllPhotosMetadata());
		return response;
	}
	
	//returns a requested photo data
	@PostMapping(value = "/getRequestedPhotoData")
    public Response getRequestedPhotoData(@RequestBody HashMap<String,Object> requestData, @RequestHeader("Api-Key") Long apiKey) {
		if (apiKey == null || apiKey - API_KEY != 0) {
			return new Response("403", null);
		}
		Response response; 
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
		if (requestData.containsKey("filename")) {
			PhotoMetadata photoMetadata = photoRetrieveService.getPhotoMetadataByFilename((String) requestData.get("filename"));
			responseData.put("photoMetadata", photoMetadata);
			response = new Response("200", responseData);
		} else {
			response = new Response("400", responseData);
		}
    	return response;
    }
	
	//uploads a photo to the database
	@PostMapping(value = "/photo")
    public Response uploadPhoto(@RequestBody HashMap<String,Object> requestData, @RequestHeader("Api-Key") Long apiKey) {
		if (apiKey == null || apiKey - API_KEY != 0) {
			return new Response("403", null);
		}
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response; 
    	if (requestData.containsKey("xcoord") && requestData.containsKey("ycoord") &&
    			requestData.containsKey("filename") && requestData.containsKey("imageData")) {
        	String addPhotoStatus = photoSaveService.savePhotoToDataBase(
        			(String) requestData.get("filename"), (String) requestData.get("imageData"),
        			(String) requestData.get("format"),
        			Double.valueOf((String) requestData.get("xcoord")),
        			Double.valueOf((String) requestData.get("ycoord")));
        	responseData.put("Status", addPhotoStatus);
        	response = new Response("200", responseData);
    	} else {
    		response = new Response("400", responseData);
    	}
    	return response;
    }
	
	//deletes a photo from the database
	@DeleteMapping(value = "/photo")
    public Response deletePhoto(@RequestBody HashMap<String,Object> requestData, @RequestHeader("Api-Key") Long apiKey) {
		if (apiKey == null || apiKey - API_KEY != 0) {
			return new Response("403", null);
		}
		Response response; 
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
		if (requestData.containsKey("filename")) {
			int numberDeleted = photoDeleteService.deleteAllPhotosByFilename((String) requestData.get("filename"));
			responseData.put("numberDeleted", numberDeleted);
			response = new Response("200", responseData);
		} else {
			response = new Response("400", responseData);
		}
    	return response;
    }
	
	//get a photo picture
	@PostMapping(value = "/getPhotoPicture")
    public Response getPhotoPicture(@RequestBody HashMap<String,Object> requestData, @RequestHeader("Api-Key") Long apiKey) {
		if (apiKey == null || apiKey - API_KEY != 0) {
			return new Response("403", null);
		}
		Response response; 
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
		if (requestData.containsKey("filename")) {
			String imageData = photoRetrieveService.getImageForPhoto((String) requestData.get("filename"));
			responseData.put("imageData", imageData);
			response = new Response("200", responseData);
		} else {
			response = new Response("400", responseData);
		}
    	return response;
    }
}
