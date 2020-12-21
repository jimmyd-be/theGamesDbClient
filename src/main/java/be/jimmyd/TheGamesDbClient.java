package be.jimmyd;


import be.jimmyd.entities.*;

import java.util.List;

public class TheGamesDbClient
{
    protected final static String BASE_URL = "https://api.thegamesdb.net";

    private final DevelopersClient developersClient;
    private final GamesClient gamesClient;
    private final GenresClient genresClient;
    private final PlatformsClient platformsClient;
    private final PublishersClient publishersClient;

    public TheGamesDbClient(final String apiKey) {
        this.developersClient = new DevelopersClient(apiKey);
        this.gamesClient = new GamesClient(apiKey);
        this.genresClient = new GenresClient(apiKey);
        this.platformsClient = new PlatformsClient(apiKey);
        this.publishersClient = new PublishersClient(apiKey);
    }

    public List<Genre> getGenres() {
        return this.genresClient.getAllGenres();
    }

    public List<Developer> getDevelopers() {
        return this.developersClient.getAllDevelopers();
    }


    public List<Publisher> getPublishers() {
        return this.publishersClient.getAllPublishers();
    }

    public List<Platform> getAllPlatforms() {
        return this.platformsClient.getAllPlatforms();
    }

    public List<Platform> getPlatformById(int id) {
        return this.platformsClient.getPlatformById(id);
    }

    public List<Platform> getPlatformByName(String name) {
        return this.platformsClient.getPlatformByName(name);
    }

    public BaseImageResponse getPlatformImageById(int id) {
        return this.platformsClient.getPlatformImageById(id);
    }

    public List<Game> getGameById(int id) {
        return this.gamesClient.getGameById(id);
    }

    public List<Game> getGameByName(String name) {
        return this.gamesClient.getGameByName(name);
    }

    public List<Game> getGameByPlatform(int platformId) {
        return this.gamesClient.getGameByPlatform(platformId);
    }

    public List<Game> getUpdateGame(int lastEditId) {
        return this.gamesClient.getUpdateGame(lastEditId);
    }

    public BaseImageResponse getGameImages(int id) {
        return this.gamesClient.getGameImages(id);
    }

}
