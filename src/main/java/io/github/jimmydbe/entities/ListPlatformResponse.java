package io.github.jimmydbe.entities;

import lombok.Getter;

import java.util.List;

@Getter
public class ListPlatformResponse {

    private int count;
    private List<Platform> platforms;
}
