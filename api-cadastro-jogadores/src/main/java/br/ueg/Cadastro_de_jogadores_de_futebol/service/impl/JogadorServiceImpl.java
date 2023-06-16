package br.ueg.Cadastro_de_jogadores_de_futebol.service.impl;

import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;
import br.ueg.Cadastro_de_jogadores_de_futebol.repository.JogadorRepository;
import br.ueg.Cadastro_de_jogadores_de_futebol.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JogadorServiceImpl implements JogadorService{

    @Autowired
    private JogadorRepository jogadorRepository;

    @Override
    public Jogador incluir(Jogador jogador) {
        Jogador jogadorincluido = this.gravarDados(jogador);
        return jogadorincluido;

    }

    private Jogador gravarDados(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    @Override
    public Jogador alterar(Jogador jogador, Long id) {
        Jogador jogadorBD = jogadorRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Erro ao localizar jogador para alteração"));
        Jogador save = jogadorRepository.save(jogador);
        return save;
    }

    private Jogador recuperarJogadorOuGeraErro(Long id) {
        Jogador jogadorBD = jogadorRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Erro ao Localizar o Jogador!")
                );
        return jogadorBD;
    }

    @Override
    public Jogador excluir(Long id) {
        Jogador jogadorExcluir = this.recuperarJogadorOuGeraErro(id);
        this.jogadorRepository.delete(jogadorExcluir);
        return jogadorExcluir;
    }

    @Override
    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }
}
