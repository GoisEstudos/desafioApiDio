package com.gois.api.desafio.dio.entities;

import com.gois.api.desafio.dio.DTO.PokemonDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String type;
    private String description;

    public Pokemon(PokemonDTO dto) {
        this.id = dto.id();
        this.name = dto.name();
        this.type = dto.type();
        this.description = dto.description();
    }
}
