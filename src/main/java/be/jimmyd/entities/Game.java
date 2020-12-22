package be.jimmyd.entities;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

}
