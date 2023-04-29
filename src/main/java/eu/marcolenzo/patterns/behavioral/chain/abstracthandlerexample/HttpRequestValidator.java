package eu.marcolenzo.patterns.behavioral.chain.abstracthandlerexample;

import org.apache.commons.lang3.StringUtils;

public class HttpRequestValidator extends AbstractHandler {

    public HttpRequestValidator(AbstractHandler nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public HttpRequest handleRequestInternal(HttpRequest request) {
        if(StringUtils.isBlank(request.id()) || StringUtils.isBlank(request.path())
                || StringUtils.isBlank(request.method())) {
            throw new IllegalArgumentException("Request id, path and method cannot be null, empty or blank");
        }
        return request;
    }

}
