package br.ueg.Cadastro_de_jogadores_de_futebol.repository;

import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {


     Optional<Jogador> findJogadorById(Long Id);

     @Query(value="select count(j) from Jogador j where j.id = :IdExists")
     Integer countId (Long IdExists);

}
