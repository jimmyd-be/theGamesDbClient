package be.jimmyd;

import be.jimmyd.entities.BaseGenreResponse;
import be.jimmyd.entities.BaseResponse;
import be.jimmyd.entities.Genre;
import be.jimmyd.exceptions.ParsingException;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static be.jimmyd.TheGamesDbClient.BASE_URL;

class GenresClient {

    private final static Logger LOGGER = Logger.getLogger(GenresClient.class.getName());

    private final String apiKey;

    public GenresClient(String apiKey) {
        this.apiKey = apiKey;
    }

    protected List<Genre> getAllGenres() {

        return Unirest.get(BASE_URL + "/v1/Genres")
                .queryString("apikey", apiKey)
                .asObject(new GenericType<BaseResponse<BaseGenreResponse>>() {
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
                .getGenres()
                .values()
                .stream()
                .collect(Collectors.toList());
    }
}
