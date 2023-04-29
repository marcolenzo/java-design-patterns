package eu.marcolenzo.patterns.behavioral.chain.abstracthandlerexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractHandler {
    
    public final AbstractHandler nextProcessor;

    private static final Logger log = LoggerFactory.getLogger(AbstractHandler.class);

    public AbstractHandler(AbstractHandler nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public HttpRequest handleRequest(HttpRequest request) {
        log.info("Handling {} in {}", request.toString(), this.getClass().getSimpleName());
        request = this.handleRequestInternal(request);

        if(nextProcessor != null) {
            request = nextProcessor.handleRequest(request);
        }

        return request;
    }

    /**
     * Processing logic should be implemented in this method.
     */
    abstract protected HttpRequest handleRequestInternal(HttpRequest request);

}
