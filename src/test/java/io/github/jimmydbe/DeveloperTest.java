package io.github.jimmydbe;

import io.github.jimmydbe.entities.Developer;
import io.github.jimmydbe.exceptions.GamesDbException;
import io.github.jimmydbe.exceptions.ParsingException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;


public class DeveloperTest {
    private final TheGamesDbClient client;

    public DeveloperTest() {
        this.client = new TheGamesDbClient(System.getenv("THEGAMESDB_APIKEY"));
    }

    @Test
    public void getAllDevelopers() throws ParsingException, GamesDbException {
        final List<Developer> developers = this.client.getDevelopers();

        assertFalse(developers.isEmpty());
    }
}
