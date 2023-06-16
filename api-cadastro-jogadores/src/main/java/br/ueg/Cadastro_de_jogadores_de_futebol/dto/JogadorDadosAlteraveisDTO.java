package br.ueg.Cadastro_de_jogadores_de_futebol.dto;

import lombok.Data;

public @Data class JogadorDadosAlteraveisDTO {
    private String nome;
    private String time;

    private String posicao;

    private Integer idade;
    private Integer numeroCamisa;
}
