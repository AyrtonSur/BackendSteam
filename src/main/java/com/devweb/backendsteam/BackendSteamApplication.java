package com.devweb.backendsteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devweb.backendsteam.model.Category;
import com.devweb.backendsteam.model.Game;
import com.devweb.backendsteam.repository.CategoryRepository;
import com.devweb.backendsteam.repository.GameRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class BackendSteamApplication implements CommandLineRunner {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private CategoryRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendSteamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Adicione categories de games digitais
		Category acao = new Category("Ação", "acao");
		Category rpg = new Category("RPG", "rpg");
		Category estrategia = new Category("Estratégia", "estrategia");
		Category aventura = new Category("Aventura", "aventura");
		categoriaRepository.save(acao);
		categoriaRepository.save(rpg);
		categoriaRepository.save(estrategia);
		categoriaRepository.save(aventura);

		// Hollow Knight
		Game hollowKnight = new Game(
				"hollowknight.png",
				"Hollow Knight",
				"Team Cherry",
				"Team Cherry",
				"Metroidvania",
				"PC, Switch, PS4, Xbox One",
				LocalDate.of(2017, 2, 24),
				BigDecimal.valueOf(28.99),
				4.9,
				"Explore cavernas, lute contra criaturas e descubra segredos em Hallownest.",
				false,
				"10+",
				"Português, Inglês",
				aventura
		);
		gameRepository.save(hollowKnight);

		// Skyrim
		Game skyrim = new Game(
				"skyrim.png",
				"The Elder Scrolls V: Skyrim",
				"Bethesda Game Studios",
				"Bethesda Softworks",
				"RPG",
				"PC, PS4, Xbox One, Switch",
				LocalDate.of(2011, 11, 11),
				BigDecimal.valueOf(59.99),
				4.8,
				"Viva uma aventura épica em um mundo aberto de fantasia.",
				false,
				"16+",
				"Português, Inglês",
				rpg
		);
		gameRepository.save(skyrim);

		// Balatro
		Game balatro = new Game(
				"balatro.png",
				"Balatro",
				"LocalThunk",
				"Playstack",
				"Estratégia",
				"PC",
				LocalDate.of(2024, 2, 20),
				BigDecimal.valueOf(29.99),
				4.7,
				"Um roguelike de pôquer inovador e viciante.",
				false,
				"12+",
				"Inglês",
				estrategia
		);
		gameRepository.save(balatro);

		// Terraria
		Game terraria = new Game(
				"terraria.png",
				"Terraria",
				"Re-Logic",
				"Re-Logic",
				"Ação/Aventura",
				"PC, PS4, Xbox One, Switch, Mobile",
				LocalDate.of(2011, 5, 16),
				BigDecimal.valueOf(19.99),
				4.8,
				"Explore, construa, lute e sobreviva em um mundo 2D cheio de possibilidades.",
				true,
				"10+",
				"Português, Inglês",
				acao
		);
		gameRepository.save(terraria);

		// Marvel Rivals
		Game marvelRivals = new Game(
				"marvelrivals.png",
				"Marvel Rivals",
				"NetEase Games",
				"NetEase Games",
				"Ação",
				"PC",
				LocalDate.of(2024, 12, 1),
				BigDecimal.valueOf(0.00),
				0.0,
				"Shooter em equipe com personagens do universo Marvel.",
				true,
				"12+",
				"Português, Inglês",
				acao
		);
		gameRepository.save(marvelRivals);

		// Stardew Valley
		Game stardewValley = new Game(
				"stardewvalley.png",
				"Stardew Valley",
				"ConcernedApe",
				"ConcernedApe",
				"Simulação/RPG",
				"PC, Switch, PS4, Xbox One, Mobile",
				LocalDate.of(2016, 2, 26),
				BigDecimal.valueOf(24.99),
				4.9,
				"Construa sua fazenda, faça amigos e explore cavernas em Stardew Valley.",
				true,
				"Livre",
				"Português, Inglês",
				rpg
		);
		gameRepository.save(stardewValley);

		// Civilization VI
		Game civ6 = new Game(
				"civ6.png",
				"Sid Meier's Civilization VI",
				"Firaxis Games",
				"2K Games",
				"Estratégia",
				"PC, Switch, PS4, Xbox One, iOS",
				LocalDate.of(2016, 10, 21),
				BigDecimal.valueOf(59.99),
				4.6,
				"Construa um império que resista ao tempo neste clássico de estratégia.",
				false,
				"10+",
				"Português, Inglês",
				estrategia
		);
		gameRepository.save(civ6);

		// Portal 2
		Game portal2 = new Game(
				"portal2.png",
				"Portal 2",
				"Valve",
				"Valve",
				"Puzzle/Plataforma",
				"PC, PS3, Xbox 360",
				LocalDate.of(2011, 4, 19),
				BigDecimal.valueOf(36.99),
				4.9,
				"Resolva puzzles desafiadores usando portais em uma aventura cheia de humor.",
				true,
				"10+",
				"Português, Inglês",
				estrategia
		);
		gameRepository.save(portal2);

		// The Witcher 3
		Game witcher3 = new Game(
				"witcher3.png",
				"The Witcher 3: Wild Hunt",
				"CD Projekt Red",
				"CD Projekt",
				"RPG",
				"PC, PS4, Xbox One, Switch",
				LocalDate.of(2015, 5, 19),
				BigDecimal.valueOf(79.99),
				4.9,
				"Viva a jornada de Geralt em um mundo aberto repleto de monstros e escolhas.",
				false,
				"18+",
				"Português, Inglês",
				rpg
		);
		gameRepository.save(witcher3);

		// Celeste
		Game celeste = new Game(
				"celeste.png",
				"Celeste",
				"Matt Makes Games",
				"Matt Makes Games",
				"Plataforma",
				"PC, Switch, PS4, Xbox One",
				LocalDate.of(2018, 1, 25),
				BigDecimal.valueOf(19.99),
				4.8,
				"Ajude Madeline a escalar a montanha Celeste em um desafiador game de plataforma.",
				false,
				"10+",
				"Português, Inglês",
				aventura
		);
		gameRepository.save(celeste);
	}
}
