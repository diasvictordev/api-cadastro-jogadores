package br.ueg.Cadastro_de_jogadores_de_futebol.dto;

import jakarta.persistence.Column;
import lombok.Data;

public @Data class JogadorDTO {
    private Long id;
    private String nome;
    private String time;

    private String posicao;

    private Integer idade;
    private Integer numeroCamisa;
}
