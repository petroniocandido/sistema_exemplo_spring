package br.edu.ifnmg.aplicacao_exemplo_spring.aplicacao_exemplo_spring;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.Pessoa;
import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.PessoaFisica;
import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.PessoaFisicaRepositorio;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.UsuarioRepositorio;

@EntityScan("br.edu.ifnmg.aplicacao_exemplo_spring")
@ComponentScan("br.edu.ifnmg.aplicacao_exemplo_spring")
@SpringBootApplication
public class AplicacaoExemploSpringApplication
		implements CommandLineRunner {

	@Autowired
	PessoaFisicaRepositorio pessoas;

	@Autowired
	UsuarioRepositorio usuarios;

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoExemploSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Cria um objeto da entidade Pessoa
		/* 
		PessoaFisica p = new PessoaFisica();
		p.setNome("Petrônio");

		pessoas.Salvar(p);
		*/

		// Cria um objeto da entidade Usuario
		Usuario u = new Usuario();
		u.setLogin("petronio");
		u.setSenha("123");

		usuarios.Salvar(u);

		for(Usuario uu : usuarios.Buscar(null)){
			System.out.println(uu);
		}

		/* 
		// Inicializa o gerenciador de entidades
		EntityManager manager = factory.createEntityManager();

		//Cria uma transação 
		EntityTransaction t = manager.getTransaction();
		
		// Inicia a transação
		t.begin();

		// persiste a pessoa p no banco de dados
		manager.persist(p);

		// persiste o usuário u no banco de dados
		manager.persist(u);

		// Sincroniza as modificações no banco de dados
		manager.flush();

		// Termina a transação
		t.commit();


		p.add(new Telefone("38", "32212011"));

		EntityTransaction t2 = manager.getTransaction();
		t2.begin();
		manager.merge(p);
		manager.flush();
		t2.commit();
		*/

	}

}
