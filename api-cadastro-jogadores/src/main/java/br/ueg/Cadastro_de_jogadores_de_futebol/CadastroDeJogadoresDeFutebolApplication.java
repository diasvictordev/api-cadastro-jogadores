package br.ueg.Cadastro_de_jogadores_de_futebol;

import br.ueg.Cadastro_de_jogadores_de_futebol.model.Jogador;
import br.ueg.Cadastro_de_jogadores_de_futebol.repository.JogadorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CadastroDeJogadoresDeFutebolApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeJogadoresDeFutebolApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(JogadorRepository jogadorRepository){
		return args -> {
			System.out.println(jogadorRepository);
			Jogador j1 = new Jogador();
			j1.setNome("Lionel Messi");
			j1.setIdade(35);
			j1.setId(1L);
			j1.setPosicao("Atacante");
			j1.setTime("Paris Saint Germain");
			j1.setNumeroCamisa(30);
			jogadorRepository.save(j1);
			System.out.println("Jogador"+j1);
			List<Jogador> lista = jogadorRepository.findAll();
			lista.forEach(item ->{
				System.out.println("Jogador" + item);
			});
			Optional<Jogador> jogadorNomeLocalizado = jogadorRepository.findJogadorById(j1.getId());
			Integer totalId = jogadorRepository.countId(j1.getId());
			if(totalId>0){
				System.out.println("O jogador já existe");
			}
			else{
				jogadorRepository.save(j1);
			}


		};
	}
}
