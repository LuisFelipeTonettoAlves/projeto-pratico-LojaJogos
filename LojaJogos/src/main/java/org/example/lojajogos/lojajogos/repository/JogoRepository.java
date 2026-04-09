package org.example.lojajogos.lojajogos.repository;

import org.example.lojajogos.lojajogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository <Jogo, Long> {
    List<Jogo> findByNomeContainingIgnoreCase(String nome);
}
