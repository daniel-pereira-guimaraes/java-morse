# Java Morse API

This project was developed during studies on **Jenkins** and **Docker**. It is an API developed in Java using Spring Boot, which is used to convert text to Morse code and vice versa.

The main objective of this project is to demonstrate the creation of a **Jenkins pipeline** that executes the following stages:

+ **Prepare:** prepares the environment for pipeline execution.
+ **Build Application:** executes build and tests of the java-morse application.
+ **Build Docker Image:** builds a Docker image with the java-morse application.
+ **Build Docker Push:** uploads the image to **Docker Hub**.
+ **Declarative: Post Actions:** Deletes temporary files and docker image.

## Technologies
- Java
- Spring Boot
- JUnit5
- Maven
- Docker
- Jenkins
  
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

## Jenkins configurations

This project contains a Jenkinsfile, which can be used to create a pipeline in Jenkins as per the following topics.

### Configuring DockerHub credentials

+ Go to **Dashboard** > **Manage Jenkins** > **Security** > **Credentials**.
+ Click on **(global)** in the Domain column.
+ Click on the **Add Credentials** button.
+ Enter your DockerHub credentials in the **Username** and **Password** fields.
+ Enter `"docker-credentials"` in the **ID** field.
+ Enter `"DockerHub credentials"` in the **Description** field.
+ Click the **Create** button.

### Configuring GitHub credentials

+ Go to **Dashboard** > **Manage Jenkins** > **Security** > **Credentials**.
+ Click on **(global)** in the **Domain** column.
+ Click on the **Add Credentials** button.
+ Enter your GitHub credentials in the **Username** and **Password** fields.
+ Enter `"github-credentials"` in the **ID** field.
+ Enter `"GitHub credentials"` in the **Description** field.
+ Click the **Create** button.

## Creating a Pipeline

+ Go to **Dashboard** > **New Item**.
+ Enter an item name (e.g., **java-morse**).
+ Click the **OK** button.
+ Scroll to **Pipeline**.
+ Select **Pipeline script from SCM** in the **Definition** field.
+ Select **Git** in the **SCM** field.
+ Enter the GitHub repository URL in the **Repository URL** field (`https://github.com/daniel-pereira-guimaraes/java-morse`).
  
## License

- This project is licensed under the [MIT License](https://opensource.org/licenses/MIT). You are free to use, modify, and distribute the code as long as you include the original copyright notice and license in your documentation or credits.
