package br.ueg.Cadastro_de_jogadores_de_futebol.controller;


import br.ueg.api.controller.CrudController;
import br.ueg.Cadastro_de_jogadores_de_futebol.dto.JogadorDTO;
import br.ueg.Cadastro_de_jogadores_de_futebol.mapper.JogadorMapper;
import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;
import br.ueg.Cadastro_de_jogadores_de_futebol.service.JogadorService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = "Jogador API")
@RestController
@RequestMapping(path = "${app.api.base}/jogador")
public class jogadorController extends CrudController
        <Jogador, JogadorDTO, Long, JogadorMapper, JogadorService >{
}
