package com.gois.api.desafio.dio.controller;

import com.gois.api.desafio.dio.DTO.PokemonDTO;
import com.gois.api.desafio.dio.entities.Pokemon;
import com.gois.api.desafio.dio.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemons() {
        List<Pokemon> newPokemons = service.getAllPokemon();
        return ResponseEntity.ok(newPokemons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(Long id) {
        Pokemon newPokemon = service.getPokemonById(id);
        return ResponseEntity.ok(newPokemon);
    }

    @PostMapping
    public ResponseEntity<Pokemon> savePokemon(PokemonDTO dto) {
        Pokemon newPokemon = service.savePokemon(dto);
        return ResponseEntity.ok(newPokemon);
    }

    @PatchMapping
    public ResponseEntity<Pokemon> updatePokemon(PokemonDTO dto) {
        Pokemon newPokemon = service.updatePokemon(dto);
        return ResponseEntity.ok(newPokemon);
    }

    @DeleteMapping
    public ResponseEntity<Pokemon> deletePokemon(Long id) {
        Pokemon newPokemon = service.deletePokemon(id);
        return ResponseEntity.ok(newPokemon);
    }
}
