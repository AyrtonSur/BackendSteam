package com.devweb.backendsteam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nome;
private String slug;

@JsonIgnore
@OneToMany(mappedBy = "category")
private List<Game> games;

public Category(String nome, String slug) {
	this.nome = nome;
	this.slug = slug;
}
}
