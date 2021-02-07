package io.github.jimmydbe.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class GameDto extends Game{

    public GameDto (Game game) {
        super(game);
    }

    @Setter
    private Platform platformObject;

    @Setter
    private List<Image> images;

    @Setter
    private BaseUrl imageBaseurl;
}
