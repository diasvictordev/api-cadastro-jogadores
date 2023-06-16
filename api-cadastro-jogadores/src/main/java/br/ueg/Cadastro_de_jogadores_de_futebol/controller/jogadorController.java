package br.ueg.Cadastro_de_jogadores_de_futebol.controller;



import br.ueg.Cadastro_de_jogadores_de_futebol.dto.JogadorDTO;
import br.ueg.Cadastro_de_jogadores_de_futebol.dto.JogadorDadosAlteraveisDTO;
import br.ueg.Cadastro_de_jogadores_de_futebol.dto.JogadorListaDTO;
import br.ueg.Cadastro_de_jogadores_de_futebol.mapper.JogadorMapper;
import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;
import br.ueg.Cadastro_de_jogadores_de_futebol.service.JogadorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping (path="${app.api.base}/jogador")

public class jogadorController {

    @Autowired
    private JogadorMapper jogadorMapper;

    @Autowired
    private JogadorService jogadorService;

    @GetMapping(path = "/listar")
    @Operation(description = "Lista de Jogadores Cadastrados")
    public List<JogadorListaDTO> listAll() {
        List<Jogador> jogadores = jogadorService.listarTodos();

        return this.jogadorMapper.toDTO(jogadores);
    }

    @PostMapping
    @Operation(description = "Método utilizado para realizar a inclusão de um novo jogador")
    public JogadorDTO incluir(@RequestBody JogadorDadosAlteraveisDTO jogador){
        //preparação para entreda
        Jogador jogadorIncluir = this.jogadorMapper.toModelo(jogador);

        //chamada do serviço
        System.out.println(jogadorIncluir);
        jogadorIncluir.setId(2L);

        //preparação para o retorno
        JogadorDTO retorno = this.jogadorMapper.toJogadorDTO(jogadorIncluir);
        return retorno;
    }

    @PutMapping(path = "/{id}")
    @Operation(description = "Método utilizado para alterar")
    public JogadorDTO alterar(@RequestBody() JogadorDadosAlteraveisDTO jogador, @PathVariable(name = "id") Long id ){
        Jogador pJogador = jogadorMapper.toModelo(jogador);
        Jogador alterar = jogadorService.alterar(pJogador, id);
        return jogadorMapper.toJogadorDTO(alterar);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(description = "Método utilizado para remover jogadores")
    public JogadorDTO remover(@PathVariable(name="id") Long id){
        Jogador jogadorExcluido = this.jogadorService.excluir(id);
        return jogadorMapper.toJogadorDTO(jogadorExcluido);
    }
}
