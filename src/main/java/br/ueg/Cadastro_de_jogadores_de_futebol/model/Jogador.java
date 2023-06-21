package br.ueg.Cadastro_de_jogadores_de_futebol.model;

import br.ueg.api.model.IEntidade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import java.sql.Date;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name="tbl_jogador",
        uniqueConstraints = {
                @UniqueConstraint(name= Jogador.UK_JOGADOR, columnNames = "codigo_jogador")
        })
public class Jogador implements IEntidade<Long> {
    public static final String UK_JOGADOR = "uk_jogador";
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
    @Column(name ="time_jogador",length = 200)
    private String time;
    @Column(name ="posicao_jogador",length = 200)
    private String posicao;
    @Column(name ="idade_jogador")

    private Integer idade;
    @Column(name ="camisa_jogador")
    private Integer numeroCamisa;
    @Column(name ="fim_contrato")

    private LocalDate fimContrato;

    @Column(name ="status_contrato")
    private String statusContrato;


    @Override
    public String getTabelaNome() {

        return UK_JOGADOR;
    }

    @Override
    public Long getId(){
        return id;
    }
    @Override
    public void setId(Long id) {

        this.id = id;
    }
}
