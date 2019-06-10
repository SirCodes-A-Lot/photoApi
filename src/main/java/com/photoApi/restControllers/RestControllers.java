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
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response = new Response("200", responseData);
    	response.data.put("photoList", photoRetrieveService.retrieveAllPhotos());
		return response;
	}
	
	//TODO
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
    	Response response; 
    	if (requestData.containsKey("xcoord") && requestData.containsKey("ycoord") &&
    			requestData.containsKey("filename") && requestData.containsKey("imageData")) {
        	response = new Response("200", responseData);
        	photoSaveService.savePhotoToDataBase(
        			(String) requestData.get("filename"), (String) requestData.get("imageData"),
        			(String) requestData.get("format"),
        			Double.valueOf((String) requestData.get("xcoord")),
        			Double.valueOf((String) requestData.get("ycoord")));
    	} else {
    		response = new Response("400", responseData);
    	}

    	return response;
    }
	
	//TODO
	//deletes a photo from the database
	@PostMapping(value = "/deletePhoto")
    public Response deletePhoto(@RequestBody HashMap<String,Object> requestData) {
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response = new Response("200", responseData);
    	return response;
    }
	
	//TODO
	//get a photo picture
	@PostMapping(value = "/getPhotoPicture")
    public Response getPhotoPicture(@RequestBody HashMap<String,Object> requestData) {
		Response response; 
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
		if (requestData.containsKey("filename")) {
			response = new Response("200", responseData);
		} else {
			response = new Response("400", responseData);
		}
    	return response;
    }
}
