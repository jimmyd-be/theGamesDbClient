package be.jimmyd;

import be.jimmyd.entities.Genre;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;


public class GenreTest {
    private final TheGamesDbClient client;

    public GenreTest() {
        this.client = new TheGamesDbClient(System.getenv("THEGAMESDB_APIKEY"));
    }

    @Test
    public void getAllGenres() {
        final List<Genre> genres = this.client.getGenres();

        assertFalse(genres.isEmpty());
    }
}
