package be.jimmyd;

import be.jimmyd.entities.BaseImageResponse;
import be.jimmyd.entities.Developer;
import be.jimmyd.entities.Game;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;


public class GameTest
{
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
}
