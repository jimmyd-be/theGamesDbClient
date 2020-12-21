package be.jimmyd.entities;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class ListPlatformResponse {

    private int count;
    private List<Platform> platforms;
}
