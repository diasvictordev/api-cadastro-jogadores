package br.ueg.Cadastro_de_jogadores_de_futebol.service;

import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;

import java.util.List;

public interface JogadorService {

    public Jogador incluir (Jogador jogador);
    public Jogador alterar (Jogador jogador, Long id);
    public Jogador excluir (Long id);
    public List<Jogador> listarTodos();
}
