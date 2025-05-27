package com.example.aula.service;

import com.example.aula.model.Jogador;
import com.example.aula.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador salvar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> buscarPorId(Long id) {
        return jogadorRepository.findById(id);
    }

    public Jogador atualizar(Long id, Jogador novoJogador) {
        return jogadorRepository.findById(id)
                .map(j -> {
                    j.setNome(novoJogador.getNome());
                    j.setPosicao(novoJogador.getPosicao());
                    j.setNumeroCamisa(novoJogador.getNumeroCamisa());
                    return jogadorRepository.save(j);
                })
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado com ID: " + id));
    }

    public void deletar(Long id) {
        if (!jogadorRepository.existsById(id)) {
            throw new RuntimeException("Jogador não encontrado com ID: " + id);
        }
        jogadorRepository.deleteById(id);
    }
}
