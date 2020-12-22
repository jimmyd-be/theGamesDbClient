package be.jimmyd;

import be.jimmyd.entities.Publisher;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;


public class PublisherTest {
    private final TheGamesDbClient client;

    public PublisherTest() {
        this.client = new TheGamesDbClient(System.getenv("THEGAMESDB_APIKEY"));
    }

    @Test
    public void getAllPublishers() {
        final List<Publisher> result = this.client.getPublishers();

        assertFalse(result.isEmpty());
    }
}
