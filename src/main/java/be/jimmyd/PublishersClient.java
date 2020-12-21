package be.jimmyd;

import be.jimmyd.entities.*;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static be.jimmyd.TheGamesDbClient.BASE_URL;

class PublishersClient {

    private final static Logger LOGGER = Logger.getLogger(PublishersClient.class.getName());

    private final String apiKey;

    public PublishersClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<Publisher> getAllPublishers() {
        return Unirest.get(BASE_URL + "/v1/Publishers")
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
