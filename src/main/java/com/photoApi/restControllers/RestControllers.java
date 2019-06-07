package com.photoApi.restControllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.photoApi.photoObjects.Response;
import com.photoApi.services.PhotoRetrieveService;
import com.photoApi.services.PhotoSaveService;

@RestController
public class RestControllers {
	
	private PhotoSaveService photoSaveService;
	
	private PhotoRetrieveService photoRetrieveService;
	
	@Autowired
	public RestControllers(PhotoSaveService photoSaveService, PhotoRetrieveService photoRetrieveService) {
		this.photoSaveService = photoSaveService;
		this.photoRetrieveService = photoRetrieveService;
	}
	
	//returns a list of all photos data
	@GetMapping("/getAllPhotosData")
	public Response getAllPhotosData() {
		//TODO remove line below
		return new Response("", new HashMap<String, Object>());
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response = new Response("200", responseData);
    	response.data.put("photoList", photoRetrieveService.retrieveAllPhotos());
		return response;
	}
	
	//returns a requested photo data
	@PostMapping(value = "/getRequestedPhotoData")
    public Response getRequestedPhotoData(@RequestBody HashMap<String,Object> requestData) {
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response = new Response("200", responseData);
    	return response;
    }
	
	//uploads a photo to the database
	@PostMapping(value = "/uploadPhoto")
    public Response uploadPhoto(@RequestBody HashMap<String,Object> requestData) {
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response = new Response("200", responseData);
    	return response;
    }
	
	//deletes a photo from the database
	@PostMapping(value = "/deletePhoto")
    public Response deletePhoto(@RequestBody HashMap<String,Object> requestData) {
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response = new Response("200", responseData);
    	return response;
    }
	
	//get a photo picture
	@PostMapping(value = "/getPhotoPicture")
    public Response getPhotoPicture(@RequestBody HashMap<String,Object> requestData) {
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response = new Response("200", responseData);
    	return response;
    }
}
