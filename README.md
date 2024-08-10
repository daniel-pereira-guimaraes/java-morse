# Java Morse API

This project was developed during studies on **Jenkins** and **Docker**. It is an API developed in Java using Spring Boot, which is used to convert text to Morse code and vice versa.

The main objective of this project is to demonstrate the creation of a **Jenkins pipeline** that executes the following stages:

+ **Prepare:** prepares the environment for pipeline execution.
+ **Build Application:** executes build and tests of the java-morse application.
+ **Build Docker Image:** builds a Docker image with the java-morse application.
+ **Build Docker Push:** uploads the image to **Docker Hub**.
+ **Cleanup:** Deletes temporary files and docker image.
  
## API Endpoints

### Convert Text to Morse

- **Method**: POST
- **Endpoint**: `localhost:8080/to-morse`
- **Request Body**: Normal text to be converted to Morse code.
  - **Example**:
    ```text
    I LOVE JAVA
    ```
- **Expected Response**: Corresponding Morse code for the provided text.
  - **Example**:
    ```text
    .. / .-.. --- ...- . / .--- .- ...- .-
    ```

### Convert Morse to Text

- **Method**: POST
- **Endpoint**: `localhost:8080/to-text`
- **Request Body**: Morse code to be converted to normal text.
  - **Example**:
    ```text
    .. / .-.. --- ...- . / .--- .- ...- .-
    ```
- **Expected Response**: Text corresponding to the provided Morse code.
  - **Example**:
    ```text
    I LOVE JAVA
    ```

## Jenkins Configuration Guide

This project contains a Jenkinsfile, which can be used to create a pipeline in Jenkins as per the following topics.

### Configuring DockerHub Credentials

1. Go to **Dashboard** > **Manage Jenkins** > **Security** > **Credentials**.
2. Click on `(global)` in the Domain column.
3. Click on the **[Add Credentials]** button.
4. Enter your DockerHub credentials in the **[Username]** and **[Password]** fields.
5. Enter `"docker-credentials"` in the **[ID]** field.
6. Enter `"DockerHub credentials"` in the **[Description]** field.
7. Click the **[Create]** button.

### Configuring GitHub Credentials

1. Go to **Dashboard** > **Manage Jenkins** > **Security** > **Credentials**.
2. Click on `(global)` in the Domain column.
3. Click on the **[Add Credentials]** button.
4. Enter your GitHub credentials in the **[Username]** and **[Password]** fields.
5. Enter `"github-credentials"` in the **[ID]** field.
6. Enter `"GitHub credentials"` in the **[Description]** field.
7. Click the **[Create]** button.

## Creating a Pipeline

1. Go to **Dashboard** > **New Item**.
2. Enter an item name (e.g., `java-morse`).
3. Click the **OK** button.
4. Scroll to **[Pipeline]**.
5. Select **[Pipeline script from SCM]** in the **[Definition]** field.
6. Select **[Git]** in the **[SCM]** field.
7. Enter the GitHub repository URL in the **[Repository URL]** field (e.g., `https://github.com/daniel-pereira-guimaraes/j
