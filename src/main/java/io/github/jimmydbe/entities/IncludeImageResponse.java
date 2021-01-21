package io.github.jimmydbe.entities;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class IncludeImageResponse {

    private BaseUrl base_url;
    private Map<String, List<Image>> data;
}
