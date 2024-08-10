# Java Morse API

This project was developed to serve as an artifact during studies on Jenkins, CloudFormation, and other topics. 
It is an API developed in Java using Spring Boot, which is used to convert text to Morse code and vice versa.

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
