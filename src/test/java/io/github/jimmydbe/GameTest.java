package io.github.jimmydbe;

import io.github.jimmydbe.entities.BaseImageResponse;
import io.github.jimmydbe.entities.Game;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


public class GameTest {
    private final TheGamesDbClient client;

    public GameTest() {
        this.client = new TheGamesDbClient(System.getenv("THEGAMESDB_APIKEY"));
    }

    @Test
    public void getGameById() {
        final List<Game> result = this.client.getGameById(1);

        assertFalse(result.isEmpty());
    }

    @Test
    public void getGameByName() {
        final List<Game> result = this.client.getGameByName("Battlefield");

        assertFalse(result.isEmpty());
        assertNotNull(result.get(0).getGame_title());
    }

    @Test
    public void getGameByPlatform() {
        final List<Game> result = this.client.getGameByPlatform(1);

        assertFalse(result.isEmpty());
    }

    @Test
    public void getGameImages() {
        final BaseImageResponse result = this.client.getGameImages(1);

        assertNotNull(result);
        assertNotNull(result.getBase_url());
        assertFalse(result.getImages().isEmpty());
    }

    @Test
    public void getGameByMultiId() {
        final List<Game> result = this.client.getGameById(Collections.singletonList(1));

        assertFalse(result.isEmpty());
    }

    @Test
    public void getGameByMultiPlatform() {
        final List<Game> result = this.client.getGameByPlatform(Collections.singletonList(1));

        assertFalse(result.isEmpty());
    }
}
