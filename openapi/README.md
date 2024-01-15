# eCommerce Application using OPENAPI Generator

- The repository contains a spring boot application that has been containerized using docker and built from an open api generator available at `./src/main/resource.api.yaml`.
- The application also generates [Swagger API](http://localhost:8080/swagger-ui/index.html) endpoints for easy testing.

## About the Application
- This application is mimics the world of eCommerce. This means users can create products and wirte reviews for them.
- Authentication
  - This application uses basic authentication.
  - All endpoints outside `/register` must be authenticated. However, ordinary users may not be access `HTTP DELETE` endpoints as these are reserved for admin users only.
  - Ensure your basic authentication details are provided in postman prior to sending any requests.
- Endpints
  - All available endpoints are available in the postman folder from the main directory.

## Required Software
 - Please review the required software section in the main repository readMe. 

## Setting Up
- Open and run Docker on your machine.
- Download the application [here](https://github.com/IntegrationWorks/springboot-docker-applications) by navigating to `code -> download ZIP`.
- Unzip the folder and open the extracted files in your downloaded IDE(Intellij or VSCode).
- In your IDE terminal, navigate to the eCommerce folder using the command `cd openapi`.
- Run `docker-compose up`. This will create and run the eCommerce springboot application.
- All available endpoints are available on [swagger](http://localhost:8080/swagger-ui/index.html)

## Testing the Endpoints
- Open and run POSTMAN API
- In the main repository directory, navigate to `postman collection -> collection`.
- This folder contains 4 JSON files. Each file must be uploaded to POSTMAN API via `settings -> data -> import Data -> Import Data file`.
- The collection now give you access to all the endpoints available in the application. Requests may now be sent and recieved.

