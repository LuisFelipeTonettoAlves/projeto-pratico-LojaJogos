package org.example.lojajogos.lojajogos.controller;

import jakarta.validation.Valid;
import org.example.lojajogos.lojajogos.model.Jogo;
import org.example.lojajogos.lojajogos.service.JogoService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/jogos"})
public class JogoController {
    private final JogoService service;

    private JogoController(JogoService service) {this.service = service;}

    @GetMapping
    public List<Jogo> listar() {return service.listar();}

    @PostMapping
    public Jogo salvar(@RequestBody @Valid Jogo jogo) {return service.salvar(jogo);}

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {service.deletar(id);}

    @GetMapping("/{id}")
    public Jogo buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    @GetMapping({"/buscar"})
    public List<Jogo> buscarPorNome(@RequestParam String nome) { return service.buscarPorNome(nome); }

    @PutMapping("/{id}")
    public Jogo atualizar(@PathVariable Long id, @RequestBody @Valid Jogo jogo){
        return service.atualizar(id, jogo);
    }
}
