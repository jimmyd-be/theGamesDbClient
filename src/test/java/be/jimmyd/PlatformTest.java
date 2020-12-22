package be.jimmyd;


import be.jimmyd.entities.BaseImageResponse;
import be.jimmyd.entities.Platform;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;


public class PlatformTest
{
    private final TheGamesDbClient client;
    private final int platformId = 1;
    private final String platformName = "PC";

    public PlatformTest() {
        this.client = new TheGamesDbClient(System.getenv("THEGAMESDB_APIKEY"));
    }

    @Test
    public void getAllPlatforms() {
        final List<Platform> result = this.client.getAllPlatforms();

        assertFalse(result.isEmpty());
    }

    @Test
    public void getPlatformById() {
        final List<Platform> result = this.client.getPlatformById(platformId);

        assertFalse(result.isEmpty());
    }

    @Test
    public void getPlatformByMultiId() {
        final List<Platform> result = this.client.getPlatformById(Collections.singletonList(platformId));

        assertFalse(result.isEmpty());
    }


    @Test
    public void getPlatformByName() {
        final List<Platform> result = this.client.getPlatformByName(platformName);

        assertFalse(result.isEmpty());
    }

    @Test
    public void getPlatformImageById() {
        final BaseImageResponse result = this.client.getPlatformImageById(platformId);

        assertNotNull(result);
        assertNotNull(result.getBase_url());
        assertFalse(result.getImages().isEmpty());
    }

    @Test
    public void getPlatformImageByMultiId() {
        final BaseImageResponse result = this.client.getPlatformImageById(Collections.singletonList(platformId));

        assertNotNull(result);
        assertNotNull(result.getBase_url());
        assertFalse(result.getImages().isEmpty());
    }
}
