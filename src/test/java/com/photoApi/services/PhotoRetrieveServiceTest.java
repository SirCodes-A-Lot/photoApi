package com.photoApi.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.photoApi.photoObjects.PhotoData;
import com.photoApi.photoObjects.PhotoMetadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class PhotoRetrieveServiceTest {
	
	@Mock
	private PhotoDatabaseService mockPhotoDatabaseService;
	
	private static String PHOTO_NOT_IN_DATABASE = "not in db";
	
	private static String PHOTO_FILENAME = "filename";
	
	private static String PHOTO_IMAGE_DATA = "imageData";
	
	private static String PHOTO_FORMAT = "format";
	
	private static String PHOTO_COUNTRY = "country";
	
	private static String PHOTO_CITY = "city";
	
	private static double PHOTO_X_COORD = 14.123;
	
	private static double PHOTO_Y_COORD = 19.321;
	
	private static PhotoData PHOTO = new PhotoData(
			PHOTO_FILENAME, PHOTO_IMAGE_DATA, PHOTO_FORMAT,
			PHOTO_COUNTRY, PHOTO_CITY,PHOTO_X_COORD, PHOTO_Y_COORD);
	
	private static ArrayList<PhotoData> PHOTOS_IN_DATABASE =
			new ArrayList<>(Arrays.asList(PHOTO));
	
	private static PhotoMetadata EXPECTED_PHOTO_METADATA = new PhotoMetadata(
			PHOTO.getUploadDate(), PHOTO_FILENAME, PHOTO_FORMAT, PHOTO_COUNTRY, PHOTO_CITY,
			PHOTO_X_COORD, PHOTO_Y_COORD);
	
	private PhotoRetrieveService photoRetrieveService;
	
	@Before
	public void setup () {
		photoRetrieveService = new PhotoRetrieveService(mockPhotoDatabaseService);
	}
	
	@Test
	public void givenPhotosInDatabaseWhenRetrievingAllThenListOfPhotoMetadataReturned() {
		given(mockPhotoDatabaseService.retrieveAllPhotos()).willReturn(PHOTOS_IN_DATABASE);
		ArrayList<PhotoMetadata> photoMetadataList = photoRetrieveService.retrieveAllPhotosMetadata();
		assertEquals(1,photoMetadataList.size());
		assertPhotoMetadataIsEqual(EXPECTED_PHOTO_METADATA, photoMetadataList.get(0));
	}
	
	@Test
	public void givenNoPhotosInDatabaseWhenRetrievingAllThenEmptyListReturned() {
		given(mockPhotoDatabaseService.retrieveAllPhotos()).willReturn(new ArrayList<PhotoData>());
		ArrayList<PhotoMetadata> photoMetadataList = photoRetrieveService.retrieveAllPhotosMetadata();
		assertTrue(photoMetadataList.isEmpty());
	}
	
	@Test
	public void givenPhotoInDatabaseWhenRequestingImageByFileNameThenImageDataReturned() {
		given(mockPhotoDatabaseService.findPhotoDataByFilename(PHOTO_FILENAME)).willReturn(PHOTO);
		String imageData = photoRetrieveService.getImageForPhoto(PHOTO_FILENAME);
		assertEquals(PHOTO_IMAGE_DATA, imageData);
	}
	
	@Test
	public void givenPhotoNotInDataBaseWhenRequestingImageByFileNameThenReturnNull() {
		given(mockPhotoDatabaseService.findPhotoDataByFilename(PHOTO_NOT_IN_DATABASE)).willReturn(null);
		String imageData = photoRetrieveService.getImageForPhoto(PHOTO_NOT_IN_DATABASE);
		assertNull(imageData);
	}
	
	@Test
	public void givenNoFileNameProvidedWhenRequestingImageByFileNameThenReturnNull() {
		given(mockPhotoDatabaseService.findPhotoDataByFilename(null)).willReturn(null);
		String imageData = photoRetrieveService.getImageForPhoto(null);
		assertNull(imageData);
	}
	
	@Test
	public void givenPhotoInDatabaseWhenRequestingImageMetadataByFileNameThenImageMetadataReturned() {
		given(mockPhotoDatabaseService.findPhotoDataByFilename(PHOTO_FILENAME)).willReturn(PHOTO);
		PhotoMetadata photoMetadata = photoRetrieveService.getPhotoMetadataByFilename(PHOTO_FILENAME);
		assertPhotoMetadataIsEqual(EXPECTED_PHOTO_METADATA, photoMetadata);
	}
	
	@Test
	public void givenPhotoNotInDataBaseWhenRequestingImageMetadataByFileNameThenReturnNull() {
		given(mockPhotoDatabaseService.findPhotoDataByFilename(PHOTO_NOT_IN_DATABASE)).willReturn(null);
		PhotoMetadata photoMetadata = photoRetrieveService.getPhotoMetadataByFilename(PHOTO_NOT_IN_DATABASE);
		assertNull(photoMetadata);
	}
	
	@Test
	public void givenNoFileNameProvidedWhenRequestingImageMetadataByFileNameThenReturnNull() {
		given(mockPhotoDatabaseService.findPhotoDataByFilename(null)).willReturn(null);
		PhotoMetadata photoMetadata = photoRetrieveService.getPhotoMetadataByFilename(null);
		assertNull(photoMetadata);
	}
	
	private void assertPhotoMetadataIsEqual(PhotoMetadata expected, PhotoMetadata actual) {
		assertEquals(expected.getUploadDate(), actual.getUploadDate());
		assertEquals(expected.getFilename(), actual.getFilename());
		assertEquals(expected.getFormat(), actual.getFormat());
		assertEquals(expected.getCity(), actual.getCity());
		assertEquals(expected.getCountry(), actual.getCountry());
		assertEquals(expected.getyCoordinate(), actual.getyCoordinate(), 0.0000001);
		assertEquals(expected.getxCoordinate(), actual.getxCoordinate(), 0.0000001);
	}
}
