package io.github.jimmydbe;

import io.github.jimmydbe.entities.BaseDeveloperResponse;
import io.github.jimmydbe.entities.BaseResponse;
import io.github.jimmydbe.entities.Developer;
import io.github.jimmydbe.exceptions.GamesDbException;
import io.github.jimmydbe.exceptions.ParsingException;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.List;
import java.util.stream.Collectors;

class DevelopersClient extends Client {

    protected DevelopersClient(String apiKey) {
        super(apiKey);
    }

    protected List<Developer> getAllDevelopers() throws ParsingException, GamesDbException {

        final HttpResponse<BaseResponse<BaseDeveloperResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Developers")
                .queryString("apikey", getApiKey())
                .asObject(new GenericType<BaseResponse<BaseDeveloperResponse>>() {
                });

        checkForErrors(response);

        return response.getBody()
                .getData()
                .getDevelopers()
                .values()
                .stream()
                .collect(Collectors.toList());
    }
}
