package br.ueg.api.controller;

import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;
import br.ueg.api.exception.MessageResponse;
import br.ueg.api.mapper.BaseMapper;
import br.ueg.api.model.IEntidade;
import br.ueg.api.service.CrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public abstract class CrudController<
            ENTIDADE extends IEntidade<PK_TYPE>,
            DTO,
            PK_TYPE,
            MAPPER extends BaseMapper<ENTIDADE, DTO>,
            SERVICE extends CrudService<ENTIDADE, PK_TYPE>
            > {

        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        @Autowired
        protected MAPPER mapper;

        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        @Autowired
        protected SERVICE service;

        @GetMapping()
        @Operation(description = "Listagem Geral", responses = {
                @ApiResponse(responseCode = "200", description = "Listagem geral",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                array = @ArraySchema())),
                @ApiResponse(responseCode = "404", description = "Registro não encontrado",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = MessageResponse.class))),
                @ApiResponse(responseCode = "403", description = "Acesso negado",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = MessageResponse.class))),
                @ApiResponse(responseCode = "400", description = "Erro de Negócio",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = MessageResponse.class)))
        })
        public ResponseEntity<List<DTO>> listAll(){
            List<ENTIDADE> modelo = service.listarTodos();
            return ResponseEntity.ok(mapper.toDTO(modelo));
        }

        @PostMapping
        @Operation(description = "Método utilizado para realizar a inclusão de um entidade", responses = {
                @ApiResponse(responseCode = "200", description = "Entidade Incluida",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(responseCode = "403", description = "Acesso negado",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = MessageResponse.class))),
                @ApiResponse(responseCode = "400", description = "Erro de Negócio",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = MessageResponse.class)))
        })
        public ResponseEntity<DTO> incluir(@RequestBody DTO modeloDTO){
            //prepração para entrada.
            ENTIDADE modeloIncluir = this.mapper.toModelo(modeloDTO);
            modeloIncluir.setId(null);
            //chamada do serviço
            System.out.println(modeloIncluir);
            modeloIncluir = this.service.incluir(modeloIncluir);

            //preparação para o retorno
            return ResponseEntity.ok(this.mapper.toDTO(modeloIncluir));
        }

        @PutMapping(path = "/{id}")
        @Operation(description = "Método utilizado para altlerar os dados de uma entidiade", responses = {
                @ApiResponse(responseCode = "200", description = "Listagem geral",
                        content = @Content(
                                mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(responseCode = "404", description = "Registro não encontrado",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = MessageResponse.class))),
                @ApiResponse(responseCode = "403", description = "Acesso negado",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = MessageResponse.class))),
                @ApiResponse(responseCode = "400", description = "Erro de Negócio",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = MessageResponse.class)))
        }
        )
        public ResponseEntity<DTO> alterar(@RequestBody() DTO modeloDTO, @PathVariable(name = "id") PK_TYPE id
        ){
            ENTIDADE pModelo = mapper.toModelo(modeloDTO);
            ENTIDADE alterar = service.alterar(pModelo, id);
            return ResponseEntity.ok(mapper.toDTO(alterar));
        }
    @DeleteMapping(path ="/{id}")
    @Operation(description = "Método utilizado para remover uma entidiade pela id informado")
    public DTO remover(@PathVariable(name = "id") PK_TYPE id){
        ENTIDADE modeloExcluido = this.service.excluir(id);
        return mapper.toDTO(modeloExcluido);
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "Obter os dados completos de uma entidiade pelo id informado!")
    public DTO ObterPorId(@PathVariable(name = "id") PK_TYPE id){
        ENTIDADE aluno = this.service.obterPeloId(id);
        return this.mapper.toDTO(aluno);
    }

    }

