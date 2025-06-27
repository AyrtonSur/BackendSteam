package com.devweb.backendsteam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.UUID)
	private String user_id;

	private String name;
	private String username;
	private String email;
	private String password; // Password Hash
	private Integer age;
	private String genre;
	private String role;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdAt;

	@UpdateTimestamp private LocalDate updatedAt;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<OwnedGame> ownedGames;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Wishlist> wishlist;

	public User(
		String name,
		String username,
		String email,
		String password,
		Integer age,
		String genre,
		String role,
		LocalDate createdAt,
		LocalDate updatedAt
		) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.genre = genre;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
