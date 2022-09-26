package com.api.poke.controller;

import java.util.Collections;
import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.poke.domain.Pokemon;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PokeController {
  RestTemplate restTemplate;

  public PokeController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  private String getURI(String pokemonName) {
    return "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
  }

  private HashMap createHashMap(String key, Object value) {
    HashMap<String, Object> map = new HashMap<>();
    map.put(key, value);
    return map;
  }

  @GetMapping("/id/{pokemon}")
  public ResponseEntity<Object> getPokemonId(@PathVariable("pokemon") String pokemonName) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
    try {
      int response = restTemplate.exchange(getURI(pokemonName), HttpMethod.GET, entity, Pokemon.class).getBody()
          .getId();
      return ResponseEntity.ok().body(createHashMap("id", response));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createHashMap("error", e.getMessage()));
    }
  }

  @GetMapping("/name/{pokemon}")
  public ResponseEntity<Object> getPokemonName(@PathVariable("pokemon") String pokemonName) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
    try {
      String response = restTemplate.exchange(getURI(pokemonName), HttpMethod.GET, entity, Pokemon.class).getBody()
          .getName();
      return ResponseEntity.ok().body(createHashMap("name", response));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createHashMap("error", e.getMessage()));
    }
  }

  @GetMapping("/base_experience/{pokemon}")
  public ResponseEntity<Object> getPokemonBaseExperience(@PathVariable("pokemon") String pokemonName) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
    try {
      int response = restTemplate.exchange(getURI(pokemonName), HttpMethod.GET, entity, Pokemon.class).getBody()
          .getBaseExperience();
      return ResponseEntity.ok().body(createHashMap("base_experience", response));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createHashMap("error", e.getMessage()));
    }
  }

  @GetMapping("/abilities/{pokemon}")
  public ResponseEntity<Object> getPokemonAbilities(@PathVariable("pokemon") String pokemonName) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
    try {
      Object[] response = restTemplate.exchange(getURI(pokemonName), HttpMethod.GET, entity, Pokemon.class).getBody()
          .getAbilities();
      return ResponseEntity.ok().body(createHashMap("abilities", response));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createHashMap("error", e.getMessage()));
    }
  }

  @GetMapping("/held_items/{pokemon}")
  public ResponseEntity<Object> getPokemonHeldItems(@PathVariable("pokemon") String pokemonName) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
    try {
      Object[] response = restTemplate.exchange(getURI(pokemonName), HttpMethod.GET, entity, Pokemon.class).getBody()
          .getHeldItems();
      return ResponseEntity.ok().body(createHashMap("held_items", response));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createHashMap("error", e.getMessage()));
    }
  }

  @GetMapping("/location_area_encounters/{pokemon}")
  public ResponseEntity<Object> getpokemonLocationArea(@PathVariable("pokemon") String pokemonName) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
    try {
      String response = restTemplate.exchange(getURI(pokemonName), HttpMethod.GET, entity, Pokemon.class).getBody()
          .getLocationAreaEncounters();
      return ResponseEntity.ok().body(createHashMap("location_area_encounters", response));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createHashMap("error", e.getMessage()));
    }
  }
}