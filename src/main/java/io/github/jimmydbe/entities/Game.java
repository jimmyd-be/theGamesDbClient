package io.github.jimmydbe.entities;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class Game {

    private int id;
    private String game_title;
    private LocalDate release_date;
    private int platform;
    private int players;
    private String overview;
    private String last_updated;
    private String rating;
    private String coop;
    private String youtube;
    private String os;
    private String processor;
    private String ram;
    private String hdd;
    private String video;
    private String sound;
    private List<Integer> developers;
    private List<Integer> genres;
    private List<Integer> publishers;

    public Game(Game game) {
        this.id = game.getId();
        this.game_title = game.getGame_title();
        this.release_date = game.getRelease_date();
        this.platform = game.getPlatform();
        this.players = game.getPlayers();
        this.overview = game.getOverview();
        this.last_updated = game.getLast_updated();
        this.rating = game.getRating();
        this.coop = game.getCoop();
        this.youtube = game.getYoutube();
        this.os = game.getOs();
        this.processor = game.getProcessor();
        this.ram = game.getRam();
        this.hdd = game.getHdd();
        this.video = game.getVideo();
        this.sound = game.getSound();
        this.developers = game.getDevelopers();
        this.genres = game.getGenres();
        this.publishers = game.getPublishers();
    }

    public Game() {}
}
