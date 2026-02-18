package com.mxteuss.GithubActivity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubEvent {


    @JsonProperty("name")
    private String name;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("stargazers_count")
    private String stars;
    @JsonProperty("description")
    private String description;
    @JsonProperty("language")
    private String language;

}
