Connects to a MySQL 5.7 database called photo2. This can be changed in application.properties.

This API expects and produces JSON.

Image data is accepted and returned as a String, so the client may use any form of
stringifying to convert their image data when creating json requests (e.g. base 64). As this application has no front end,
the client is expected to do this conversion.

Filenames and image data must be unique.

All requests must include the header "Api-Key" with the valid API key.

================================================================================

End points with examples:

/getAllPhotosData

gets all metadata fields of all images stored in the database. If there are no stored images, photoList will be an empty list
method - GET
response -
{
    "status": "200",
    "data": {
        "photoList": [
            {
                "id": 3,
                "uploadDate": "2019-06-10T15:43:35.000+0000",
                "filename": "pic.jpeg",
                "format": "jpeg",
                "country": "United Kingdom",
                "city": "LONDON",
                "xCoordinate": 51.5074,
                "yCoordinate": 0.1278
            }
        ]
    }
}


--------------------------------------------------------------------------------

/getRequestedPhotoData

gets all metadata fields of image matching the provided filename
method - POST
request -
{
	"filename" : "pic.jpeg"
}
response -
{
    "status": "200",
    "data": {
        "imageData": "here is some stringified image data"
    }
}

--------------------------------------------------------------------------------

/uploadPhoto
uploads a photo to the database.
method - POST
request -
{
	"xcoord" : "51.5074",
	"ycoord" : "0.1278",
	"filename" : "pic.jpeg",
	"imageData" : "here is some stringified image data",
	"format" : "jpeg"
}
response -
{
    "status": "200",
    "data": {}
}
-OR-
{
    "status": "200",
    "data": {
        "Error": "File names and content must be unique"
    }
}

--------------------------------------------------------------------------------

/deletePhoto
deletes a photo from the database matching the provided filename. the number deleted will be 0 if the photo was not in the
database or 1 if it was (as this api only accepts unique filenames, this number should not be more than 1 in normal use).
method - POST
request - 
{
	"filename" : "pic.jpeg"
}
response - 
{
    "status": "200",
    "data": {
        "numberDeleted": 1
    }
}
-OR-
{
    "status": "200",
    "data": {
        "numberDeleted": 0
    }
}


--------------------------------------------------------------------------------

/getPhotoPicture
gets the image
method - POST
request -
{
	"filename" : "pic.jpeg"
}
response -
{
    "status": "200",
    "data": {
        "imageData": "here is some stringified image data"
    }
}
-OR-
{
    "status": "200",
    "data": {
        "imageData": null
    }
}