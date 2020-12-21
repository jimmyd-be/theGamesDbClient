package be.jimmyd;

import be.jimmyd.entities.Developer;
import be.jimmyd.entities.Genre;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;


public class DeveloperTest
{
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
