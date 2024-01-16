# Hello World SpringBoot Application
This application was created to demonstrate the fundamentals of using springboot and docker.

## About the Application
- This application simply returns hello world when a request is sent to `http://localhost:8080/welcome`

## Required Software
- An IDE ( [Visual Studio Code](https://code.visualstudio.com/download) or [intellij IDEA](https://www.jetbrains.com/idea/download/?source=google&medium=cpc&campaign=APAC_en_AU_IDEA_Branded&term=intellij+idea&content=602143185772&gclid=EAIaIQobChMI-f3uuYnegwMVwqRmAh0_ewXKEAAYASABEgImY_D_BwE&section=windows) )
- [Docker](https://www.docker.com/products/docker-desktop/)
- [Postman API](https://www.postman.com/downloads/)
- A Web Browser ( [Google Chrome](https://www.google.com/chrome/) or [FireFox](https://www.mozilla.org/en-US/firefox/new/))
- [Java](https://www.oracle.com/java/technologies/downloads/) 17 at minimum installed on your local machine.

## Setting Up
- Open and run Docker on your machine.
- Download the application [here](https://github.com/IntegrationWorks/springboot-docker-applications) by navigating to `code -> download ZIP`.
- Unzip the folder and open the extracted files in your downloaded IDE(Intellij or VSCode).
- In your IDE terminal, navigate to the eCommerce folder using the command `cd hello-world`.
- Run `docker-compose up`. This will create a simple springboot api.
- Open your web browser and send a request `http://localhost:8080/welcome`.
- "Hello World!" should be displayed in your web browser.
