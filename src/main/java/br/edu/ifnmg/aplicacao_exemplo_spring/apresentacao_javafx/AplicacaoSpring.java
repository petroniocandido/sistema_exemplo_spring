package br.edu.ifnmg.aplicacao_exemplo_spring.apresentacao_javafx;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javafx.application.Application;

@EntityScan("br.edu.ifnmg.aplicacao_exemplo_spring")
@ComponentScan("br.edu.ifnmg.aplicacao_exemplo_spring")
@SpringBootApplication
public class AplicacaoSpring {

    public static void main(String[] args) {
		Application.launch(AplicacaoJavaFX.class, args);
	}
    
}
