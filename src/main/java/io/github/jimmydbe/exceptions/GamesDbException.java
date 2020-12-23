package io.github.jimmydbe.exceptions;

/**
 * General exception thrown when connection to The Game Db has failed
 */
public class GamesDbException extends Exception {

    public GamesDbException(final String message) {
        super(message);
    }
}
