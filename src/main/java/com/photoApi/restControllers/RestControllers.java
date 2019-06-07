package com.photoApi.restControllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.photoApi.photoObjects.Response;

public class RestControllers {
	
	//returns a list of all photos data
	@GetMapping(value = "/getAllPhotosData")
	public Response getAllPhotosData() {
    	HashMap<String,Object> responseData = new HashMap<String,Object> ();
    	Response response = new Response("200", responseData);
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
