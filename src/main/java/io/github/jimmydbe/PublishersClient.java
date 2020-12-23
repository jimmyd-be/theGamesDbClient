package io.github.jimmydbe;

import io.github.jimmydbe.entities.BasePublisherResponse;
import io.github.jimmydbe.entities.BaseResponse;
import io.github.jimmydbe.entities.Publisher;
import io.github.jimmydbe.exceptions.GamesDbException;
import io.github.jimmydbe.exceptions.ParsingException;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.List;
import java.util.stream.Collectors;

class PublishersClient extends Client {

    protected PublishersClient(String apiKey) {
        super(apiKey);
    }

    protected List<Publisher> getAllPublishers() throws ParsingException, GamesDbException {
        final HttpResponse<BaseResponse<BasePublisherResponse>> response = Unirest.get(TheGamesDbClient.BASE_URL + "/v1/Publishers")
                .queryString("apikey", getApiKey())
                .asObject(new GenericType<BaseResponse<BasePublisherResponse>>() {
                });

        checkForErrors(response);

        return response.getBody()
                .getData()
                .getPublishers()
                .values()
                .stream()
                .collect(Collectors.toList());
    }

}
