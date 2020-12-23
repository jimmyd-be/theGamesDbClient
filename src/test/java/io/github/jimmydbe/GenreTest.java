package io.github.jimmydbe;

import io.github.jimmydbe.entities.Genre;
import io.github.jimmydbe.exceptions.GamesDbException;
import io.github.jimmydbe.exceptions.ParsingException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;


public class GenreTest {
    private final TheGamesDbClient client;

    public GenreTest() {
        this.client = new TheGamesDbClient(System.getenv("THEGAMESDB_APIKEY"));
    }

    @Test
    public void getAllGenres() throws ParsingException, GamesDbException {
        final List<Genre> genres = this.client.getGenres();

        assertFalse(genres.isEmpty());
    }
}
