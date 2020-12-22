package be.jimmyd.entities;

import lombok.Getter;

import java.util.List;

@Getter
public class BaseGameResponse {

    private int count;
    private List<Game> games;
}
