package com.photoApi.restControllers;

import java.util.HashMap;

public class Response {
	
	public Response(String status, HashMap<String, Object> data) {
		super();
		this.status = status;
		this.data = data;
	}

	public String status;
	
	public HashMap<String, Object> data;

}
