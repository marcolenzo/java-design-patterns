package eu.marcolenzo.patterns.behavioral.chain.structure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {

        // Defining chain. Execution order is bottom to top (inverse of declaration)
        // Note that strictly speaking this is not the responsibility of the client
        ConcreteHandler2 concreteHandler2 = new ConcreteHandler2(null);
        ConcreteHandler1 concreteHandler1 = new ConcreteHandler1(concreteHandler2);

        log.info("### Small Request Sample ###");
        concreteHandler1.handleRequest("SmallReq");

        log.info("### Large Request Sample ###");
        concreteHandler1.handleRequest("LargeRequestWithMoreThan10Chars");

    }

}
