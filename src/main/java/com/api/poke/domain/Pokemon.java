package com.api.poke.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pokemon {
  @JsonProperty("id")
  int id;

  @JsonProperty("name")
  String name;

  @JsonProperty("base_experience")
  int baseExperience;

  @JsonProperty("abilities")
  Object[] abilities;

  @JsonProperty("held_items")
  Object[] heldItems;

  @JsonProperty("location_area_encounters")
  String locationAreaEncounters;
}