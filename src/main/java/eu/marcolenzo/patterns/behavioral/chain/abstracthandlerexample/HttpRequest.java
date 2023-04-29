package eu.marcolenzo.patterns.behavioral.chain.abstracthandlerexample;

public record HttpRequest(String id, String method, String path, String body) {
}
