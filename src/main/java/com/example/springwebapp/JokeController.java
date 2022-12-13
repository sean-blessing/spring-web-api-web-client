package com.example.springwebapp;

import com.example.springwebapp.model.Joke;
import com.example.springwebapp.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @GetMapping
    public Mono<Joke> getRandomJoke() {
        return jokeService.getRandomJoke();
    }
}
