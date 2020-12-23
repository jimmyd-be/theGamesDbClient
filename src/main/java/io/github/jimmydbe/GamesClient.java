package io.github.jimmydbe;

import io.github.jimmydbe.entities.BaseGameResponse;
import io.github.jimmydbe.entities.BaseImageResponse;
import io.github.jimmydbe.entities.BaseResponse;
import io.github.jimmydbe.entities.Game;
import io.github.jimmydbe.exceptions.GamesDbException;
import io.github.jimmydbe.exceptions.ParsingException;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.List;
import java.util.stream.Collectors;

class GamesClient extends Client {

    private final String fields = "players,publishers,genres,overview,last_updated,rating,platform,coop,youtube,os,processor,ram,hdd,video,sound";

    protected GamesClient(String apiKey) {
        super(apiKey);
    }

    protected BaseImageResponse getGameImages(List<Integer> id) throws ParsingException, GamesDbException {

        String ids = id.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        final HttpResponse<BaseResponse<BaseImageResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Games/Images")
                .queryString("apikey", getApiKey())
                .queryString("games_id", ids)
                .asObject(new GenericType<BaseResponse<BaseImageResponse>>() {
                });

        checkForErrors(response);

        return response.getBody()
                .getData();
    }

    protected List<Game> getGameById(List<Integer> id) throws ParsingException, GamesDbException {

        String ids = id.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        final HttpResponse<BaseResponse<BaseGameResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Games/ByGameID")
                .queryString("apikey", getApiKey())
                .queryString("id", ids)
                .queryString("fields", fields)
                .asObject(new GenericType<BaseResponse<BaseGameResponse>>() {
                });

        checkForErrors(response);

        return response.getBody()
                .getData()
                .getGames();
    }

    protected List<Game> getGameByName(String name) throws ParsingException, GamesDbException {
        final HttpResponse<BaseResponse<BaseGameResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1.1/Games/ByGameName")
                .queryString("apikey", getApiKey())
                .queryString("name", name)
                .queryString("fields", fields)
                .asObject(new GenericType<BaseResponse<BaseGameResponse>>() {
                });
        checkForErrors(response);
        return response.getBody()
                .getData()
                .getGames();
    }

    protected List<Game> getGameByPlatform(List<Integer> platformId) throws ParsingException, GamesDbException {

        String ids = platformId.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        final HttpResponse<BaseResponse<BaseGameResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Games/ByPlatformID")
                .queryString("apikey", getApiKey())
                .queryString("id", ids)
                .queryString("fields", fields)
                .asObject(new GenericType<BaseResponse<BaseGameResponse>>() {
                });

        checkForErrors(response);

        return response.getBody()
                .getData()
                .getGames();
    }

    protected List<Game> getUpdateGame(int lastEditId) throws ParsingException, GamesDbException {
        final HttpResponse<BaseResponse<BaseGameResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Games/Updates")
                .queryString("apikey", getApiKey())
                .queryString("last_edit_id", lastEditId)
                .asObject(new GenericType<BaseResponse<BaseGameResponse>>() {
                });
        checkForErrors(response);

        return response.getBody()
                .getData()
                .getGames();
    }
}
