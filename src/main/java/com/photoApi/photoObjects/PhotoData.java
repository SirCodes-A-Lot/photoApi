package com.photoApi.photoObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

//check this is the right entity import
@Entity
public class PhotoData {
	
	@Id
	private int id;
	
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date uploadDate;
    
    private String filename;
    
    private String format;
    
    private String country;
    
    private String city;
    
    private double xCoordinate;
    
    private double yCoordinate;

	public PhotoData() {
		super();
	}

	public PhotoData(int id, Date uploadDate, String filename, String format, String country, String city,
			double xCoordinate, double yCoordinate) {
		super();
		this.id = id;
		this.uploadDate = uploadDate;
		this.filename = filename;
		this.format = format;
		this.country = country;
		this.city = city;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public int getId() {
		return id;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
}
