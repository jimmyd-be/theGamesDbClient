package io.github.jimmydbe;

import org.junit.Test;

public class TheGamesDbClientTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIfApiKeyIsGiven() {

        new TheGamesDbClient("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfApiKeyIsNull() {

        new TheGamesDbClient(null);
    }
}
