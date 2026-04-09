package org.example.lojajogos.lojajogos.service;

import org.example.lojajogos.lojajogos.model.Jogo;
import org.example.lojajogos.lojajogos.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {
    private final JogoRepository repository;

    public JogoService(JogoRepository repository){ this.repository = repository; }

    public List<Jogo> listar() { return repository.findAll(); }

    public Jogo salvar(Jogo jogo) {return (Jogo)repository.save(jogo);}

    public void deletar (Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

    public Jogo buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }

    public List<Jogo> buscarPorNome(String nome){
    return repository.findByNomeContainingIgnoreCase(nome);
    }

    public Jogo atualizar(Long id, Jogo jogo) {
        buscarPorId(id);
        jogo.setId(id);
        return (Jogo)repository.save(jogo);
    }
}
