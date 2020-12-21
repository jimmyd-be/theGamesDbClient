package be.jimmyd.entities;

import lombok.Getter;

import java.util.Map;

@Getter
public class BasePlatformResponse {

    private int count;
    private Map<String, Platform> platforms;
}
