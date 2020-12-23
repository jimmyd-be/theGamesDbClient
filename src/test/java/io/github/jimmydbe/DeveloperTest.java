package io.github.jimmydbe;

import io.github.jimmydbe.entities.Developer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;


public class DeveloperTest {
    private final TheGamesDbClient client;

    public DeveloperTest() {
        this.client = new TheGamesDbClient(System.getenv("THEGAMESDB_APIKEY"));
    }

    @Test
    public void getAllDevelopers() {
        final List<Developer> developers = this.client.getDevelopers();

        assertFalse(developers.isEmpty());
    }
}
