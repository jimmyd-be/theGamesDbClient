package io.github.jimmydbe;

import io.github.jimmydbe.entities.*;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

class PlatformsClient {

    private final static Logger LOGGER = Logger.getLogger(PlatformsClient.class.getName());

    private final String apiKey;

    private final String fields = "icon,console,controller,developer,manufacturer,media,cpu,memory,graphics,sound,maxcontrollers,display,overview,youtube";

    public PlatformsClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<Platform> getAllPlatforms() {
        return Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Platforms")
                .queryString("apikey", apiKey)
                .queryString("fields", fields)
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

    public List<Platform> getPlatformById(List<Integer> id) {

        String ids = id.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        return Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Platforms/ByPlatformID")
                .queryString("apikey", apiKey)
                .queryString("id", ids)
                .queryString("fields", fields)
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
        return Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Platforms/ByPlatformName")
                .queryString("apikey", apiKey)
                .queryString("name", name)
                .queryString("fields", fields)
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

    public BaseImageResponse getPlatformImageById(List<Integer> id) {

        String ids = id.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        return Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Platforms/Images")
                .queryString("apikey", apiKey)
                .queryString("platforms_id", ids)
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
