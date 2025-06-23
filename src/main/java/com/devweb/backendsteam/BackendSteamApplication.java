package com.devweb.backendsteam;

import com.devweb.backendsteam.model.*;
import com.devweb.backendsteam.repository.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendSteamApplication implements CommandLineRunner {

	@Autowired private GameRepository gameRepository;
	@Autowired private CategoryRepository categoryRepository;
	@Autowired private GenreRepository genreRepository;
	@Autowired private PlatformRepository platformRepository;
	@Autowired private LanguageRepository languageRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendSteamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Categorias
		Category acao = categoryRepository.save(new Category("Ação", "acao"));
		Category rpg = categoryRepository.save(new Category("RPG", "rpg"));
		Category estrategia = categoryRepository.save(new Category("Estratégia", "estrategia"));
		Category aventura = categoryRepository.save(new Category("Aventura", "aventura"));

		// Gêneros
		Genre metroidvania = genreRepository.save(new Genre("Metroidvania", "metroidvania"));
		Genre rpgGenre = genreRepository.save(new Genre("RPG", "rpg"));
		Genre estrategiaGenre = genreRepository.save(new Genre("Estratégia", "estrategia"));
		Genre acaoAventura = genreRepository.save(new Genre("Ação/Aventura", "acao-aventura"));
		Genre simulacaoRpg = genreRepository.save(new Genre("Simulação/RPG", "simulacao-rpg"));
		Genre plataforma = genreRepository.save(new Genre("Plataforma", "plataforma"));
		Genre puzzle = genreRepository.save(new Genre("Puzzle/Plataforma", "puzzle-plataforma"));

		// Plataformas
		Platform pc = platformRepository.save(new Platform("PC", "pc"));
		Platform switchP = platformRepository.save(new Platform("Switch", "switch"));
		Platform ps4 = platformRepository.save(new Platform("PS4", "ps4"));
		Platform xboxOne = platformRepository.save(new Platform("Xbox One", "xbox-one"));
		Platform mobile = platformRepository.save(new Platform("Mobile", "mobile"));
		Platform ps3 = platformRepository.save(new Platform("PS3", "ps3"));
		Platform xbox360 = platformRepository.save(new Platform("Xbox 360", "xbox-360"));
		Platform ios = platformRepository.save(new Platform("iOS", "ios"));

		// Idiomas
		Language portugues = languageRepository.save(new Language("Português", "portugues"));
		Language ingles = languageRepository.save(new Language("Inglês", "ingles"));

		// Hollow Knight
		Game hollowKnight = new Game(
			"hollowknight.png",
			"Hollow Knight",
			"Team Cherry",
			"Team Cherry",
			Set.of(metroidvania),
			"PC, Switch, PS4, Xbox One",
			LocalDate.of(2017, 2, 24),
			BigDecimal.valueOf(28.99),
			4.9,
			"Explore cavernas, lute contra criaturas e descubra segredos em Hallownest.",
			false,
			"10+",
			"Português, Inglês",
			aventura,
			Set.of(pc, switchP, ps4, xboxOne),
			Set.of(portugues, ingles)
		);
		gameRepository.save(hollowKnight);

		// Skyrim
		Game skyrim = new Game(
			"skyrim.png",
			"The Elder Scrolls V: Skyrim",
			"Bethesda Game Studios",
			"Bethesda Softworks",
			Set.of(rpgGenre),
			"PC, PS4, Xbox One, Switch",
			LocalDate.of(2011, 11, 11),
			BigDecimal.valueOf(59.99),
			4.8,
			"Viva uma aventura épica em um mundo aberto de fantasia.",
			false,
			"16+",
			"Português, Inglês",
			rpg,
			Set.of(pc, ps4, xboxOne, switchP),
			Set.of(portugues, ingles)
		);
		gameRepository.save(skyrim);

		// Balatro
		Game balatro = new Game(
			"balatro.png",
			"Balatro",
			"LocalThunk",
			"Playstack",
			Set.of(estrategiaGenre),
			"PC",
			LocalDate.of(2024, 2, 20),
			BigDecimal.valueOf(29.99),
			4.7,
			"Um roguelike de pôquer inovador e viciante.",
			false,
			"12+",
			"Inglês",
			estrategia,
			Set.of(pc),
			Set.of(ingles)
		);
		gameRepository.save(balatro);

		// Terraria
		Game terraria = new Game(
			"terraria.png",
			"Terraria",
			"Re-Logic",
			"Re-Logic",
			Set.of(acaoAventura),
			"PC, PS4, Xbox One, Switch, Mobile",
			LocalDate.of(2011, 5, 16),
			BigDecimal.valueOf(19.99),
			4.8,
			"Explore, construa, lute e sobreviva em um mundo 2D cheio de possibilidades.",
			true,
			"10+",
			"Português, Inglês",
			acao,
			Set.of(pc, ps4, xboxOne, switchP, mobile),
			Set.of(portugues, ingles)
		);
		gameRepository.save(terraria);

		// Marvel Rivals
		Game marvelRivals = new Game(
			"marvelrivals.png",
			"Marvel Rivals",
			"NetEase Games",
			"NetEase Games",
			Set.of(acaoAventura),
			"PC",
			LocalDate.of(2024, 12, 1),
			BigDecimal.valueOf(0.00),
			0.0,
			"Shooter em equipe com personagens do universo Marvel.",
			true,
			"12+",
			"Português, Inglês",
			acao,
			Set.of(pc),
			Set.of(portugues, ingles)
		);
		gameRepository.save(marvelRivals);

		// Stardew Valley
		Game stardewValley = new Game(
			"stardewvalley.png",
			"Stardew Valley",
			"ConcernedApe",
			"ConcernedApe",
			Set.of(simulacaoRpg, rpgGenre),
			"PC, Switch, PS4, Xbox One, Mobile",
			LocalDate.of(2016, 2, 26),
			BigDecimal.valueOf(24.99),
			4.9,
			"Construa sua fazenda, faça amigos e explore cavernas em Stardew Valley.",
			true,
			"Livre",
			"Português, Inglês",
			rpg,
			Set.of(pc, switchP, ps4, xboxOne, mobile),
			Set.of(portugues, ingles)
		);
		gameRepository.save(stardewValley);

		// Civilization VI
		Game civ6 = new Game(
			"civ6.png",
			"Sid Meier's Civilization VI",
			"Firaxis Games",
			"2K Games",
			Set.of(estrategiaGenre),
			"PC, Switch, PS4, Xbox One, iOS",
			LocalDate.of(2016, 10, 21),
			BigDecimal.valueOf(59.99),
			4.6,
			"Construa um império que resista ao tempo neste clássico de estratégia.",
			false,
			"10+",
			"Português, Inglês",
			estrategia,
			Set.of(pc, switchP, ps4, xboxOne, ios),
			Set.of(portugues, ingles)
		);
		gameRepository.save(civ6);

		// Portal 2
		Game portal2 = new Game(
			"portal2.png",
			"Portal 2",
			"Valve",
			"Valve",
			Set.of(puzzle, plataforma),
			"PC, PS3, Xbox 360",
			LocalDate.of(2011, 4, 19),
			BigDecimal.valueOf(36.99),
			4.9,
			"Resolva puzzles desafiadores usando portais em uma aventura cheia de humor.",
			true,
			"10+",
			"Português, Inglês",
			estrategia,
			Set.of(pc, ps3, xbox360),
			Set.of(portugues, ingles)
		);
		gameRepository.save(portal2);

		// The Witcher 3
		Game witcher3 = new Game(
			"witcher3.png",
			"The Witcher 3: Wild Hunt",
			"CD Projekt Red",
			"CD Projekt",
			Set.of(rpgGenre),
			"PC, PS4, Xbox One, Switch",
			LocalDate.of(2015, 5, 19),
			BigDecimal.valueOf(79.99),
			4.9,
			"Viva a jornada de Geralt em um mundo aberto repleto de monstros e escolhas.",
			false,
			"18+",
			"Português, Inglês",
			rpg,
			Set.of(pc, ps4, xboxOne, switchP),
			Set.of(portugues, ingles)
		);
		gameRepository.save(witcher3);

		// Celeste
		Game celeste = new Game(
			"celeste.png",
			"Celeste",
			"Matt Makes Games",
			"Matt Makes Games",
			Set.of(plataforma),
			"PC, Switch, PS4, Xbox One",
			LocalDate.of(2018, 1, 25),
			BigDecimal.valueOf(19.99),
			4.8,
			"Ajude Madeline a escalar a montanha Celeste em um desafiador game de plataforma.",
			false,
			"10+",
			"Português, Inglês",
			aventura,
			Set.of(pc, switchP, ps4, xboxOne),
			Set.of(portugues, ingles)
		);
		gameRepository.save(celeste);
	}
}