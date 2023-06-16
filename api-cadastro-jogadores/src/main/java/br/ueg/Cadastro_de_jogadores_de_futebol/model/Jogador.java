package br.ueg.Cadastro_de_jogadores_de_futebol.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import java.sql.Date;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name="tbl_jogador")
public class Jogador {
    @SequenceGenerator(
            name="jogador_sequence",
            sequenceName = "jogador_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "jogador_sequence"
    )
    @Id
    @Column(name= "codigo_jogador")
    private Long id;
    @Column(name ="nome_jogador", length = 200, nullable = false)
    private String nome;
    @Column(name ="time_jogador",length = 200, nullable = false )
    private String time;
    @Column(name ="posicao_jogador",length = 200, nullable = false)
    private String posicao;
    @Column(name ="idade_jogador", nullable = false)

    private Integer idade;
    @Column(name ="camisa_jogador", nullable = false)
    private Integer numeroCamisa;
    @Column(name ="fim_contrato")

    private LocalDate fimContrato;

    @Column(name ="status_contrato")
    private String statusContrato;
}
