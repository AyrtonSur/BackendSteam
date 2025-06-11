package com.devweb.backendsteam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String titulo;
    private String desenvolvedora;
    private String publicadora;

    private String plataforma;
    private LocalDate dataLancamento;
    private BigDecimal preco;
    private double avaliacao;
    private String descricao;
    private boolean multiplayer;
    private String classificacaoEtaria;
    private String idioma;
    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(name = "game_genre", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();
 
    @ManyToMany
    @JoinTable(name = "game_platform", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "platform_id"))
    private Set<Platform> platforms = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "game_language", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
    private Set<Language> languages = new HashSet<>();

    public Game(
        String image, String titulo, String desenvolvedora, String publicadora, Set<Genre> genres, String plataforma,
        LocalDate dataLancamento, BigDecimal preco, double avaliacao, String descricao, 
        boolean multiplayer, String classificacaoEtaria, 
        String idioma, Category category
    ) {
        this.image = image;
        this.titulo = titulo;
        this.desenvolvedora = desenvolvedora;
        this.publicadora = publicadora;
        this.genres = genres;
        this.plataforma = plataforma;
        this.dataLancamento = dataLancamento;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.multiplayer = multiplayer;
        this.classificacaoEtaria = classificacaoEtaria;
        this.idioma = idioma;
        this.category = category;
    }
}
