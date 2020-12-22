package be.jimmyd;

import be.jimmyd.entities.BaseDeveloperResponse;
import be.jimmyd.entities.BaseResponse;
import be.jimmyd.entities.Developer;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static be.jimmyd.TheGamesDbClient.BASE_URL;

class DevelopersClient {

    private final static Logger LOGGER = Logger.getLogger(DevelopersClient.class.getName());


    private final String apiKey;

    public DevelopersClient(String apiKey) {
        this.apiKey = apiKey;
    }

    protected List<Developer> getAllDevelopers() {

        return Unirest.get(BASE_URL + "/v1/Developers")
                .queryString("apikey", apiKey)
                .asObject(new GenericType<BaseResponse<BaseDeveloperResponse>>() {
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
                .getDevelopers()
                .values()
                .stream()
                .collect(Collectors.toList());
    }
}
