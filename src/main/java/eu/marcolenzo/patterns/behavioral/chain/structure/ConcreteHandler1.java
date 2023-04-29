package eu.marcolenzo.patterns.behavioral.chain.structure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteHandler1 implements Handler {

    private static final Logger log = LoggerFactory.getLogger(ConcreteHandler1.class);

    private Handler successor;

    public ConcreteHandler1(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(String request) {
        log.info("Invoked...");
        // The handler can decide to handle the request or forward it
        // This handler will process only non-null requests which are less than 10 characters
        if(request != null && request.length() < 10) {
            log.info("Handling request: {}", request);
        }
        else if(successor != null) {
            log.info("Forwarding request...");
            successor.handleRequest(request);
        }

    }



}
