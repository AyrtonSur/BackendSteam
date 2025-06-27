package com.devweb.backendsteam.controller;

import com.devweb.backendsteam.model.Game;
import com.devweb.backendsteam.model.ResultadoPaginado;
import com.devweb.backendsteam.service.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("games") // http://localhost:8080/games
public class GameController {

	@Autowired private GameService gameService;

	@GetMapping // Requisição do tipo GET para http://localhost:8080/games
	public List<Game> recuperarGames() {
		return gameService.recuperarGames();
	}

	// Requisição do tipo GET para http://localhost:8080/games/1
	@GetMapping("{idGame}")
	public Game recuperarGamePorId(@PathVariable("idGame") long id) {
		return gameService.recuperarGamePorId(id);
	}

	// Requisição do tipo GET para http://localhost:8080/games/category/aventura
	@GetMapping("category/{slugCategory}")
	public List<Game> recuperarGamesPorSlugCategory(
		@PathVariable("slugCategory") String slugCategory) {
		return gameService.recuperarGamesPorSlugCategory(slugCategory);
	}

	@PostMapping
	public Game cadastraGame(@RequestBody Game game) {
		return gameService.cadastrarGame(game);
	}

	@PutMapping
	public Game alterarGame(@RequestBody Game game) {
		return gameService.alterarGame(game);
	}

	@DeleteMapping("{idGame}") // http://localhost:8080/games/1
	public void removerGame(@PathVariable("idGame") long id) {
		gameService.removerGame(id);
	}

	// Entradas
	// - pagina corrente
	// - tamanho da página
	// Saídas:
	// - total de itens
	// - total de páginas
	// - pagina corrente
	// - itens da página corrente

	// Requisição do tipo GET para
	// http://localhost:8080/games/paginacao?pagina=0&tamanho=5&nome=ce
	@GetMapping("paginacao")
	public ResultadoPaginado<Game> recuperarGamesComPaginacao(
		@RequestParam(value = "pagina", defaultValue = "0") int pagina,
		@RequestParam(value = "tamanho", defaultValue = "5") int tamanho,
		@RequestParam(value = "nome", defaultValue = "") String nome) {
		Pageable pageable = PageRequest.of(pagina, tamanho);
		Page<Game> page = gameService.recuperarGamesComPaginacao(pageable, nome);
		ResultadoPaginado<Game> resultadoPaginado =
			new ResultadoPaginado<>(
				page.getTotalElements(), page.getTotalPages(), page.getNumber(), page.getContent());
		return resultadoPaginado;
	}
}
