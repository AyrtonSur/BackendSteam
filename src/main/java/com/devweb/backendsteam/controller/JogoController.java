package com.devweb.backendsteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.devweb.backendsteam.model.Jogo;
import com.devweb.backendsteam.model.ResultadoPaginado;
import com.devweb.backendsteam.service.JogoService;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("jogos")  // http://localhost:8080/jogos
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping   // Requisição do tipo GET para http://localhost:8080/jogos
    public List<Jogo> recuperarJogos() {
        return jogoService.recuperarJogos();
    }

    // Requisição do tipo GET para http://localhost:8080/jogos/1
    @GetMapping("{idJogo}")
    public Jogo recuperarJogoPorId(@PathVariable("idJogo") long id) {
        return jogoService.recuperarJogoPorId(id);
    }

    // Requisição do tipo GET para http://localhost:8080/jogos/categoria/aventura
    @GetMapping("categoria/{slugCategoria}")
    public List<Jogo> recuperarJogosPorSlugCategoria(@PathVariable("slugCategoria") String slugCategoria) {
        return jogoService.recuperarJogosPorSlugCategoria(slugCategoria);
    }

    @PostMapping
    public Jogo cadastraJogo(@RequestBody Jogo jogo) {
        return jogoService.cadastrarJogo(jogo);
    }

    @PutMapping
    public Jogo alterarJogo(@RequestBody Jogo jogo) {
        return jogoService.alterarJogo(jogo);
    }

    @DeleteMapping  ("{idJogo}")   // http://localhost:8080/jogos/1
    public void removerJogo(@PathVariable("idJogo") long id) {
        jogoService.removerJogo(id);
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
    // http://localhost:8080/jogos/paginacao?pagina=0&tamanho=5&nome=ce
    @GetMapping("paginacao")
    public ResultadoPaginado<Jogo> recuperarJogosComPaginacao(
            @RequestParam(value = "pagina", defaultValue = "0") int pagina,
            @RequestParam(value = "tamanho", defaultValue = "5") int tamanho,
            @RequestParam(value = "nome", defaultValue = "") String nome) {
        Pageable pageable = PageRequest.of(pagina, tamanho);
        Page<Jogo> page = jogoService.recuperarJogosComPaginacao(pageable, nome);
        ResultadoPaginado<Jogo> resultadoPaginado = new ResultadoPaginado<>(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getContent());
        return resultadoPaginado;
    }

}
