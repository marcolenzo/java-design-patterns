package eu.marcolenzo.patterns.behavioral.chain.structure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteHandler2 implements Handler {

    private static final Logger log = LoggerFactory.getLogger(ConcreteHandler2.class);

    private Handler successor;

    public ConcreteHandler2(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(String request) {
        log.info("Invoked");

        // This handler will process only non-null requests which are more or equal to 10 characters
        if(request != null && request.length() >= 10) {
            log.info("Handling request: {}", request);
        }
        else if(successor != null){
            log.info("Forwarding request...");
            successor.handleRequest(request);
        }

    }
    
}
