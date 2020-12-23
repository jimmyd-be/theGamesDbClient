package io.github.jimmydbe;

import io.github.jimmydbe.entities.BasePublisherResponse;
import io.github.jimmydbe.entities.BaseResponse;
import io.github.jimmydbe.entities.Publisher;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

class PublishersClient {

    private final static Logger LOGGER = Logger.getLogger(PublishersClient.class.getName());

    private final String apiKey;

    public PublishersClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<Publisher> getAllPublishers() {
        return Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Publishers")
                .queryString("apikey", apiKey)
                .asObject(new GenericType<BaseResponse<BasePublisherResponse>>() {
                })
                .ifFailure(response -> {
                    LOGGER.log(Level.SEVERE, "Oh No! Status" + response.getStatus());
                    response.getParsingError().ifPresent(e -> {
                        LOGGER.log(Level.SEVERE, "Parsing Exception: ", e);
                        LOGGER.log(Level.SEVERE, "Original body: " + e.getOriginalBody());
                    });
                })
                .getBody()
                .getData()
                .getPublishers()
                .values()
                .stream()
                .collect(Collectors.toList());
    }

}
