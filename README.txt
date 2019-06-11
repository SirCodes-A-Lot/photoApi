Connects to a MySQL 5.7 database called photo2

This API expects and produces JSON. Image data is accepted and returned as a String, so the client may use any form of
stringifying to convert their image data when creating json requests (e.g. base 64). As this application has no front end,
the client is expected to do this conversion.

Filenames and image data must be unique.

================================================================================

End points with examples:

/getAllPhotosData

gets all metadata fields of all images stored in the database.
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
response -

--------------------------------------------------------------------------------

/uploadPhoto
method - POST
request -
response -


--------------------------------------------------------------------------------

/deletePhoto
method - POST
request -
response -


--------------------------------------------------------------------------------

/getPhotoPicture
method - POST
request -
response -