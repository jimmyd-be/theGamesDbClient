package io.github.jimmydbe;

import io.github.jimmydbe.entities.BaseGenreResponse;
import io.github.jimmydbe.entities.BaseResponse;
import io.github.jimmydbe.entities.Genre;
import io.github.jimmydbe.exceptions.GamesDbException;
import io.github.jimmydbe.exceptions.ParsingException;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.List;
import java.util.stream.Collectors;

class GenresClient extends Client {

    protected GenresClient(String apiKey) {
        super(apiKey);
    }

    protected List<Genre> getAllGenres() throws ParsingException, GamesDbException {

        final HttpResponse<BaseResponse<BaseGenreResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Genres")
                .queryString("apikey", getApiKey())
                .asObject(new GenericType<BaseResponse<BaseGenreResponse>>() {
                });

        checkForErrors(response);

        return response.getBody()
                .getData()
                .getGenres()
                .values()
                .stream()
                .collect(Collectors.toList());
    }
}
