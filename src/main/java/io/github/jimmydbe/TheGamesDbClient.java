package io.github.jimmydbe;


import io.github.jimmydbe.entities.*;
import io.github.jimmydbe.exceptions.GamesDbException;
import io.github.jimmydbe.exceptions.ParsingException;

import java.util.Collections;
import java.util.List;

/**
 * The Games DB wrapper class
 */
public class TheGamesDbClient {
    protected final static String BASE_URL = "https://api.thegamesdb.net";

    private final DevelopersClient developersClient;
    private final GamesClient gamesClient;
    private final GenresClient genresClient;
    private final PlatformsClient platformsClient;
    private final PublishersClient publishersClient;

    /**
     * Constructor to make an instance of the wrapper class
     *
     * @param apiKey The key that is used to contact The Games DB API
     * @throws IllegalArgumentException if apiKey is not available or wrong
     */
    public TheGamesDbClient(final String apiKey) {

        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("apiKey is required to use the wrapper!");
        }

        this.developersClient = new DevelopersClient(apiKey);
        this.gamesClient = new GamesClient(apiKey);
        this.genresClient = new GenresClient(apiKey);
        this.platformsClient = new PlatformsClient(apiKey);
        this.publishersClient = new PublishersClient(apiKey);
    }

    /**
     * Fetch all Genres from The Games DB
     *
     * @return All the genres that are available in The Games DB
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Genres/Genres">The Games DB API</a>
     */
    public List<Genre> getGenres() throws ParsingException, GamesDbException {
        return this.genresClient.getAllGenres();
    }

    /**
     * Fetch all developers from The Games DB
     *
     * @return All the developers that are available in The Games DB
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Developers/Developers">The Games DB API</a>
     */
    public List<Developer> getDevelopers() throws ParsingException, GamesDbException {
        return this.developersClient.getAllDevelopers();
    }

    /**
     * Fetch all publishers from The Games DB
     *
     * @return All the publishers that are available in The Games DB
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Publishers/Publishers">The Games DB API</a>
     */
    public List<Publisher> getPublishers() throws ParsingException, GamesDbException {
        return this.publishersClient.getAllPublishers();
    }

    /**
     * Fetch all platforms from The Games DB
     *
     * @return All the platforms that are available in The Games DB
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Platforms/Platforms">The Games DB API</a>
     */
    public List<Platform> getAllPlatforms() throws ParsingException, GamesDbException {
        return this.platformsClient.getAllPlatforms();
    }

    /**
     * Get platform by id from The Games DB
     *
     * @param id Platform id
     * @return The platform with id that is available in The Games DB
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Platforms/PlatformsByPlatformID">The Games DB API</a>
     */
    public List<Platform> getPlatformById(int id) throws ParsingException, GamesDbException {
        return this.platformsClient.getPlatformById(Collections.singletonList(id));
    }

    /**
     * Get platform by list of ids from The Games DB
     *
     * @param id List of platform ids
     * @return The platforms with ids that are available in The Games DB
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Platforms/PlatformsByPlatformID">The Games DB API</a>
     */
    public List<Platform> getPlatformById(List<Integer> id) throws ParsingException, GamesDbException {
        return this.platformsClient.getPlatformById(id);
    }

    /**
     * Get platform by name from The Games DB
     *
     * @param name Platform name
     * @return The platforms related to his name
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Platforms/PlatformsByPlatformName">The Games DB API</a>
     */
    public List<Platform> getPlatformByName(String name) throws ParsingException, GamesDbException {
        return this.platformsClient.getPlatformByName(name);
    }

    /**
     * Get platform image by platform id
     *
     * @param id Platform id
     * @return The images of a platform by platform id
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Platforms/PlatformsImages">The Games DB API</a>
     */
    public BaseImageResponse getPlatformImageById(int id) throws ParsingException, GamesDbException {
        return this.platformsClient.getPlatformImageById(Collections.singletonList(id));
    }

    /**
     * Get platform image by multiple platform id
     *
     * @param id List of platform ids
     * @return The images of a platform by platform ids
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Platforms/PlatformsImages">The Games DB API</a>
     */
    public BaseImageResponse getPlatformImageById(List<Integer> id) throws ParsingException, GamesDbException {
        return this.platformsClient.getPlatformImageById(id);
    }

    /**
     * Get games by game id
     *
     * @param id Game id
     * @return The game with id
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Games/GamesByGameID">The Games DB API</a>
     */
    public List<GameDto> getGameById(int id) throws ParsingException, GamesDbException {
        return this.gamesClient.getGameById(Collections.singletonList(id));
    }

    /**
     * Get games by game multiple ids
     *
     * @param id List of game ids
     * @return The game with multiple id
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Games/GamesByGameID">The Games DB API</a>
     */
    public List<GameDto> getGameById(List<Integer> id) throws ParsingException, GamesDbException {
        return this.gamesClient.getGameById(id);
    }

    /**
     * Get games by name
     *
     * @param name Game name
     * @return The games search by his name
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Games/GamesByGameName">The Games DB API</a>
     */
    public List<GameDto> getGameByName(String name) throws ParsingException, GamesDbException {
        return this.gamesClient.getGameByName(name);
    }

    /**
     * Get games by platform id
     *
     * @param platformId Platform id
     * @return The games related to his platform
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Games/GamesByPlatformID">The Games DB API</a>
     */
    public List<GameDto> getGameByPlatform(int platformId) throws ParsingException, GamesDbException {
        return this.gamesClient.getGameByPlatform(Collections.singletonList(platformId));
    }

    /**
     * Get games by multiple platform ids
     *
     * @param platformId List of platform ids
     * @return The games related to his platforms
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Games/GamesByPlatformID">The Games DB API</a>
     */
    public List<GameDto> getGameByPlatform(List<Integer> platformId) throws ParsingException, GamesDbException {
        return this.gamesClient.getGameByPlatform(platformId);
    }

    /**
     * Get updated game data
     *
     * @param lastEditId Id of the edit of the game
     * @return The updated game data
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Games/GamesUpdates">The Games DB API</a>
     */
    public List<Game> getUpdateGame(int lastEditId) throws ParsingException, GamesDbException {
        return this.gamesClient.getUpdateGame(lastEditId);
    }

    /**
     * Get game images by game id
     *
     * @param id Game id
     * @return The game images
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Games/GamesImages">The Games DB API</a>
     */
    public BaseImageResponse getGameImages(int id) throws ParsingException, GamesDbException {
        return this.gamesClient.getGameImages(Collections.singletonList(id));
    }

    /**
     * Get game images by game ids
     *
     * @param id List of games ids
     * @return The game images
     * @throws ParsingException when The Games DB response cannot be parsed
     * @throws GamesDbException when the connection to the API is failing
     * @see <a href="https://api.thegamesdb.net/#/Games/GamesImages">The Games DB API</a>
     */
    public BaseImageResponse getGameImages(List<Integer> id) throws ParsingException, GamesDbException {
        return this.gamesClient.getGameImages(id);
    }
}
