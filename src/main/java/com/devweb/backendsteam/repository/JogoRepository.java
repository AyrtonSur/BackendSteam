package com.devweb.backendsteam.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devweb.backendsteam.model.Jogo;

import java.util.List;
import java.util.Optional;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from Jogo p left outer join fetch p.categoria where p.id = :id")
    Optional<Jogo> recuperarJogoPorIdComLock(@Param("id") Long id);

    @Query("select p from Jogo p left outer join fetch p.categoria order by p.id")
    List<Jogo> recuperarJogosComCategoria();

    @Query("select p from Jogo p left outer join fetch p.categoria where p.id = :id")
    Optional<Jogo> recuperarJogoPorId(@Param("id") Long id);

    @Query(
        value = "select p from Jogo p left outer join fetch p.categoria where p.titulo like :nome order by p.id",
        countQuery = "select count(p) from Jogo p where p.titulo like :nome"
    )
    Page<Jogo> recuperarJogosComPaginacao(Pageable pageable, @Param("nome") String nome);

    @Query("select p from Jogo p " +
            "left outer join fetch p.categoria c " +
            "where c.slug = :slugCategoria " +
            "order by p.id")
    List<Jogo> recuperarJogosPorSlugCategoria(@Param("slugCategoria") String slugCategoria);
}
