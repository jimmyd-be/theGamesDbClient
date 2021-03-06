package io.github.jimmydbe.entities;

import lombok.Getter;

import java.util.Map;

@Getter
public class BaseDeveloperResponse {

    private int count;
    private Map<String, Developer> developers;
}
