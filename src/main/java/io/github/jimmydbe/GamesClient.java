package io.github.jimmydbe;

import io.github.jimmydbe.entities.*;
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

    private List<GameDto> convertGameToDto(AdvancedResponse<BaseGameResponse> data) {
        return data.getData().getGames().stream().map(game -> convert(game,data.getInclude())).collect(Collectors.toList());
    }

    private GameDto convert(Game game, IncludeResponse include) {

        GameDto dto = new GameDto(game);

        dto.setPlatformObject(include.getPlatform().getData().get(String.valueOf(game.getPlatform())));
        dto.setImages(include.getBoxart().getData().get(String.valueOf(game.getId())));
        dto.setImageBaseurl(include.getBoxart().getBase_url());

        return dto;
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

    protected List<GameDto> getGameById(List<Integer> id) throws ParsingException, GamesDbException {

        String ids = id.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        final HttpResponse<AdvancedResponse<BaseGameResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Games/ByGameID")
                .queryString("apikey", getApiKey())
                .queryString("id", ids)
                .queryString("fields", fields)
                .queryString("include", "boxart,platform")
                .asObject(new GenericType<AdvancedResponse<BaseGameResponse>>() {
                });

        checkForErrors(response);

        return convertGameToDto(response.getBody());
    }

    protected List<GameDto> getGameByName(String name) throws ParsingException, GamesDbException {
        final HttpResponse<AdvancedResponse<BaseGameResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1.1/Games/ByGameName")
                .queryString("apikey", getApiKey())
                .queryString("name", name)
                .queryString("fields", fields)
                .queryString("include", "boxart,platform")
                .asObject(new GenericType<AdvancedResponse<BaseGameResponse>>() {
                });
        checkForErrors(response);
        return convertGameToDto(response.getBody());
    }

    protected List<GameDto> getGameByPlatform(List<Integer> platformId) throws ParsingException, GamesDbException {

        String ids = platformId.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        final HttpResponse<AdvancedResponse<BaseGameResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Games/ByPlatformID")
                .queryString("apikey", getApiKey())
                .queryString("id", ids)
                .queryString("fields", fields)
                .queryString("include", "boxart,platform")
                .asObject(new GenericType<AdvancedResponse<BaseGameResponse>>() {
                });

        checkForErrors(response);

        return convertGameToDto(response.getBody());
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
