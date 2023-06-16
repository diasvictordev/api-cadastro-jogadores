package br.ueg.Cadastro_de_jogadores_de_futebol.mapper;

import br.ueg.Cadastro_de_jogadores_de_futebol.dto.JogadorDTO;
import br.ueg.Cadastro_de_jogadores_de_futebol.dto.JogadorDadosAlteraveisDTO;
import br.ueg.Cadastro_de_jogadores_de_futebol.dto.JogadorListaDTO;
import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JogadorMapper {

    public JogadorListaDTO toDTO(Jogador jogador);

    public List<JogadorListaDTO> toDTO(List<Jogador>jogadores);

    public JogadorDadosAlteraveisDTO toJogadorIncluirDTO(Jogador jogador);

    public Jogador toModelo(JogadorDadosAlteraveisDTO jogador);

    public JogadorDTO toJogadorDTO(Jogador jogador);
}
