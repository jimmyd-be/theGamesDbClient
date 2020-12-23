package io.github.jimmydbe.entities;

import lombok.Getter;

import java.util.Map;

@Getter
public class BaseGenreResponse {

    private int count;
    private Map<String, Genre> genres;
}
