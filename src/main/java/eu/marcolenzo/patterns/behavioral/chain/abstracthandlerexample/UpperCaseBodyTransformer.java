package eu.marcolenzo.patterns.behavioral.chain.abstracthandlerexample;

public class UpperCaseBodyTransformer extends AbstractHandler {

    public UpperCaseBodyTransformer(AbstractHandler nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public HttpRequest handleRequestInternal(HttpRequest request) {
        return new HttpRequest(request.id(), request.method(), request.path(), request.body().toUpperCase());
    }

}
