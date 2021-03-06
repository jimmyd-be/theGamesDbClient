package io.github.jimmydbe;

import io.github.jimmydbe.entities.Publisher;
import io.github.jimmydbe.exceptions.GamesDbException;
import io.github.jimmydbe.exceptions.ParsingException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;


public class PublisherTest {
    private final TheGamesDbClient client;

    public PublisherTest() {
        this.client = new TheGamesDbClient(System.getenv("THEGAMESDB_APIKEY"));
    }

    @Test
    public void getAllPublishers() throws ParsingException, GamesDbException {
        final List<Publisher> result = this.client.getPublishers();

        assertFalse(result.isEmpty());
    }
}
