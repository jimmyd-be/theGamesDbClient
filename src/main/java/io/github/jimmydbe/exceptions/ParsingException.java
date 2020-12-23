package io.github.jimmydbe.exceptions;

/**
 * Exception that will tell the client that there was a parsing error
 */
public class ParsingException extends Exception {

    public ParsingException(final String message) {
        super(message);
    }
}
