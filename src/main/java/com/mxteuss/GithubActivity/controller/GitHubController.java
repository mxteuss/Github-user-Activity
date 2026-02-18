package com.mxteuss.GithubActivity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mxteuss.GithubActivity.model.GithubEvent;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GitHubController {

    public GitHubController(String username) throws IOException, InterruptedException {
        final HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/" + username + "/repos?sort=updated"))
                .header("Accept", "application/vnd.github+json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            ObjectMapper mapper = new ObjectMapper();
            GithubEvent[] userResponse = mapper.readValue(response.body(), GithubEvent[].class);
            for (GithubEvent event1 : userResponse) {
                System.out.println("Name: " + event1.getName());
                System.out.println("Description: " + event1.getDescription());
                System.out.println("Language: " + event1.getLanguage());
                System.out.println("Last update: " + event1.getUpdatedAt());

                System.out.println("----------------");
            }
        } else {
            System.out.println("API Error: " + response.statusCode()
            + " - " + response.body());
        }
        client.close();
    }
}


