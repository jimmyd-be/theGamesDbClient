package be.jimmyd;

import be.jimmyd.entities.BaseGameResponse;
import be.jimmyd.entities.BaseImageResponse;
import be.jimmyd.entities.BaseResponse;
import be.jimmyd.entities.Game;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static be.jimmyd.TheGamesDbClient.BASE_URL;

public class GamesClient {

    private final static Logger LOGGER = Logger.getLogger(GamesClient.class.getName());

    private final String includes = "boxart,platform";
    private final String fields = "players,publishers,genres,overview,last_updated,rating,platform,coop,youtube,os,processor,ram,hdd,video,sound";

    private final String apiKey;

    public GamesClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public BaseImageResponse getGameImages(List<Integer> id) {

        String ids = id.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        return Unirest.get(BASE_URL + "/v1/Games/Images")
                .queryString("apikey", apiKey)
                .queryString("games_id", ids)
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

    public List<Game> getGameById(List<Integer> id) {

        String ids = id.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        return Unirest.get(BASE_URL + "/v1/Games/ByGameID")
                .queryString("apikey", apiKey)
                .queryString("id", ids)
                .queryString("fields", fields)
                .asObject(new GenericType<BaseResponse<BaseGameResponse>>() {
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
                .getGames();
    }

    public List<Game> getGameByName(String name) {
        return Unirest.get(BASE_URL + "/v1.1/Games/ByGameName")
                .queryString("apikey", apiKey)
                .queryString("name", name)
                .queryString("fields", fields)
                .asObject(new GenericType<BaseResponse<BaseGameResponse>>() {
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
                .getGames();
    }

    public List<Game> getGameByPlatform(List<Integer> platformId) {

        String ids = platformId.stream().map(n -> n.toString()).collect(Collectors.joining(","));

        return Unirest.get(BASE_URL + "/v1/Games/ByPlatformID")
                .queryString("apikey", apiKey)
                .queryString("id", ids)
                .queryString("fields", fields)
                .asObject(new GenericType<BaseResponse<BaseGameResponse>>() {
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
                .getGames();
    }

    public List<Game> getUpdateGame(int lastEditId) {
        return Unirest.get(BASE_URL + "/v1/Games/Updates")
                .queryString("apikey", apiKey)
                .queryString("last_edit_id", lastEditId)
                .asObject(new GenericType<BaseResponse<BaseGameResponse>>() {
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
                .getGames();
    }
}
