package io.github.jimmydbe.entities;

import lombok.Getter;

import java.util.Map;

@Getter
public class BasePublisherResponse {

    private int count;
    private Map<String, Publisher> publishers;
}
