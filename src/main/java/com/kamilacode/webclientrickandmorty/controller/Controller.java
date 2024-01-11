package com.kamilacode.webclientrickandmorty.controller;


import com.kamilacode.webclientrickandmorty.client.RickAndMortyClient;
import com.kamilacode.webclientrickandmorty.model.CharacterResponse;
import com.kamilacode.webclientrickandmorty.model.ListOfEpisodesResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
@AllArgsConstructor
public class Controller {

    RickAndMortyClient rickAndMortyClient;


    @GetMapping("/character/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyClient.findACharacterById(id);

    }

    @GetMapping("/episodes")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ListOfEpisodesResponse> ListAllEpisodes() {
        return rickAndMortyClient.ListAllEpisodes();

    }
}
