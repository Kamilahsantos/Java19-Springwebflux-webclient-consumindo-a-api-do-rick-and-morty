package com.kamilacode.webclientrickandmorty.client;

import com.kamilacode.webclientrickandmorty.model.CharacterResponse;
import com.kamilacode.webclientrickandmorty.model.ListOfEpisodesResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@Service
public class RickAndMortyClient {

    private final WebClient webClient;

    public RickAndMortyClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();

    }

    public Mono<CharacterResponse> findACharacterById(String id) {
        return webClient.get().uri("/character/" + id).accept(APPLICATION_JSON).retrieve().bodyToMono(CharacterResponse.class);
    }

    public Flux<ListOfEpisodesResponse> ListAllEpisodes() {
        return webClient.get().uri("/episode").accept(APPLICATION_JSON).retrieve().bodyToFlux(ListOfEpisodesResponse.class);
    }
}
