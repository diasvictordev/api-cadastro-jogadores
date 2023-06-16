package br.ueg.Cadastro_de_jogadores_de_futebol.mapper;

import br.ueg.Cadastro_de_jogadores_de_futebol.dto.JogadorDTO;
import br.ueg.Cadastro_de_jogadores_de_futebol.dto.JogadorDadosAlteraveisDTO;
import br.ueg.Cadastro_de_jogadores_de_futebol.dto.JogadorListaDTO;
import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-15T21:57:27-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class JogadorMapperImpl implements JogadorMapper {

    @Override
    public JogadorListaDTO toDTO(Jogador jogador) {
        if ( jogador == null ) {
            return null;
        }

        JogadorListaDTO jogadorListaDTO = new JogadorListaDTO();

        jogadorListaDTO.setId( jogador.getId() );
        jogadorListaDTO.setNome( jogador.getNome() );
        jogadorListaDTO.setTime( jogador.getTime() );
        jogadorListaDTO.setPosicao( jogador.getPosicao() );
        jogadorListaDTO.setIdade( jogador.getIdade() );
        jogadorListaDTO.setNumeroCamisa( jogador.getNumeroCamisa() );

        return jogadorListaDTO;
    }

    @Override
    public List<JogadorListaDTO> toDTO(List<Jogador> jogadores) {
        if ( jogadores == null ) {
            return null;
        }

        List<JogadorListaDTO> list = new ArrayList<JogadorListaDTO>( jogadores.size() );
        for ( Jogador jogador : jogadores ) {
            list.add( toDTO( jogador ) );
        }

        return list;
    }

    @Override
    public JogadorDadosAlteraveisDTO toJogadorIncluirDTO(Jogador jogador) {
        if ( jogador == null ) {
            return null;
        }

        JogadorDadosAlteraveisDTO jogadorDadosAlteraveisDTO = new JogadorDadosAlteraveisDTO();

        jogadorDadosAlteraveisDTO.setNome( jogador.getNome() );
        jogadorDadosAlteraveisDTO.setTime( jogador.getTime() );
        jogadorDadosAlteraveisDTO.setPosicao( jogador.getPosicao() );
        jogadorDadosAlteraveisDTO.setIdade( jogador.getIdade() );
        jogadorDadosAlteraveisDTO.setNumeroCamisa( jogador.getNumeroCamisa() );

        return jogadorDadosAlteraveisDTO;
    }

    @Override
    public Jogador toModelo(JogadorDadosAlteraveisDTO jogador) {
        if ( jogador == null ) {
            return null;
        }

        Jogador jogador1 = new Jogador();

        jogador1.setNome( jogador.getNome() );
        jogador1.setTime( jogador.getTime() );
        jogador1.setPosicao( jogador.getPosicao() );
        jogador1.setIdade( jogador.getIdade() );
        jogador1.setNumeroCamisa( jogador.getNumeroCamisa() );

        return jogador1;
    }

    @Override
    public JogadorDTO toJogadorDTO(Jogador jogador) {
        if ( jogador == null ) {
            return null;
        }

        JogadorDTO jogadorDTO = new JogadorDTO();

        jogadorDTO.setId( jogador.getId() );
        jogadorDTO.setNome( jogador.getNome() );
        jogadorDTO.setTime( jogador.getTime() );
        jogadorDTO.setPosicao( jogador.getPosicao() );
        jogadorDTO.setIdade( jogador.getIdade() );
        jogadorDTO.setNumeroCamisa( jogador.getNumeroCamisa() );

        return jogadorDTO;
    }
}
