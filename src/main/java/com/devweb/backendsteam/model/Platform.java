package com.devweb.backendsteam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Platform {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String slug;

	@JsonIgnore
	@ManyToMany(mappedBy = "platforms")
	private Set<Game> games = new HashSet<>();

	public Platform(String nome, String slug) {
		this.nome = nome;
		this.slug = slug;
	}
}
