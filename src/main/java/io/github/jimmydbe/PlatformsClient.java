package io.github.jimmydbe;

import io.github.jimmydbe.entities.*;
import io.github.jimmydbe.exceptions.GamesDbException;
import io.github.jimmydbe.exceptions.ParsingException;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.List;
import java.util.stream.Collectors;

class PlatformsClient extends Client {

    private final String fields = "icon,console,controller,developer,manufacturer,media,cpu,memory,graphics,sound,maxcontrollers,display,overview,youtube";

    protected PlatformsClient(String apiKey) {
        super(apiKey);
    }

    protected List<Platform> getAllPlatforms() throws ParsingException, GamesDbException {
        final HttpResponse<BaseResponse<BasePlatformResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Platforms")
                .queryString("apikey", getApiKey())
                .queryString("fields", fields)
                .asObject(new GenericType<BaseResponse<BasePlatformResponse>>() {
                });

        checkForErrors(response);

        return response.getBody()
                .getData()
                .getPlatforms()
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    protected List<Platform> getPlatformById(List<Integer> id) throws ParsingException, GamesDbException {

        String ids = id.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        final HttpResponse<BaseResponse<BasePlatformResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Platforms/ByPlatformID")
                .queryString("apikey", getApiKey())
                .queryString("id", ids)
                .queryString("fields", fields)
                .asObject(new GenericType<BaseResponse<BasePlatformResponse>>() {
                });

        checkForErrors(response);

        return response.getBody()
                .getData()
                .getPlatforms()
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    protected List<Platform> getPlatformByName(String name) throws ParsingException, GamesDbException {
        final HttpResponse<BaseResponse<ListPlatformResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Platforms/ByPlatformName")
                .queryString("apikey", getApiKey())
                .queryString("name", name)
                .queryString("fields", fields)
                .asObject(new GenericType<BaseResponse<ListPlatformResponse>>() {
                });

        checkForErrors(response);
        return response.getBody()
                .getData()
                .getPlatforms();
    }

    protected BaseImageResponse getPlatformImageById(List<Integer> id) throws ParsingException, GamesDbException {

        String ids = id.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        final HttpResponse<BaseResponse<BaseImageResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Platforms/Images")
                .queryString("apikey", getApiKey())
                .queryString("platforms_id", ids)
                .asObject(new GenericType<BaseResponse<BaseImageResponse>>() {
                });
        checkForErrors(response);
        return response.getBody()
                .getData();
    }
}
