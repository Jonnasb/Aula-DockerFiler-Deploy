package com.example.aula.controller;

import com.example.aula.model.Jogador;
import com.example.aula.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
@CrossOrigin(origins = "*")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public Jogador cadastrar(@RequestBody Jogador jogador) {
        return jogadorService.salvar(jogador);
    }

    @GetMapping
    public List<Jogador> listarTodos() {
        return jogadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarPorId(@PathVariable Long id) {
        return jogadorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
