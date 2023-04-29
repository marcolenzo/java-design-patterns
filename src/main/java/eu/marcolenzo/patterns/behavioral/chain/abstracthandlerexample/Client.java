package eu.marcolenzo.patterns.behavioral.chain.abstracthandlerexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    
    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {

        // Creating chain (this will be executed bottom to top)
        UpperCaseBodyTransformer upperCaseBodyTransformer = new UpperCaseBodyTransformer(null);
        HttpRequestValidator httpRequestValidator = new HttpRequestValidator(upperCaseBodyTransformer);

        // Sample request
        HttpRequest request = new HttpRequest("1", "POST", "/echo", "Hello World!");

        // Process request
        request = httpRequestValidator.handleRequest(request);

        // Print result
        log.info("Processed request is {}", request);

    }

}
