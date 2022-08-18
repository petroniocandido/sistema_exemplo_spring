package br.edu.ifnmg.aplicacao_exemplo_spring.infraestrutura;

import org.springframework.stereotype.Component;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.UsuarioRepositorio;

@Component
public class UsuarioDAO 
    extends DAO<Usuario>
    implements UsuarioRepositorio {

    public UsuarioDAO() {
        super(Usuario.class);
    }
    
}
