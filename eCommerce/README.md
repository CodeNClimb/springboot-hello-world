# eCommerce Application

The repository contains a spring boot application that has been containerized using docker.

## About the Application
- This application is mimics the world of eCommerce. This means users can create products and wirte reviews for them.
- Authentication
  - This application uses basic authentication.
  - All endpoints outside `/register` must be authenticated. However, ordinary users may not be access `HTTP DELETE` endpoints as these are reserved for admin users only.
  - Ensure your basic authentication details are provided in postman prior to sending any requests.
- Endpints
  - All available endpoints are available in the postman folder from the main directory.
- Observability
  - The health metrics of the application are available on [prometheus](http://localhost:9090) and [grafana](http://localhost:3000)

## Required Software
 - Please review the required software section in the main repository readMe. 

## Setting Up
- Open and run Docker on your machine.
- Download the application [here](https://github.com/IntegrationWorks/springboot-docker-applications) by navigating to `code -> download ZIP`.
- Unzip the folder and open the extracted files in your downloaded IDE(Intellij or VSCode).
- In your IDE terminal, navigate to the eCommerce folder using the command `cd eCommerce`.
- Run `docker-compose up`. This will create and run postgreSQL which is available via [PGAMIN4](http://localhost:5050), the eCommerce springboot application, along with prometheus and grafana for observability. 

## Testing the Endpoints
- Open and run POSTMAN API
- In the main repository directory, navigate to `postman collection -> collection`.
- This folder contains 4 JSON files. Each file must be uploaded to POSTMAN API via `settings -> data -> import Data -> Import Data file`.
- The collection now give you access to all the endpoints available in the application. Requests may now be sent and recieved.

## Health Monitoring

### Prometheus
- Navigate to [Prometheus](http://localhost:9090) in your web browser.
- In the search tab, you may now enter a metric e.g. `process_cpu_seconds_total` of choice and receive a graph of the results.

### Grafana
Grafana acts as an aggregator of all the metrics collected by prometheus. This allows us to create dashboards which gives us an overview of the health of our application at a glance. 
- Navigate to [Grafana](http://localhost:9090) in your web browser.
- The default users and password for this application are both admin. You will be required to chance these upon signing in.

#### Creating a Data Source
In order to link Prometheus to Grafana, we must first create a data source.
- Navigate to `menu -> connections -> data sources -> add new data source -> Prometheus`. 
- Prometheus Server URL = `http://host.docker.internal:9090`
- Save and Test.
- You now have a data source configured. 

#### Creating a Visualisation Dashboard

- Navigate to `menu -> dashboard -> new -> new dashboard`. This allows you to upload a dashboard or create your own using the data source configured above. 
