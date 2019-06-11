package com.photoApi.Constants;

public class ApiConstants {
	
	public static final String PHOTO_URL = "/photo";
	public static final String GET_ALL_PHOTOS_URL = "/getAllPhotosData";
	public static final String GET_REQUESTED_PHOTO_METADATA_URL = "/getRequestedPhotoData";
	public static final String GET_REQUESTED_PHOTO_IMAGE_DATA_URL = "/getPhotoPicture";
	
	public static final String GEOCODE_URL_START = "https://geocode.xyz/";
	public static final String GEOCODE_URL_END = "?json=1&auth=320198293500272387838x2579";
	
	public static final String API_KEY = "Api-Key";
	//stored here for dev purposes only
	public static final Long API_KEY_VALUE = 5634563846456L;
	
	public static final String FILENAME = "filename";
	public static final String FORMAT = "format";
	public static final String IMAGE_DATA = "imageData";
	public static final String X_COORDINATE = "xCoordinate";
	public static final String Y_COORDINATE = "yCoordinate";
	public static final String COUNTRY = "country";
	public static final String CITY = "city";
	
	public static final String PHOTO_LIST = "photoList";
	public static final String PHOTO_METADATA = "photoMetadata";
	public static final String NUMBER_DELETED = "numberDeleted";
	
	public static final String STATUS_REPORT = "statusReport";
	public static final String SUCCESS = "success";
	public static final String ERROR_FILENAME_TAKEN = "ERROR: file name taken";
	public static final String ERROR_ALREADY_UPLOADED_FILENAME_IS = "ERROR: this image has already been uploaded. Filename is: ";
	
}
