package br.ueg.Cadastro_de_jogadores_de_futebol.service.impl;

import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;
import br.ueg.Cadastro_de_jogadores_de_futebol.repository.JogadorRepository;
import br.ueg.api.service.BaseCrudService;
import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;
import br.ueg.Cadastro_de_jogadores_de_futebol.repository.JogadorRepository;
import br.ueg.Cadastro_de_jogadores_de_futebol.service.JogadorService;
import br.ueg.api.util.CollectionUtil;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JogadorServiceImpl extends BaseCrudService <Jogador, Long, JogadorRepository>
        implements  JogadorService{
    @Override
    protected void prepararParaIncluir (Jogador entidade) {

    }

    @Override
    protected void validarDados (Jogador entidade) {

    }

    @Override
    protected void validarCamposObrigatorios (Jogador entidade) {

    }

}
