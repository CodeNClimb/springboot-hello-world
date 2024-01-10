# eCommerce-spring-boot-docker
The repository contains a spring boot application that can be containerized with docker.

# About the Application
  - This application is mimics the world of eCommerce. This means users can create products and wirte reviews for them.
  - Authentication
    - This application uses basic authentication.
    - A User must be created using the Create User endpoint.
    - These details are used to authenticate them moving forward and must be provided through basic authentication in postman.
  
  
# Required Software
- Docker (specific to your operating system). This can be found [here](https://www.docker.com/products/docker-desktop/).
- An IDE ([Visual Studio Code](https://code.visualstudio.com/download) or [Intellij IDEA](https://www.jetbrains.com/idea/promo/?source=google&medium=cpc&campaign=APAC_en_AU_IDEA_Branded&term=intellij%20idea&content=602143185772&gclid=EAIaIQobChMIotDJx6uhgwMVyBd7Bx02cQu1EAAYASAAEgK0v_D_BwE)).
- Java JDK installed on your local machine. This can be found [here](https://www.oracle.com/java/technologies/downloads/).
-  Download and install [Postman](https://www.postman.com/downloads/) and have it open in the background. 

# Setting Up 
- Ensure that you have Docker running on your machine in the background.
- You can use the following link `https://github.com/IntegrationWorks/ecommerce-spring-boot-docker` to directly download the source file or clone it with [GitHub Desktop](https://desktop.github.com/).
- If you choose to download it, please extract the source code and open the project `eCommerce` in your favoured IDE (Intellij or VSCode).
- In the IDE terminal run the command `mvn clean package`.  This will create the JAR file from which your container will be built.
- After the Jar files are created, run the command `docker-compose up`. This will create a PostgresSQL Database along with starting up your springboot application.

# Testing the Application
- With postman open, navigate to `settings -> data -> import Data -> Import Data file`. Note that each JSON file in the collections folder must be uploaded independently. 
- With all the endpoints uploaded, you should now be able to send requests and receive data.

