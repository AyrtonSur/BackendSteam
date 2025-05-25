package com.devweb.backendsteam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String titulo;
    private String desenvolvedora;
    private String publicadora;
    private String genero;
    private String plataforma;
    private LocalDate dataLancamento;
    private BigDecimal preco;
    private double avaliacao;
    private String descricao;
    private boolean multiplayer;
    private String classificacaoEtaria;
    private String idioma;
    @ManyToOne
    private Categoria categoria;

    public Jogo(
        String image, String titulo, String desenvolvedora, String publicadora, String genero, String plataforma,
        LocalDate dataLancamento, BigDecimal preco, double avaliacao, String descricao, 
        boolean multiplayer, String classificacaoEtaria, 
        String idioma, Categoria categoria
    ) {
        this.image = image;
        this.titulo = titulo;
        this.desenvolvedora = desenvolvedora;
        this.publicadora = publicadora;
        this.genero = genero;
        this.plataforma = plataforma;
        this.dataLancamento = dataLancamento;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.multiplayer = multiplayer;
        this.classificacaoEtaria = classificacaoEtaria;
        this.idioma = idioma;
        this.categoria = categoria;
    }
}
