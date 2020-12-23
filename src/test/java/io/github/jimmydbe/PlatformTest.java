package io.github.jimmydbe;


import io.github.jimmydbe.entities.BaseImageResponse;
import io.github.jimmydbe.entities.Platform;
import io.github.jimmydbe.exceptions.GamesDbException;
import io.github.jimmydbe.exceptions.ParsingException;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


public class PlatformTest {
    private final TheGamesDbClient client;
    private final int platformId = 1;
    private final String platformName = "PC";

    public PlatformTest() {
        this.client = new TheGamesDbClient(System.getenv("THEGAMESDB_APIKEY"));
    }

    @Test
    public void getAllPlatforms() throws ParsingException, GamesDbException {
        final List<Platform> result = this.client.getAllPlatforms();

        assertFalse(result.isEmpty());
    }

    @Test
    public void getPlatformById() throws ParsingException, GamesDbException {
        final List<Platform> result = this.client.getPlatformById(platformId);

        assertFalse(result.isEmpty());
    }

    @Test
    public void getPlatformByMultiId() throws ParsingException, GamesDbException {
        final List<Platform> result = this.client.getPlatformById(Collections.singletonList(platformId));

        assertFalse(result.isEmpty());
    }


    @Test
    public void getPlatformByName() throws ParsingException, GamesDbException {
        final List<Platform> result = this.client.getPlatformByName(platformName);

        assertFalse(result.isEmpty());
    }

    @Test
    public void getPlatformImageById() throws ParsingException, GamesDbException {
        final BaseImageResponse result = this.client.getPlatformImageById(platformId);

        assertNotNull(result);
        assertNotNull(result.getBase_url());
        assertFalse(result.getImages().isEmpty());
    }

    @Test
    public void getPlatformImageByMultiId() throws ParsingException, GamesDbException {
        final BaseImageResponse result = this.client.getPlatformImageById(Collections.singletonList(platformId));

        assertNotNull(result);
        assertNotNull(result.getBase_url());
        assertFalse(result.getImages().isEmpty());
    }
}
