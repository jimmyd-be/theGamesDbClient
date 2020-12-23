package io.github.jimmydbe;

import io.github.jimmydbe.entities.BaseResponse;
import io.github.jimmydbe.exceptions.GamesDbException;
import io.github.jimmydbe.exceptions.ParsingException;
import kong.unirest.HttpResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

class Client<T> {

    private final static Logger LOGGER = Logger.getLogger(Client.class.getName());

    private final String apiKey;

    protected Client(final String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    protected void checkForErrors(HttpResponse<BaseResponse<T>> response) throws ParsingException, GamesDbException {

        if (response.getStatus() != 200) {
            final String message = "Received status code " + response.getStatus() + " from server with message: " + response.getBody().getStatus();
            LOGGER.log(Level.SEVERE, message);
            throw new GamesDbException(message);

        } else if (response.getParsingError().isPresent()) {
            final String message = "Message could not be parsed. Body was: " + response.getParsingError().get().getOriginalBody();
            LOGGER.log(Level.SEVERE, message, response.getParsingError().get());
            throw new ParsingException(message);
        }

    }
}
