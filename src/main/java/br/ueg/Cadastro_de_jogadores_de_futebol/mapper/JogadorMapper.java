package br.ueg.Cadastro_de_jogadores_de_futebol.mapper;

import br.ueg.api.mapper.BaseMapper;
import br.ueg.Cadastro_de_jogadores_de_futebol.dto.JogadorDTO;
import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JogadorMapper extends BaseMapper <Jogador, JogadorDTO> {

}