package com.devweb.backendsteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devweb.backendsteam.exception.JogoNaoEncontradoException;
import com.devweb.backendsteam.model.Jogo;
import com.devweb.backendsteam.repository.JogoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> recuperarJogos() {
        return jogoRepository.recuperarJogosComCategoria();
    }

    public Jogo cadastrarJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    @Transactional
    public Jogo alterarJogo(Jogo jogo) {
        jogoRepository.recuperarJogoPorIdComLock(jogo.getId())
            .orElseThrow(() -> new JogoNaoEncontradoException(
                    "Jogo número " + jogo.getId() + " não encontrado."));
        return jogoRepository.save(jogo);
    }

    @Transactional(rollbackFor = Exception.class)
    public void removerJogo(long id) {
        jogoRepository.deleteById(id);
    }

    public Jogo recuperarJogoPorId(long id) {
        return jogoRepository.recuperarJogoPorId(id)
            .orElseThrow(() -> new JogoNaoEncontradoException(
                "Jogo número " + id + " não encontrado."));
    }

    public Page<Jogo> recuperarJogosComPaginacao(Pageable pageable, String nome) {
        return jogoRepository.recuperarJogosComPaginacao(pageable, "%" + nome + "%");
    }

    public List<Jogo> recuperarJogosPorSlugCategoria(String slugCategoria) {
        return jogoRepository.recuperarJogosPorSlugCategoria(slugCategoria);
    }
}
