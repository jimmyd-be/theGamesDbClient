package be.jimmyd.entities;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class BaseGameResponse {

    private int count;
    private List<Game> games;
}
