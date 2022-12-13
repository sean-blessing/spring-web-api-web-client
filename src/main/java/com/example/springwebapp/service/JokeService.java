package com.example.springwebapp.service;

import com.example.springwebapp.model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class JokeService {

    private final WebClient webClient;

    public JokeService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://official-joke-api.appspot.com/random_joke").build();
    }

    public Mono<Joke> getRandomJoke() {
        return this.webClient.get().uri("/").retrieve().bodyToMono(Joke.class);
    }
}
