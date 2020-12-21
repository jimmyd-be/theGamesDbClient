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

import static be.jimmyd.TheGamesDbClient.BASE_URL;

public class GamesClient {

    private final static Logger LOGGER = Logger.getLogger(GamesClient.class.getName());

    private final String apiKey;

    public GamesClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public BaseImageResponse getGameImages(int id) {
        return Unirest.get(BASE_URL + "/v1/Games/Images")
                .queryString("apikey", apiKey)
                .queryString("games_id", id)
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

    public List<Game> getGameById(int id) {
        return Unirest.get(BASE_URL + "/v1/Games/ByGameID")
                .queryString("apikey", apiKey)
                .queryString("id", id)
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

    public List<Game> getGameByPlatform(int platformId) {
        return Unirest.get(BASE_URL + "/v1/Games/ByPlatformID")
                .queryString("apikey", apiKey)
                .queryString("id", platformId)
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
