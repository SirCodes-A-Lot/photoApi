Connects to a MySQL 5.7 database called photo2

end point with examples:

getAllPhotosData
gets all metadata fields of all images stored in the database.
method : GET
response :
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

getRequestedPhotoData
gets all metadata fields of image matching the provided filename
method : POST
request:
response :

uploadPhoto

deletePhoto

getPhotoPicture