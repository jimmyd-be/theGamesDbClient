package io.github.jimmydbe.entities;

import lombok.Getter;

import java.util.Map;

@Getter
public class IncludePlatformResponse {

    private Map<String, Platform> data;
}
