package be.jimmyd;

import be.jimmyd.entities.*;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static be.jimmyd.TheGamesDbClient.BASE_URL;

class PlatformsClient {

    private final static Logger LOGGER = Logger.getLogger(PlatformsClient.class.getName());

    private final String apiKey;

    public PlatformsClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<Platform> getAllPlatforms() {
        return Unirest.get(BASE_URL + "/v1/Platforms")
                .queryString("apikey", apiKey)
                .asObject(new GenericType<BaseResponse<BasePlatformResponse>>() {
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
                .getPlatforms()
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public List<Platform> getPlatformById(int id) {
        return Unirest.get(BASE_URL + "/v1/Platforms/ByPlatformID")
                .queryString("apikey", apiKey)
                .queryString("id", id)
                .asObject(new GenericType<BaseResponse<BasePlatformResponse>>() {
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
                .getPlatforms()
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public List<Platform> getPlatformByName(String name) {
        return Unirest.get(BASE_URL + "/v1/Platforms/ByPlatformName")
                .queryString("apikey", apiKey)
                .queryString("name", name)
                .asObject(new GenericType<BaseResponse<ListPlatformResponse>>() {
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
                .getPlatforms();
    }

    public BaseImageResponse getPlatformImageById(int id) {
        return Unirest.get(BASE_URL + "/v1/Platforms/Images")
                .queryString("apikey", apiKey)
                .queryString("platforms_id", id)
                .asObject(new GenericType<BaseResponse<BaseImageResponse>>() {
                })
                .ifFailure(response -> {
                    LOGGER.log(Level.SEVERE, "Oh No! Status" + response.getStatus());
                    response.getParsingError().ifPresent(e -> {
                        LOGGER.log(Level.SEVERE, "Parsing Exception: ", e);
                        LOGGER.log(Level.SEVERE, "Original body: " + e.getOriginalBody());
                    });
                })
                .getBody()
                .getData();
    }
}
