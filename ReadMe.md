# Data Storage
Microservice for storing files in base64 format. 
Uses Spring boot and PostgreSQL
## Build and Run
Docker:
```./gradlew bootJar```\
```docker-compose up -d --build```\
Run in your environment:\
```./gradlew bootRun```
## Examples

### Save
```http://localhost:8080/api/v1/dataStorage/save_file```  

```
{
    "title": "testFile.txt",
    "creation": "2024-01-01T11:04:44",
    "description": "description",
    "fileBase64": "SGVsbG8="
}
```
if you don't write, the 'creation' will be filled with the current date and time
### Get file by ID
```http://localhost:8080/api/v1/dataStorage/YOUR_ID```
### Get file
```http://localhost:8080/api/v1/dataStorage/files?page=0&size=5```  
Returns a page with a list of files sorted by their 'creation'\
The "page" and "size" parameters are optional, without them the page with all files is returned
## Tests
The project is covered by unit tests\
```./gradlew test```
