package com.mxteuss.GithubActivity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mxteuss.GithubActivity.model.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GitHubController {



    public GitHubController(String username) throws IOException, InterruptedException {
        final HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/" + username + "/events/public")) // URL da requisição
                .header("Accept", "application/vnd.github+json") // Aceitar a requisição em JSON
                .header("X-GitHub-Api-Version", "2022-11-28") //Versão da API
                .header("User-Agent", "spring-github-cli")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            ObjectMapper mapper = new ObjectMapper();
            User[] userResponse = mapper.readValue(response.body(), User[].class);
            for (User user : userResponse) {
                System.out.println(user.getActor().getUsername());
                System.out.println(user.getType());
                System.out.println(user.getRepo().getProjectName());
                System.out.println(user.getMessage());
                System.out.println(user.getDate());
                System.out.println("----------------");
            }
        } else {
            System.out.println("Erro da api: " + response.statusCode());
        }
        client.close();
    }
}


