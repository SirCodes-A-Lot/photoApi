package com.photoApi.photoObjects;

import java.util.Date;

public class PhotoMetadata {
	
    private Date uploadDate;
    
    private String filename;

	private String format;
    
    private String country;
    
    private String city;
    
    private double xCoordinate;
    
    private double yCoordinate;
    
    
    
    public PhotoMetadata(Date uploadDate, String filename, String format, String country, String city,
			double xCoordinate, double yCoordinate) {
		this.uploadDate = uploadDate;
		this.filename = filename;
		this.format = format;
		this.country = country;
		this.city = city;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

    public PhotoMetadata(PhotoData photoData) {
		this.uploadDate = photoData.getUploadDate();
		this.filename = photoData.getFilename();
		this.format = photoData.getFormat();
		this.country = photoData.getCountry();
		this.city = photoData.getCity();
		this.xCoordinate = photoData.getxCoordinate();
		this.yCoordinate = photoData.getyCoordinate();
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public String getFilename() {
		return filename;
	}

	public String getFormat() {
		return format;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public double getxCoordinate() {
		return xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

}
