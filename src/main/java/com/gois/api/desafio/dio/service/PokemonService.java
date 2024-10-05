package com.gois.api.desafio.dio.service;

import com.gois.api.desafio.dio.DTO.PokemonDTO;
import com.gois.api.desafio.dio.entities.Pokemon;
import com.gois.api.desafio.dio.repositories.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    public List<Pokemon> getAllPokemon() {
        return repository.findAll();
    }

    public Pokemon getPokemonById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public Pokemon savePokemon(PokemonDTO dto) {
        Pokemon newPokemon = new Pokemon(dto);
        return repository.save(newPokemon);
    }

    public Pokemon updatePokemon(PokemonDTO dto) {

        Pokemon newPokemon = repository.findById(dto.id()).orElseThrow(RuntimeException::new);
        newPokemon.setName(dto.name());

        return repository.save(newPokemon);
    }

    public Pokemon deletePokemon(Long id) {
        Pokemon pokemon = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.delete(pokemon);
        return pokemon;
    }
}