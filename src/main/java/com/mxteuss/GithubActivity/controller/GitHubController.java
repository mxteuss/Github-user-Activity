package com.mxteuss.GithubActivity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/github")
public class GitHubController {

    private final HttpClient client = HttpClient.newHttpClient(); // inicializa o HttpClient

    @GetMapping("/events/{username}")
    public ResponseEntity<String> getEvents(@PathVariable String username) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/" + username + "/events/public")) // URL da requisição
                .header("Accept", "application/vnd.github+json") // Aceitar a requisição em JSON
                .header("X-GitHub-Api-Version", "2022-11-28") //Versão da API
                .header("User-Agent", "spring-github-cli")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return ResponseEntity.status(response.statusCode()).body(response.body());
    }
}
