package br.edu.ifnmg.aplicacao_exemplo_spring.servicos;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.Usuario;

public interface UsuarioRepositorio 
    extends Repositorio<Usuario> {

    public Usuario Abrir(String login);
    
}
